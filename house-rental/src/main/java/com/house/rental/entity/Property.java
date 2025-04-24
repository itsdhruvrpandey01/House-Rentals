package com.house.rental.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PROPERTY")
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int property_id;
	
	@NotBlank
	private String propertyType;
	
	//location details 
	@NotBlank
	private String city;
	@NotBlank
	private String locality;
	@NotBlank
	private String sub_locality;
	@NotBlank
	private String property_addr;
	// optional
	private int house_number = 0;
	
	// basic details 
	private int no_of_bedrooms = 0;
	private int no_of_bathrooms = 0;
	private int no_of_balconies = 0;
	
	// area 
	@NotNull
	private int area;
	@NotBlank
	private String carpet_area;
	
	// furnishing details 
	private String furnishing_type;
	private int light = 0;
	private int fans = 0;
	private int tv = 0;
	private int beds = 0;
	private int wardrobe = 0;
	private int geyser = 0;
	// check boxes so it needs explicit requests
	
	private int sofa = 0;
	private int washing_machine = 0;
	private int stove = 0;
	private int fridge = 0;
	private int water_purifier = 0;
	private int microwave = 0;
	private int modular_kitched = 0;
	private int chimney = 0;
	private int dinning_table = 0;
	private int curtains = 0;
	private int exhaust_fan = 0;
	
	// floor details 
	@NotNull
	private int total_floors;
	@NotNull
	private int your_floor;
	
//	age of property 
	private int age_of_property;
	private int rent_price;
	
//	photos
	private String bedroom_1;
	private String bedroom_2;
	private String kitchen;
	private String balcony;
	private String bathroom;
	private String hall;
	private String video;
	
	// optional details
	private String Security_deposit;
	private String monthNotice;
	private String restrictions;
	private String features;
	
	
	// features that will apply after uploading 
	private int likes = 0;
	private int interested_people = 0;
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getInterested_people() {
		return interested_people;
	}
	public void setInterested_people(int interested_people) {
		this.interested_people = interested_people;
	}
	@ManyToOne
	@JsonIgnore
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getSub_locality() {
		return sub_locality;
	}
	public void setSub_locality(String sub_locality) {
		this.sub_locality = sub_locality;
	}
	public String getProperty_addr() {
		return property_addr;
	}
	public void setProperty_addr(String property_addr) {
		this.property_addr = property_addr;
	}
	public int getHouse_number() {
		return house_number;
	}
	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}
	public int getNo_of_bedrooms() {
		return no_of_bedrooms;
	}
	public void setNo_of_bedrooms(int no_of_bedrooms) {
		this.no_of_bedrooms = no_of_bedrooms;
	}
	public int getNo_of_bathrooms() {
		return no_of_bathrooms;
	}
	public void setNo_of_bathrooms(int no_of_bathrooms) {
		this.no_of_bathrooms = no_of_bathrooms;
	}
	public int getNo_of_balconies() {
		return no_of_balconies;
	}
	public void setNo_of_balconies(int no_of_balconies) {
		this.no_of_balconies = no_of_balconies;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getCarpet_area() {
		return carpet_area;
	}
	public void setCarpet_area(String carpet_area) {
		this.carpet_area = carpet_area;
	}
	public String getFurnishing_type() {
		return furnishing_type;
	}
	public void setFurnishing_type(String furnishing_type) {
		this.furnishing_type = furnishing_type;
	}
	public int getLight() {
		return light;
	}
	public void setLight(int light) {
		this.light = light;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getTv() {
		return tv;
	}
	public void setTv(int tv) {
		this.tv = tv;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public int getWardrobe() {
		return wardrobe;
	}
	public void setWardrobe(int wardrobe) {
		this.wardrobe = wardrobe;
	}
	public int getGeyser() {
		return geyser;
	}
	public void setGeyser(int geyser) {
		this.geyser = geyser;
	}
	public int getSofa() {
		return sofa;
	}
	public void setSofa(int sofa) {
		this.sofa = sofa;
	}
	public int getWashing_machine() {
		return washing_machine;
	}
	public void setWashing_machine(int washing_machine) {
		this.washing_machine = washing_machine;
	}
	public int getStove() {
		return stove;
	}
	public void setStove(int stove) {
		this.stove = stove;
	}
	public int getFridge() {
		return fridge;
	}
	public void setFridge(int fridge) {
		this.fridge = fridge;
	}
	public int getWater_purifier() {
		return water_purifier;
	}
	public void setWater_purifier(int water_purifier) {
		this.water_purifier = water_purifier;
	}
	public int getMicrowave() {
		return microwave;
	}
	public void setMicrowave(int microwave) {
		this.microwave = microwave;
	}
	public int getModular_kitched() {
		return modular_kitched;
	}
	public void setModular_kitched(int modular_kitched) {
		this.modular_kitched = modular_kitched;
	}
	public int getChimney() {
		return chimney;
	}
	public void setChimney(int chimney) {
		this.chimney = chimney;
	}
	public int getDinning_table() {
		return dinning_table;
	}
	public void setDinning_table(int dinning_table) {
		this.dinning_table = dinning_table;
	}
	public int getCurtains() {
		return curtains;
	}
	public void setCurtains(int curtains) {
		this.curtains = curtains;
	}
	public int getExhaust_fan() {
		return exhaust_fan;
	}
	public void setExhaust_fan(int exhaust_fan) {
		this.exhaust_fan = exhaust_fan;
	}
	public int getTotal_floors() {
		return total_floors;
	}
	public void setTotal_floors(int total_floors) {
		this.total_floors = total_floors;
	}
	public int getYour_floor() {
		return your_floor;
	}
	public void setYour_floor(int your_floor) {
		this.your_floor = your_floor;
	}
	public int getAge_of_property() {
		return age_of_property;
	}
	public void setAge_of_property(int age_of_property) {
		this.age_of_property = age_of_property;
	}
	public int getRent_price() {
		return rent_price;
	}
	public void setRent_price(int rent_price) {
		this.rent_price = rent_price;
	}
	public String getBedroom_1() {
		return bedroom_1;
	}
	public void setBedroom_1(String bedroom_1) {
		this.bedroom_1 = bedroom_1;
	}
	public String getBedroom_2() {
		return bedroom_2;
	}
	public void setBedroom_2(String bedroom_2) {
		this.bedroom_2 = bedroom_2;
	}
	public String getKitchen() {
		return kitchen;
	}
	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}
	public String getBalcony() {
		return balcony;
	}
	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}
	public String getBathroom() {
		return bathroom;
	}
	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getSecurity_deposit() {
		return Security_deposit;
	}
	public void setSecurity_deposit(String security_deposit) {
		Security_deposit = security_deposit;
	}
	public String getMonthNotice() {
		return monthNotice;
	}
	public void setMonthNotice(String monthNotice) {
		this.monthNotice = monthNotice;
	}
	public String getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	@Override
	public String toString() {
		return "Property [property_id=" + property_id + ", propertyType=" + propertyType + ", city=" + city
				+ ", locality=" + locality + ", sub_locality=" + sub_locality + ", property_addr=" + property_addr
				+ ", house_number=" + house_number + ", no_of_bedrooms=" + no_of_bedrooms + ", no_of_bathrooms="
				+ no_of_bathrooms + ", no_of_balconies=" + no_of_balconies + ", area=" + area + ", carpet_area="
				+ carpet_area + ", furnishing_type=" + furnishing_type + ", light=" + light + ", fans=" + fans + ", tv="
				+ tv + ", beds=" + beds + ", wardrobe=" + wardrobe + ", geyser=" + geyser + ", sofa=" + sofa
				+ ", washing_machine=" + washing_machine + ", stove=" + stove + ", fridge=" + fridge
				+ ", water_purifier=" + water_purifier + ", microwave=" + microwave + ", modular_kitched="
				+ modular_kitched + ", chimney=" + chimney + ", dinning_table=" + dinning_table + ", curtains="
				+ curtains + ", exhaust_fan=" + exhaust_fan + ", total_floors=" + total_floors + ", your_floor="
				+ your_floor + ", age_of_property=" + age_of_property + ", rent_price=" + rent_price + ", bedroom_1="
				+ bedroom_1 + ", bedroom_2=" + bedroom_2 + ", kitchen=" + kitchen + ", balcony=" + balcony
				+ ", bathroom=" + bathroom + ", hall=" + hall + ", video=" + video + ", Security_deposit="
				+ Security_deposit + ", monthNotice=" + monthNotice + ", restrictions=" + restrictions + ", features="
				+ features + ", likes=" + likes + ", interested_people=" + interested_people + ", user=" + user + "]";
	}
	
}

//property:
//	  user_id
//	  property_id
//	  basic details:
//	  property type: string flat , villa ye sab 
//	  location obj
//	  prop profile
//	  age_of_property:int 
//	  available from: date
//	  willing to rent: int 3 types 
//	  rent_amount:
//	  okay_with_broker_contancting:boolean 
//	  describe prop: string 
//	  image_video
//	  aminities: list<string>
//
//	images_video:
//	user_id:
//	content_type: image/video
//	full_video_name:
//	List<string> image_name:
//
//	location detail :
//	   city 
//	   locality 
//	   apartment/society 
//	   house number
//
//	property profile
//	   // room details
//	   no. of bedrooms :int
//	   no. of bathrooms :int
//	   area details in sq-feet: int
//	   type_of_furnish :
//	   // floor details 
//	   total floors.
//	   floor of your property.
//	   furnish_detial:entity/list<string>/object Boolean
//
//	furnish entity:
