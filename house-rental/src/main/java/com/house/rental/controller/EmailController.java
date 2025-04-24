package com.house.rental.controller;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.house.rental.dao.PropertyRepository;
import com.house.rental.dao.UserRepository;
import com.house.rental.entity.Property;
import com.house.rental.entity.User;
import com.house.rental.helper.Message;
import com.house.rental.service.EmailService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@PostMapping("/login-otp")
	public ResponseEntity<String> sendLoginOtp(@RequestParam("email") String email,HttpSession session) {
		String userName = email;
		User user = userRepository.getUserByName(userName);
		if(user==null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Id doesnot exists. Please enter the regristed one.");
		System.out.println("otp module");
		Random random = new Random();
		int otp = 1000 + random.nextInt(9999);
		System.out.println(otp);
		
		String subject = "OTP for Login into your account do not please do not share";
		String message = "OTP = "+otp;
		String to = email;
		boolean f = this.emailService.sendEmail(subject, message, to);
		if(f) {
			session.setAttribute("myotp",otp);
            session.setAttribute("email",email);
            return ResponseEntity.ok("OTP sent! Check your email.");
	   }else {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send OTP. Please try again.");
		}
	}
	
	@PostMapping("/send-otp")
	public ResponseEntity<String> sendOtp(@RequestParam("email") String email,HttpSession session) {
		System.out.println("otp module");
		Random random = new Random();
		int otp = 1000 + random.nextInt(9999);
		System.out.println(otp);
		
		String subject = "OTP for Login into your account do not please do not share";
		String message = "OTP = "+otp;
		String to = email;
		boolean f = this.emailService.sendEmail(subject, message, to);
		if(f) {
			session.setAttribute("myotp",otp);
            session.setAttribute("email",email);
            return ResponseEntity.ok("OTP sent! Check your email.");
	   }else {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send OTP. Please try again.");
		}
	}
	@PostMapping("/feedback/send")
	public ResponseEntity<String> sendFeedBack(@RequestParam String name, 
            @RequestParam String email, 
            @RequestParam String feedbackType, 
            @RequestParam String feedback) {
		String subject = "FeedBack for "+feedbackType;
		String message = "Name: " + name + "\nEmail: " + email + "\nFeedback Type: " + feedbackType + "\n\nFeedback: " + feedback;
		String to = "psneha406@gmail.com";
		boolean f = this.emailService.sendEmail(subject, message, to);
		if(f) {
            return ResponseEntity.ok("Thanks for Sharing the Feed Back.");
	   }else {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send OTP. Please try again.");
		}
	}
	
	@PostMapping("/sendEnquiry")
	public ResponseEntity<String> sendEnquiry(@RequestParam("uid") int propertyId,
	                                          @RequestParam("userType") String userType,
	                                          @RequestParam("name") String name,
	                                          @RequestParam("email") String email,
	                                          @RequestParam("phone") String phone,
	                                          @RequestParam("additional") String additional) {
	    // Step 1: Retrieve the property by ID
	    Optional<Property> optionalProperty = propertyRepository.findById(propertyId);
	    if (!optionalProperty.isPresent()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("Invalid property ID.");
	    }

	    Property property = optionalProperty.get();

	    // Step 2: Retrieve dealer email from property
	    String dealerEmail = property.getUser().getU_email();  // adjust getter if needed

	    // Step 3: Build the subject and message
	    String subject = "Enquiry from " + userType + " (" + name + ")";
	    String message = "Property ID: " + propertyId + "\n" +
	                     "User Type: " + userType + "\n" +
	                     "Name: " + name + "\n" +
	                     "Email: " + email + "\n" +
	                     "Phone: " + phone + "\n" +
	                     "Additional Notes: " + additional;

	    // Step 4: Send the email
	    boolean emailSent = this.emailService.sendEmail(subject, message, dealerEmail);

	    if (emailSent) {
	        return ResponseEntity.ok("Your enquiry has been sent successfully.");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Failed to send the enquiry. Please try again.");
	    }
	}

	 @PostMapping("/verify-otp")
	    public ResponseEntity<String> verifyOtp(
	            @RequestParam("email") String email,
	            @RequestParam("otp") int otp,
	            HttpSession session) {
	        
	        // Retrieve OTP stored in the session
	        int sessionOtp = (int)session.getAttribute("myotp");
	        String sessionEmail = (String) session.getAttribute("email");

	        // Validate OTP
	        if (( sessionOtp == otp) && sessionEmail != null && sessionEmail.equals(email)) {
	            return ResponseEntity.ok("OTP Verified");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
	        }
	    }
}
