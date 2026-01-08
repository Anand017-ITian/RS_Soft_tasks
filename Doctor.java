package com.acc.model;

public class Doctor {
	int id;
	int exp;
	String specialist;
	String fname;
	String lname;
	long contact;
	String address;
	String gender;
	int fees;
	String available;
	public Doctor() {
		
	}
	public Doctor(int id, int exp, String specialist, String fname, String lname, long contact, String address,
			String gender, int fees, String available) {
	
		this.id = id;
		this.exp = exp;
		this.specialist = specialist;
		this.fname = fname;
		this.lname = lname;
		this.contact = contact;
		this.address = address;
		this.gender = gender;
		this.fees = fees;
		this.available = available;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", exp=" + exp + ", specialist=" + specialist + ", fname=" + fname + ", lname="
				+ lname + ", contact=" + contact + ", address=" + address + ", gender=" + gender + ", fees=" + fees
				+ ", available=" + available + "]";
	}
	
	
	
	
		
}
