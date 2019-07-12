package com.zzti.entity;

public class AuctionDO {
	private String Title;
	private String price;
	private String description;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AuctionDO [title=" + Title + ", price=" + price + ", description=" + description + "]";
	}
	
}
