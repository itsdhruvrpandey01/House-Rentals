package com.house.rental.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ClassPathResource;

import com.house.rental.dao.PropertyRepository;
import com.house.rental.dao.UserRepository;
import com.house.rental.entity.Property;
import com.house.rental.entity.User;

import jakarta.servlet.http.HttpSession;



@Controller
public class homecontroller {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;

	//default page 
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "Home-House Rentals");
		return "base";
	}
	
	// for profile page 
	@GetMapping("/profile")
	public String profile(Model m,HttpSession session) {
		String userName = (String)session.getAttribute("userEmail");
		if(userName==null) return "login";

		User user = userRepository.getUserByName(userName);
		m.addAttribute("profile", "profile-House Rentals");
		m.addAttribute("u",user);
		return "profile";
	}
	
	// for chatting between users
	@GetMapping("/yourprop")
	public String chat(Model m,HttpSession session) {
		String userName = (String)session.getAttribute("userEmail");
		if(userName==null) return "login";

		User user = userRepository.getUserByName(userName);
	    List<Property> userProperties = propertyRepository.findByUser(user);
	    for (Property P:userProperties) {
	    	System.out.println(P.getArea());
	    }
	    m.addAttribute("property", userProperties);
	    return "yourprop";
	}
	
	
	// sign up page 
	@GetMapping("/signup")
	public String signup(Model m) {	
		m.addAttribute("User", new User());
		return "signup";
	}
	
	@PostMapping("/doRegister")
	public String doRegisterUser(@ModelAttribute User user) {
		//TODO: process POST request
		user.setActive(true);
		User result1 = this.userRepository.save(user);
		System.out.println(result1);
		return "login";
	}
	
	
	// login page 
	@GetMapping("/signin")
	public String customLogin(Model model) {
		model.addAttribute("title","Login page");
		return "login";
	}
	
	@GetMapping("/searchfilter")
	public String getSearchResults() {
		return "searchfilter";
	}
	
	@GetMapping("/about")
	public String getAboutUs() {
		return "aboutus";
	}
	
	@GetMapping("/contactus")
	public String getContanctUs() {
		return "contactus";
	}
	
	@GetMapping("/feedback")
	public String getFeedBack() {
		return "feedback";
	}
	
	@GetMapping("/faq")
	public String getFaq() {
		return "faq";
	}
	
	@GetMapping("/privacy")
	public String getPolicy() {
		return "privacy";
	}
	
	@GetMapping("/privacypolicy")
	public String getPrivacyPolicy() {
		return "privacypolicy";
	}
	
	@GetMapping("/termsandcondition")
	public String getTandC() {
		return "termsandcondition";
	}
	
	
	// for getting upload property form
	@GetMapping("/upload_property")
	public String getUploadForm(Model model,HttpSession session) {
		String userName = (String)session.getAttribute("userEmail");
		if(userName==null) return "login";
		// title for the page
		model.addAttribute("Title", "Upload Property");
		// adding property object to model for using when uploading it with the help of handler
		model.addAttribute("Property", new Property());
		return "normal/upload_property";
	}
	
	// handler for uploading the property
		@PostMapping("property-upload")
		public String postMethodName(@ModelAttribute Property property,
				@RequestParam("mbedroom_1") MultipartFile bedroom1,
		        @RequestParam("mbedroom_2") MultipartFile bedroom2,
		        @RequestParam("mkitchen") MultipartFile kitchen,
		        @RequestParam("mbalcony") MultipartFile balcony,
		        @RequestParam("mbathroom") MultipartFile bathroom,
		        @RequestParam("mhall") MultipartFile hall,
		        @RequestParam("mvideo") MultipartFile video,HttpSession session) {
			String userName = (String)session.getAttribute("userEmail");
			User user = userRepository.getUserByName(userName);
			property.setUser(user);
			try {
				if (!bedroom1.isEmpty()) { 
					File saveFile = new ClassPathResource("static/images").getFile();
				    property.setBedroom_1(bedroom1.getOriginalFilename()); 
				    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + bedroom1.getOriginalFilename());
				    Files.copy(bedroom1.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} else {
				    property.setBedroom_1("default.png");
				}

				if (!bedroom2.isEmpty()) { 
					File saveFile = new ClassPathResource("static/images").getFile();
				    property.setBedroom_2(bedroom2.getOriginalFilename()); 
				    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + bedroom2.getOriginalFilename());
				    Files.copy(bedroom2.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} else {
				    property.setBedroom_2("default.png");
				}

				if (!kitchen.isEmpty()) { 
					File saveFile = new ClassPathResource("static/images").getFile();
				    property.setKitchen(kitchen.getOriginalFilename()); 
				    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + kitchen.getOriginalFilename());
				    Files.copy(kitchen.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} else {
				    property.setKitchen("default.png");
				}

				if (!balcony.isEmpty()) { 
					File saveFile = new ClassPathResource("static/images").getFile();
				    property.setBalcony(balcony.getOriginalFilename()); 
				    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + balcony.getOriginalFilename());
				    Files.copy(balcony.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} else {
				    property.setBalcony("default.png");
				}

				if (!bathroom.isEmpty()) {
					File saveFile = new ClassPathResource("static/images").getFile();
				    property.setBathroom(bathroom.getOriginalFilename()); 
				    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + bathroom.getOriginalFilename());
				    Files.copy(bathroom.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} else {
				    property.setBathroom("default.png");
				}

				if (!hall.isEmpty()) { 
					File saveFile = new ClassPathResource("static/images").getFile();
				    property.setHall(hall.getOriginalFilename()); 
				    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + hall.getOriginalFilename());
				    Files.copy(hall.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} else {
				    property.setHall("default.png");
				}

				if (!video.isEmpty()) { 
					File saveFile = new ClassPathResource("static/images").getFile();
				    property.setVideo(video.getOriginalFilename()); 
				    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + video.getOriginalFilename());
				    Files.copy(video.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} else {
				    property.setVideo("default.mp4");  // You can change this default filename as needed
				}
				
				user.getProperty().add(property);
				this.userRepository.save(user);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "normal/upload_property";
		}
		
		// to update property details
		@PostMapping("update/{property_id}")
		public String updatePropertyDetials(@PathVariable("property_id") int id,Model m) {
			Property property = this.propertyRepository.findById(id).get();
			m.addAttribute("property",property);
			return "normal/update_property_form";
		}
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/comparison")
	public String getCompare() {
		return "comaprison";
	}
	@GetMapping("/property/delete/{id}")
	public String deleteProperty(@PathVariable("id") int id, HttpSession session) {
	    // Optional: Check user authentication if needed
	    try {
	        propertyRepository.deleteById(id);
	    } catch (Exception e) {
	        System.out.println("cannot delete");
	    }

	    return "redirect:/yourprop"; // redirect to your properties list
	}
	
	@GetMapping("/admin")
    public String viewAllUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin";  // points to `users.html` under `templates/admin/`
    }
	
	@PostMapping("/admin/user/status/{id}")
	public String changeUserStatus(@PathVariable("id") int id, @RequestParam("status") boolean status) {
	    Optional<User> optionalUser = userRepository.findById(id);
	    if (optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        user.setActive(status);
	        userRepository.save(user);
	    }
	    return "redirect:/admin"; // or wherever your users list page is
	}
	
}
