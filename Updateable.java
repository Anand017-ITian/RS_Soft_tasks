package com.acc.service;

public interface Updateable {
	
    void updateExp(int exp, int id);
    void updateSpecialist(String specialist, int id);
    void updateFname(String fname, int id);
    void updateLname(String lname, int id);
    void updateContact(long contact, int id);
    void updateAddress(String address, int id);
    void updateGender(String gender, int id);
    void updateFees(int fees, int id);
    void updateAvailable(String available, int id);
}
