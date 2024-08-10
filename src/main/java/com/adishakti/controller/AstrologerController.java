package com.adishakti.controller;

import java.io.IOException;
import java.sql.Date;

import java.time.LocalDate;
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
import com.adishakti.entity.AstrologerImages;
import com.adishakti.entity.Blog;
import com.adishakti.service.AstrologerService;

@CrossOrigin
@RestController
@RequestMapping("/api/astrologers")
public class AstrologerController {
    @Autowired
    private AstrologerService astrologerService;
    
  /*  
    @PostMapping("/inse")
    public ResponseEntity<Astrologer> createAstrologer(
    		@RequestParam("id") Long id,
    		@RequestParam("firstName") String firstName,
    		@RequestParam("lastName") String lastName,
    		@RequestParam("dob") Date dob,
    		@RequestParam("password") String password,
    		@RequestParam("mobile") String mobile,
    		@RequestParam("aadharNumber") String aadharNumber,
    		@RequestParam("rate") Long rate,
    		@RequestParam("gender") String gender,
    		@RequestParam("experience") Integer experience,
    		@RequestParam("languagesKnown") List<String> languagesKnown,
    		@RequestParam("skills") List<String> skills,
    		@RequestParam("email") String email,
    		@RequestParam("city") String city,
    		@RequestParam("district") String district,
    		@RequestParam("state") String state,
    		@RequestParam("country") String country,
    		@RequestParam("pinCode") String pinCode,
    		@RequestParam("profile_img") MultipartFile profile_img,
    		@RequestParam("ratePerMinute") Double ratePerMinute,
    		@RequestParam("certification") String certification,
    		@RequestParam("degree") String degree
    		)
    		{
    	try {
    		Astrologer astrologer=new Astrologer();
    		astrologer.setId(id);
    		astrologer.setFirstName(firstName);
    		astrologer.setLastName(lastName);
    		astrologer.setMobile(mobile);
    		astrologer.setAadharNumber(aadharNumber);
    		astrologer.setDob(dob);
    		astrologer.setRateIng(rate);
    		astrologer.setGender(gender);
    		astrologer.setExperience(experience);
    		astrologer.setLanguagesKnown(languagesKnown);
    		astrologer.setSkills(skills);
    		astrologer.setEmail(email);
    		astrologer.setCity(city);
    		astrologer.setDistrict(district);
    		astrologer.setState(state);
    		astrologer.setPassword(password);
    		astrologer.setCountry(country);
    		astrologer.setPinCode(pinCode);
    		AstrologerImages astrologerImages=new AstrologerImages();
    		astrologerImages=astrologerService.insertAisro(profile_img, astrologerImages);
    		astrologer.setAstrologerImages(astrologerImages);
    		astrologer.setRatePerMinute(ratePerMinute);
    		astrologer.setCertification(certification);
    		astrologer.setDegree(degree);
    		
    		return new ResponseEntity<>(astrologerService.saveAstrologer(astrologer), HttpStatus.OK);
    		}
    	catch (Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    */
   @PostMapping("/convert-image")
   public AstrologerImages convertImgToByte(@RequestParam("image") MultipartFile profile_img) throws IOException {
   	 AstrologerImages astrologerImages=new AstrologerImages();
   //	astrologerImages.setId(11l);
	astrologerImages=astrologerService.convertToByte(profile_img, astrologerImages);
	return astrologerImages;
   }
    @GetMapping("/get-by-id/{id}")
    public AstrologerImages astr(@PathVariable("id") Long id) {
    	return astrologerService.getByAustId(id).getAstrologerImages();
    }
   @PostMapping
    public Astrologer createAstrologer(@RequestBody Astrologer astrologer) {
       return astrologerService.saveAstrologer(astrologer);
   }
    
    @GetMapping("/get-astrologers")
    public List<Astrologer> getAllAstrologers() {
        return astrologerService.getAllAstrologers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Astrologer> getAstrologerById(@PathVariable Long id) {
        Optional<Astrologer> astrologer = astrologerService.getAstrologerById(id);
        return astrologer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/email/{email}")
    public Astrologer getAstrologerByEmail(@PathVariable String email) {
        return astrologerService.getAstrologerByEmail(email);
    }
    @GetMapping("/get-data/{st1}")
    public List<Astrologer> getAst(@PathVariable("st1") String st1){
    
    	 List<Astrologer>str=astrologerService.getAllAstrologers();
    	 List<Astrologer>str11=new ArrayList<>();
         for(Astrologer st:str){
             if(st.getFirstName().length()>=st1.length()){
             
                 if(st.getFirstName().length()>=st1.length()){
                   
                     if(st.getFirstName().substring(0,st1.length()).equalsIgnoreCase(st1))
                         str11.add(st);
                 }
               }       
             if(st.getLastName().length()>=st1.length()){
                 
                 if(st.getLastName().length()>=st1.length()){
                   
                     if(st.getLastName().substring(0,st1.length()).equalsIgnoreCase(st1))
                         str11.add(st);
                 }
               }
             }           
             
              return str11;
             
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAstrologer(@PathVariable Long id) {
        astrologerService.deleteAstrologer(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/insert")
    public Astrologer insertData(@RequestBody Astrologer astrologer) {
    	astrologer= astrologerService.saveAstrologer(astrologer);
    	return astrologer;
    }
}
