package com.project.EventOrganiser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ShowbookedDao;
import com.model.Showbooked;
@RestController
public class ShowbookedController { 

	@Autowired
	ShowbookedDao showbookedDao;


	@GetMapping("/listOfBookings")
	public List<Showbooked> listOfBookings(){
		return showbookedDao.listOfBookings();
	}

	@PostMapping("/registerBooking")
	public Showbooked registerBooking(@RequestBody Showbooked list) {
		return showbookedDao.registerBooking(list);
	}
	
	@PostMapping("registerbook")
	public void register(@RequestBody List<Showbooked> list){
		showbookedDao.register(list);
	}
	
	@GetMapping("getBookingByEmailId/{emailId}")
	public List<Showbooked> getBookingByEmailId(@PathVariable("emailId") String emailId) {
		return showbookedDao.getBookingByEmailId(emailId);
	}


	@GetMapping("getBookingsByOrder")
	public List<Showbooked> getDetailsOrder()
	{
		return showbookedDao.getDetailsOrder();
	}



	@GetMapping("getBookingsByOrderemail/{email}")
	public List<Showbooked> getDetailsOrderMail(@PathVariable("email")String email)
	{
		return showbookedDao.getDetailsOrderMail(email);
	}
}