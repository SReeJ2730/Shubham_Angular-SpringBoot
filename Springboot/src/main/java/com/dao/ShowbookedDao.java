package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Showbooked;


@Service
public class ShowbookedDao {
   
    @Autowired
    ShowBookedRepository showbookedrepo;

    public List<Showbooked> listOfBookings() {
        return showbookedrepo.findAll();
    }

    public Showbooked registerBooking(Showbooked list) {
        return showbookedrepo.save(list); 
    }
    
    public void register(List<Showbooked> list){
    	showbookedrepo.saveAll(list);
    }

    public List<Showbooked> getBookingByEmailId(String emailId) {
        System.out.println(showbookedrepo.findByEmailId(emailId));
        return showbookedrepo.findByEmailId(emailId);
    }


	public List<Showbooked> getDetailsOrder() {
		return showbookedrepo.getDetailsOrder();
	} 
	
	public List<Showbooked> getDetailsOrderMail(String email) {
		return showbookedrepo.getDetailsOrderMail(email);
	} 
	
}