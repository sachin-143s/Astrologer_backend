package com.adishakti.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adishakti.entity.Astrologer;
import com.adishakti.entity.Blog;
import com.adishakti.entity.BlogCatagory;
import com.adishakti.service.BlogService;

@RestController
@CrossOrigin
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/df")
    public ResponseEntity<Blog> createBlog(
    		@RequestParam("id") Long id,
    		@RequestParam("title") String title,
    		@RequestParam("featuredImage") MultipartFile featuredImage,
    		@RequestParam("content") String content,
    		@RequestParam BlogCatagory blogCatagory
    		)
    		{
    	try {
    		Blog blog=new Blog();
    		blog.setId(id);
    		blog.setTitle(title);
    		blog.setFeaturedImage(featuredImage.getBytes());
    		blog.setContent(content);
    		blog.setBlogCatagory(blogCatagory);
    		return new ResponseEntity<>(blogService.saveBlog(blog), HttpStatus.OK);
    		}
    	catch (Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
  
    @PostMapping
   public Blog createBlog(@RequestBody Blog blog) {
        return blogService.saveBlog(blog);
       }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }
    @GetMapping("/helth")
    public List<Blog> getHelthData(){
    	List<Blog> arr=blogService.getAllBlogs();
    	List<Blog> arr1=new ArrayList<>();
    	for(Blog bl:arr) {
    		if(bl.getBlogCatagory()==BlogCatagory.HEALTH) {
    			arr1.add(bl);
    		}
    	}
    	return arr1;
    }
    @GetMapping("/tecnology")
    public List<Blog> getTecnologyData(){
    	List<Blog> arr=blogService.getAllBlogs();
    	List<Blog> arr1=new ArrayList<>();
    	for(Blog bl:arr) {
    		if(bl.getBlogCatagory()==BlogCatagory.TECNOLOGY) {
    			arr1.add(bl);
    		}
    	}
    	return arr1;
    }
    @GetMapping("/lifestyle")
    public List<Blog> getLIFESTYLEData(){
    	List<Blog> arr=blogService.getAllBlogs();
    	List<Blog> arr1=new ArrayList<>();
    	for(Blog bl:arr) {
    		if(bl.getBlogCatagory()==BlogCatagory.LIFESTYLE) {
    			arr1.add(bl);
    		}
    	}
    	return arr1;
    }
    @GetMapping("/education")
    public List<Blog> getEDUCATIONData(){
    	List<Blog> arr=blogService.getAllBlogs();
    	List<Blog> arr1=new ArrayList<>();
    	for(Blog bl:arr) {
    		if(bl.getBlogCatagory()==BlogCatagory.EDUCATION) {
    			arr1.add(bl);
    		}
    	}
    	return arr1;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Optional<Blog> blog = blogService.getBlogById(id);
        return blog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok().build();
    }
}

