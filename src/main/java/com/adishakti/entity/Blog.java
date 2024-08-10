package com.adishakti.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="blogtbl")
public class Blog {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(length = 40)
    private String title;
    @Lob
    @Column(length = 10_000_000)
    private byte[] featuredImage;
    @Column(length = 1000)
    private String content;
    private BlogCatagory blogCatagory;
    @ManyToOne()
    @JoinColumn(name = "astrologer_id")
    private Astrologer astrologer;

	public Blog() {
		super();
	}

	

	public Blog(Long id, String title, byte[] featuredImage, String content, BlogCatagory blogCatagory,
			Astrologer astrologer) {
		super();
		this.id = id;
		this.title = title;
		this.featuredImage = featuredImage;
		this.content = content;
		this.blogCatagory = blogCatagory;
		this.astrologer = astrologer;
	}



	public BlogCatagory getBlogCatagory() {
		return blogCatagory;
	}



	public void setBlogCatagory(BlogCatagory blogCatagory) {
		this.blogCatagory = blogCatagory;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(byte[] featuredImage) {
		this.featuredImage = featuredImage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Astrologer getAstrologer() {
		return astrologer;
	}

	public void setAstrologer(Astrologer astrologer) {
		this.astrologer = astrologer;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", featuredImage=" + Arrays.toString(featuredImage)
				+ ", content=" + content + ", astrologer=" + astrologer + "]";
	}
	
	
    
    
    
    
    
//	public Blog() {
//		super();
//	}
//
//	public Blog(Long id, String title, String featuredImage, String content, Astrologer astrologer) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.featuredImage = featuredImage;
//		this.content = content;
//		this.astrologer = astrologer;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getFeaturedImage() {
//		return featuredImage;
//	}
//
//	public void setFeaturedImage(String featuredImage) {
//		this.featuredImage = featuredImage;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public Astrologer getAstrologer() {
//		return astrologer;
//	}
//
//	public void setAstrologer(Astrologer astrologer) {
//		this.astrologer = astrologer;
//	}
//
//	@Override
//	public String toString() {
//		return "Blog [id=" + id + ", title=" + title + ", featuredImage=" + featuredImage + ", content=" + content
//				+ ", astrologer=" + astrologer + "]";
//	}

    
}

