package com.banking.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	private int customer_id;
	private String first_name;
	private String last_name;
	private String email_address;
	private String phone_number;
	private String address;
	public Customer() {
		
	}
	
	public Customer(int customer_id, String first_name, String last_name, String email_address, String phone_number,
			String address) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_address = email_address;
		this.phone_number = phone_number;
		this.address = address;
	}

	private boolean isValidEmail(String email) {
	       String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	       Pattern pattern = Pattern.compile(emailRegex);
	       Matcher matcher = pattern.matcher(email);
	       return matcher.matches();
	   }

	private boolean isValidPhoneNumber(String phone) {
	       return phone.matches("\\d{10}");
	   }

	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		if(isValidEmail(email_address))
		{
			this.email_address = email_address;
		}
		else
			System.out.println("Enter a valid email address");
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		if(isValidPhoneNumber(phone_number))
		{
			this.phone_number = phone_number;
		}
		else
			System.out.println("Enter a valid phone number");
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email_address=" + email_address + ", phone_number=" + phone_number + ", address=" + address + "]";
	}
	
	public void printCustomerInfo() {
        System.out.println("Customer ID: " + customer_id);
        System.out.println("Name: " + first_name + " " + last_name);
        System.out.println("Email Address: " + email_address);
        System.out.println("Phone Number: " + phone_number);
        System.out.println("Address: " + address);
    }
}
