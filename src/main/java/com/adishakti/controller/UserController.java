package com.adishakti.controller;

import java.time.LocalDate;
import java.time.LocalTime;
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

import com.adishakti.entity.Blog;
import com.adishakti.entity.User;
import com.adishakti.exception.UserAlreadyExistsException;
import com.adishakti.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
@PostMapping
public ResponseEntity<?> insertUser(@RequestBody User user){
	User createdUser = userService.saveUser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.OK);
	
	//return null;
	
}
    
    @PostMapping("/sk")
    public ResponseEntity<?> createUser(
    		@RequestParam("firstName") String firstName,
    		@RequestParam("lastName") String lastName,
    		@RequestParam("email") String email,
    		@RequestParam("password") String password,
    		@RequestParam("dob") LocalDate dob,
    		@RequestParam("city") String city,
    		@RequestParam("district") String district,
    		@RequestParam("state") String state,
    		@RequestParam("country") String country,
    		@RequestParam("pinCode") String pinCode,
    		@RequestParam("mobileNumber") String mobileNumber,
    		@RequestParam("gender") String gender,
    		@RequestParam("birthPlace") String birthPlace,
    		@RequestParam("birthTime") LocalTime birthTime,
    		@RequestParam("profile_img") MultipartFile profile_img,
    		@RequestParam("role") String role
    		)
    		{
    	try {
    		User user=new User();
    		user.setFirstName(firstName);
    		user.setLastName(lastName);
    		user.setEmail(email);
    		user.setPassword(password);
    		user.setDob(dob);
    		user.setCity(city);
    		user.setDistrict(district);
    		user.setState(state);
    		user.setCountry(country);
    		user.setPinCode(pinCode);
    		user.setMobileNumber(mobileNumber);
    		user.setGender(gender);
    		user.setBirthPlace(birthPlace);
    		user.setBirthTime(birthTime);
    		user.setProfile_img(profile_img.getBytes());
    		user.setRole(role);
    		
    		User createdUser = userService.saveUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
    	}catch (Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
//    @PostMapping
//    public ResponseEntity<?> createUser(@RequestBody User user) {
//        try {
//            User createdUser = userService.saveUser(user);
//            return ResponseEntity.ok(createdUser);
//        } catch (UserAlreadyExistsException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
