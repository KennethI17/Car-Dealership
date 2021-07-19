package com.carDealer.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.carDealer.info.Address;
import com.carDealer.info.Buyer;
import com.carDealer.info.CarInfo;
import com.carDealer.info.Seller;

@Service
public class CarService {
	List<Seller> sellers = new ArrayList<Seller>();
	List<Buyer> buyers = new ArrayList<Buyer>();
	List<CarInfo> carInfo = new ArrayList<CarInfo>();
	
	@Autowired
	ServletContext servletContext;

	public void saveSeller(Seller newSeller) {
		sellers.add(newSeller);
	}

	public List<Seller> findAll() {
		return sellers;
	}

	public Seller findSellerEmail(String email) {

		for (int i = 0; i <= sellers.size(); i++) {
			Seller seller = sellers.get(i);
			if (seller.getEmail().equals(email)) {
				return seller;
			}
		}
		return null;
	}

	public ArrayList<Seller> displayAll() {
		return (ArrayList<Seller>) sellers;
	}

	public void saveCar(CarInfo newCar) {
		carInfo.add(newCar);
	}

	public ArrayList<CarInfo> displayCars() {
		return (ArrayList<CarInfo>) carInfo;
	}

	public CarInfo findCar(String email, String miles, double price) {
		CarInfo car = new CarInfo();
		for (CarInfo acc : carInfo) {
			if (acc.getSellerEmail().equals(email) && acc.getMiles().equals(miles) && acc.getPrice() == price) {
				acc = car;
			}
		}
		return car;
	}

	public void saveBuyers(Buyer buyer) {
		buyers.add(buyer);
	}
	
	public void addPic(MultipartFile picture) {
		if(picture != null || picture.isEmpty()) {
			String picName = servletContext.getRealPath("/")+"resources\\images\\"+ picture.getOriginalFilename();
			try {
			picture.transferTo(new File(picName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public List<CarInfo> search(String keyword){
		List<CarInfo> car = new LinkedList<CarInfo>();
		System.out.println(keyword);
		for(CarInfo a: carInfo) {
			if(a.getMake().equalsIgnoreCase(keyword) || a.getModel().equalsIgnoreCase(keyword)) {
				car.add(a);
			}
			
		}
	return car;
	}

	public void discountCar() {
		for (int i = 0; i < carInfo.size(); i++) {
			CarInfo car = carInfo.get(i);
			if (ChronoUnit.DAYS.between(car.getDateOnLot(), LocalDate.now()) > 120) {
				double discountedPrice = (car.getPrice() * .90);
				String discountedPriceb = String.valueOf(discountedPrice);
				car.setDiscount("$ " + discountedPriceb + " (10% discount)");
			}
			continue;
		}
	}
	
// Default Users
	  {Address a1 = new Address(); a1.setStreet("109 Street"); a1.setCity("Houston");
	  a1.setState("TX"); a1.setZip("12345");
	  Seller user1 = new Seller(); user1.setFirstName("Rick");
	  user1.setLastName("James"); user1.setEmail("rick@email.com"); user1.setPassword("123");
	  user1.setAge("55"); user1.setPhone("4445556666"); user1.setAddress(a1); saveSeller(user1);
	  
	  Address a2 = new Address(); a2.setStreet("99 Road"); a2.setCity("Coal");
	  a2.setState("MO"); a2.setZip("67895");
	  Seller user2 = new Seller(); user2.setFirstName("Bill");
	  user2.setLastName("Burr"); user2.setEmail("bill@email.com"); user2.setPassword("123");
	  user2.setAge("48"); user2.setPhone("1234567890"); user2.setAddress(a2); saveSeller(user2);
	  
	  Address a3 = new Address(); a3.setStreet("55 Ave"); a3.setCity("Rock");
	  a3.setState("CA"); a3.setZip("45678");
	  Seller user3 = new Seller(); user3.setFirstName("Rusty");
	  user3.setLastName("Oldguy"); user3.setEmail("rusty@email.com"); user3.setPassword("123");
	  user3.setAge("88"); user3.setPhone("4564564567"); user3.setAddress(a3); saveSeller(user3);
	  
	  Address a4 = new Address(); a4.setStreet("Creek Rd"); a4.setCity("Town");
	  a4.setState("AZ"); a4.setZip("98765");
	  Seller user4 = new Seller(); user4.setFirstName("Chris");
	  user4.setLastName("Farley"); user4.setEmail("chris@email.com"); user4.setPassword("123");
	  user4.setAge("33"); user4.setPhone("1112223333"); user4.setAddress(a4); saveSeller(user4);
	  
	  Address a5 = new Address(); a5.setStreet("Admin"); a5.setCity("Admin");
	  a5.setState("Admin"); a5.setZip("12345");
	  Seller user5 = new Seller(); user5.setFirstName("Admin");
	  user5.setLastName("Admin"); user5.setEmail("admin@email.com"); user5.setPassword("123");
	  user5.setAge("Admin"); user5.setPhone("Admin"); user5.setAddress(a5); saveSeller(user5);
		
// Default Cars
	  CarInfo car1 = new CarInfo(); car1.setPrice(14594);
	  car1.setDateOnLot(LocalDate.of(2021, 5, 16)); car1.setYear("2015"); car1.setModel("Econoline");
	  car1.setMake("Ford"); car1.setMiles("65,266"); car1.setDescription("Needs detail clean on the inside."); car1.setState("TX");
	  car1.setSellerEmail("rick@email.com"); car1.setCarPic("Econoline.jpg"); saveCar(car1);
	  
	  CarInfo car2 = new CarInfo(); car2.setPrice(15466);
	  car2.setDateOnLot(LocalDate.of(2021, 6, 23)); car2.setYear("2002"); car2.setModel("F350");
	  car2.setMake("Ford"); car2.setMiles("102,103"); car2.setDescription("Small ding on passenger side."); car2.setState("MO");
	  car2.setSellerEmail("bill@email.com"); car2.setCarPic("2002_F350.jpg"); saveCar(car2);
	  
	  CarInfo car3 = new CarInfo(); car3.setPrice(10990);
	  car3.setDateOnLot(LocalDate.of(2012, 1, 17)); car3.setYear("2003"); car3.setModel("F350");
	  car3.setMake("Ford"); car3.setMiles("121,147"); car3.setDescription("Seats 3 people in cab."); car3.setState("CA");
	  car3.setSellerEmail("rusty@email.com"); car3.setCarPic("2003_F350.jpg"); saveCar(car3);
	  
	  CarInfo car4 = new CarInfo(); car4.setPrice(16220);
	  car4.setDateOnLot(LocalDate.of(2018, 9, 2)); car4.setYear("2013"); car4.setModel("Express");
	  car4.setMake("Chevrolet"); car4.setMiles("162,735"); car4.setDescription("Paint chipping inside cargo area."); car4.setState("AZ");
	  car4.setSellerEmail("chris@email.com"); car4.setCarPic("2013_Express_G3.jpg"); saveCar(car4);
	  
	  CarInfo car5 = new CarInfo(); car5.setPrice(24876);
	  car5.setDateOnLot(LocalDate.of(2018, 7, 4)); car5.setYear("2017"); car5.setModel("Savana");
	  car5.setMake("GMC"); car5.setMiles("128,704"); car5.setDescription("Penske paint but could be repainted."); car5.setState("TX");
	  car5.setSellerEmail("rick@email.com"); car5.setCarPic("2017_Savana.jpg"); saveCar(car5);
	  
	  CarInfo car6 = new CarInfo(); car6.setPrice(28700);
	  car6.setDateOnLot(LocalDate.of(2017, 4, 7)); car6.setYear("2011"); car6.setModel("Commercial");
	  car6.setMake("Workhorse"); car6.setMiles("78,538"); car6.setDescription("Slick, custom paint job with blackout rims."); car6.setState("MO");
	  car6.setSellerEmail("bill@email.com"); car6.setCarPic("2011_Workhorse_Commercial.jpg"); saveCar(car6);
	  
	  CarInfo car7 = new CarInfo(); car7.setPrice(31163);
	  car7.setDateOnLot(LocalDate.of(2021, 2, 4)); car7.setYear("2013"); car7.setModel("F450");
	  car7.setMake("Ford"); car7.setMiles("188,421"); car7.setDescription("Scratch on hood."); car7.setState("CA");
	  car7.setSellerEmail("rusty@email.com"); car7.setCarPic("2013_F450.jpg"); saveCar(car7);
	  
	  CarInfo car8 = new CarInfo(); car8.setPrice(21500);
	  car8.setDateOnLot(LocalDate.of(2020, 11, 18)); car8.setYear("2016"); car8.setModel("NPR");
	  car8.setMake("Isuzu"); car8.setMiles("264,707"); car8.setDescription("Tiny crack on windshield."); car8.setState("AZ");
	  car8.setSellerEmail("chris@email.com"); car8.setCarPic("Isuzu_NPR.jpg"); saveCar(car8);
	  
	  CarInfo car9 = new CarInfo(); car9.setPrice(15000);
	  car9.setDateOnLot(LocalDate.of(2019, 10, 5)); car9.setYear("2016"); car9.setModel("5500");
	  car9.setMake("Ram"); car9.setMiles("105,723"); car9.setDescription("Driver-side door a little hard to open."); car9.setState("TX");
	  car9.setSellerEmail("rick@email.com"); car9.setCarPic("2016_Ram_5500.jpg"); saveCar(car9);
	  
	  CarInfo car10 = new CarInfo(); car10.setPrice(19530);
	  car10.setDateOnLot(LocalDate.of(2019, 5, 15)); car10.setYear("2006"); car10.setModel("Sierra");
	  car10.setMake("GMC"); car10.setMiles("178,000"); car10.setDescription("Minimal burn damage."); car10.setState("MO");
	  car10.setSellerEmail("bill@email.com"); car10.setCarPic("2006_Sierra.jpg"); saveCar(car10);
	  }
	  
}