package com.carDealer.info;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class CarInfo {
	
	private double price;
	private String discount;
	private LocalDate localDate;
	private LocalDate dateSold;
	private LocalDate dateOnLot;
	private String year;
	private String model;
	private String make;
	private String miles;
	private String description;
	private String state;
	private String sellerEmail;
	private String carPic;
	private MultipartFile carPicture;
	
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public LocalDate getDateSold() {
		return dateSold;
	}
	public void setDateSold(LocalDate dateSold) {
		this.dateSold = dateSold;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getMiles() {
		return miles;
	}
	public void setMiles(String miles) {
		this.miles = miles;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getCarPic() {
		return carPic;
	}
	public void setCarPic(String carPic) {
		this.carPic = carPic;
	}
	public LocalDate getDateOnLot() {
		return dateOnLot;
	}
	public void setDateOnLot(LocalDate dateOnLot) {
		this.dateOnLot = dateOnLot;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getCarPicture() {
		return carPicture;
	}
	public void setCarPicture(MultipartFile carPicture) {
		this.carPicture = carPicture;
	}


}
