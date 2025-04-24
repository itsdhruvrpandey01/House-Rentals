package com.house.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.house.rental.dao.PropertyRepository;
import com.house.rental.dao.UserRepository;
import com.house.rental.entity.User;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller

public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@ModelAttribute
	public void commonData(Model model,HttpSession session) {
		String userName = (String)session.getAttribute("userEmail");
		User user = userRepository.getUserByName(userName);
		model.addAttribute("user",user);
	}
	
	@PostMapping("/doLogin")
	public String postMethodName(@RequestParam("email") String email,
            @RequestParam("otp") int otp,
            HttpSession session,Model m) {
        
        // Retrieve OTP stored in the session
        int sessionOtp = (int)session.getAttribute("myotp");
        String sessionEmail = (String) session.getAttribute("email");

        // Validate OTP
        if (( sessionOtp == otp) && sessionEmail != null && sessionEmail.equals(email)) {
        	session.setAttribute("userEmail", email);
            return "home";
        } else {
        	m.addAttribute("message", "otp does not match please enter correct otp");
        	m.addAttribute("email",email);
            return "login";
        }
	}
}
