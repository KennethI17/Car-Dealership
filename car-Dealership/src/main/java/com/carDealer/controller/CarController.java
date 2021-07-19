package com.carDealer.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.carDealer.info.Buyer;
import com.carDealer.info.CarInfo;
import com.carDealer.info.Seller;
import com.carDealer.service.CarService;

@Controller
public class CarController {
	
	@Autowired
	public CarService carService = new CarService();
	
	@GetMapping("/")
	public String welcome(Model model) {
		return "index";
	}
	
	@GetMapping("/sign-up")
	public ModelAndView signUp(Model model){
		
		return new ModelAndView("sign-up", "seller", new Seller());
	}
	@PostMapping("/sign-up")
	public String handleSignUp(Model model, @ModelAttribute("seller") Seller seller, HttpSession session) {
		carService.saveSeller(seller);
		model.addAttribute("newSeller", seller);
		return "thank-you";
	}
	
// Keep from having same email as someone else
	/*
	 * @PostMapping({"adduser", "register"}) String adduser(@ModelAttribute Account
	 * user, RedirectAttributes redirect) {
	 * 
	 * Optional <Account> acc= AccountRepository.findByEmail(user.getEmail());
	 * if(acc.isPresent()) { redirect.addFlashAttribute("error",
	 * "Email already exists."); return "redirect:signup"; }
	 * 
	 * AccountRepository.save(user);
	 * 
	 * redirect.addFlashAttribute("success", "Thank you for signing up, " +
	 * user.getfName() +" "+ user.getlName() + "!");
	 * 
	 * return "redirect:login"; }
	 */

	
	@GetMapping("/login")
	public ModelAndView login(Model model) {
		
		return new ModelAndView("login", "seller", new Seller());
	}
	
	@PostMapping("/authenticate")
	public String hangleLogin(Model model, @ModelAttribute("seller") Seller seller, HttpSession session) {
		if(seller != null) {
			Seller verify = carService.findSellerEmail(seller.getEmail());
			if (verify.getEmail().equals("admin@email.com") && verify.getPassword().equals("admin")) {
				return "redirect: /report";
			}

			if(verify != null && verify.getPassword().equals(seller.getPassword())) {
				session.setAttribute("loginSeller", verify);
				model.addAttribute("newSeller", seller); 
				return "/profile";
			}
		}
		model.addAttribute("error", "Invalid Credentials");
		return "login";
	}
	
	@GetMapping("/users")
	String users(Model model, @ModelAttribute("loginSeller") Seller seller, HttpSession session) {
		model.addAttribute("sellers", carService.displayAll());
		String fN = seller.getFirstName();
		model.addAttribute("loggedInSeller", fN);
		return "/users";
	}
	
	@GetMapping("/add-vic")
	public ModelAndView addVic(Model model, @ModelAttribute("seller") Seller seller, HttpSession session){
		Seller acc = (Seller) session.getAttribute("seller");
		session.setAttribute("seller", seller);
		model.addAttribute("loginSeller", acc);
		return new ModelAndView("add-vic", "carInfo", new CarInfo());
	}
	@PostMapping("/add-vic")
	public String handleAddVic(Model model,@ModelAttribute("loginSeller") Seller seller, @ModelAttribute("carInfo") CarInfo carInfo, HttpSession session) {
		Seller acc = (Seller) session.getAttribute("loginSeller");
		session.setAttribute("seller", seller);
		carInfo.setSellerEmail(acc.getEmail());
		carInfo.setDateOnLot(LocalDate.now());
		carService.saveCar(carInfo);
		MultipartFile picture = carInfo.getCarPicture();
		carService.addPic(picture);
		carInfo.setCarPic(picture.getOriginalFilename());
		model.addAttribute("loginSeller", acc);
		model.addAttribute("carInfo", carInfo);
		return "/profile";
	}
	
	@GetMapping("/auctions")
	String store(Model model) {
		carService.discountCar();
		model.addAttribute("carInfo", carService.displayCars());
		return "/store";
	}
	@GetMapping("/buycar-{sellerEmail}-{miles}-{price}")
	String buyCar(@PathVariable String sellerEmail, @PathVariable String miles, @PathVariable double price, @ModelAttribute("buyer") Buyer buyer, HttpSession session) {
		CarInfo car = new CarInfo();
		car = carService.findCar(sellerEmail, miles, price);
		session.setAttribute("carInfo", car);
		return "/transaction";
	}
	@PostMapping("/buyer")
	String buyer(Model model, @ModelAttribute("buyer") Buyer buyer, @ModelAttribute("carInfo") CarInfo carInfo, HttpSession session) {
		carService.saveBuyers(buyer);
		CarInfo car = (CarInfo) session.getAttribute("carInfo");
		model.addAttribute("newBuyer", buyer);
		model.addAttribute("carInfo", car);
		return "/purchase";
	}
//	@GetMapping("/search")
//	public String handleSearch(String keyword, Model model, HttpSession session) {
//		model.addAttribute("search", keyword);
//		return "search";
//	}
	
	@PostMapping("/searchEngine")
	String searchForCar(@RequestParam String keyword, Model model) {
		List<CarInfo> car = carService.search(keyword);
		model.addAttribute("searchCar", car);
		return "search";
	}
}
