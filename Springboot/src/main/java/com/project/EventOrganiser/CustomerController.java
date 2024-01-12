package com.project.EventOrganiser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDao;
import com.dao.CustomerRepository;
import com.dao.EventRepository;
import com.dao.UserUniqueIdRepository;
import com.model.Customer;
import com.model.UserUniqueId;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CustomerController {
	@Autowired
    private JavaMailSender javaMailSender;
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerDao customerDao;
	@Autowired
	UserUniqueIdRepository useruniqueidrp;
  @Autowired
  EventRepository eventrp;

	@GetMapping("getCustomers")
	public List<Customer> getCustomers(){
		return customerDao.getCustomers();
	}

	@GetMapping("getCustomerByName/{firstName}/{lastName}")
	public Customer getCustomerByName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
		return customerDao.getCustomerByName(firstName,lastName);
	}
	
	@GetMapping("findByemailId/{emailId}")
	public Customer findByemailId(@PathVariable("emailId") String emailId){
		return customerDao.findByemailId(emailId);
	}
	
	@GetMapping("findById/{id}")
	public Customer findById(@PathVariable("id") int id){
		return customerDao.findById(id);
	}

	
	@PostMapping("registerCustomer")
	public String registerCustomer(@RequestBody Customer cust){
		List<Customer> custdetails=  customerRepository.findAll();
		for( Customer cd:custdetails){
			if (cd.getEmailId().equalsIgnoreCase(cust.getEmailId())){
				return "Existing User";
			}
		}
		UUID uuid = UUID.randomUUID();
		String uuidval=uuid.toString();
		String email=cust.getEmailId();
		UserUniqueId uc= new UserUniqueId(email,uuidval);
		useruniqueidrp.save(uc);
		customerDao.registerCustomer(cust);
		return "Customer Registered Successfully !!!";

	}

	@PutMapping("updateCustomer")
	public String updateCustomer(@RequestBody Customer cust){
		customerDao.updateCustomer(cust);
		return "Customer Updated Successfully !!!";
	}

	@DeleteMapping("deleteCustomerByName/{firstName}/{lastName}")
	public String deleteCustomerByName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
		customerDao.deleteByName(firstName,lastName);
		return "Customer Deleted Successfully !!!";
	}

	@GetMapping("cLogin/{emailId}/{password}")
	public Customer cLogin(@PathVariable("emailId") String emailId, @PathVariable("password") String password){
		Customer c = customerDao.getCustomerByEmailId(emailId);
		if(c != null){
			BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
			if(bcpe.matches(password, c.getPassword())){
				return c;
			}
		}
		return null;
	}
 
	
	@PostMapping("EmailOtp1/{emailId}")
	public String EmailOtp1(@PathVariable("emailId") String emailId){
		Customer stud = customerDao.getCustomerByEmailId(emailId);
		if(stud != null){
			customerDao.generateEmailOtp2(stud);
			return "OTP sent to : " + emailId;
		}
		return "Email Not Found";
	}

	@PostMapping("PhoneOtp/{PhoneNo}")
	public String otpPhoneNo(@PathVariable("PhoneNo") String phoneNo){
		Customer stud = customerDao.getStudentByPhoneNo(phoneNo);
		if(stud != null){
			customerDao.generatePhoneOtp(stud);
			return "OTP sent to : " + phoneNo;
		}
		return "PhoneNumber not Found";
	}


	@PostMapping("validatePhoneOtp/{PhoneNo}/{otp}")
	public String validatePhoneOtp(@PathVariable("PhoneNo") String phoneNo, @PathVariable("otp") int otp){
		if(customerDao.validatePhoneOtp(phoneNo, otp)){
			return "OTP is valid !!!";
		}
		else {
			return "OTP is Invalid !!!";
		}
	}
	
	 @GetMapping("/login/google")
	    public String googleLogin() {
	        return "redirect:/oauth2/authorization/google";
	    }
	 
	 @GetMapping("CheckEmail/{emailId}")
		public boolean CheckEmail(@PathVariable("emailId") String emailId){
			System.out.println(emailId);
			List<Customer> Cd = customerRepository.findAll();
			for (Customer C:Cd){
				if (C.getEmailId().equals(emailId)){
					String subject="verifiation otp for authetication ";
					int otp = (int) (Math.random() * 900000) + 100000;
					String body=String.valueOf(otp);
					 MimeMessage message = javaMailSender.createMimeMessage();
					 MimeMessageHelper helper;
				    try {
				        helper = new MimeMessageHelper(message, true);
				        helper.setTo(emailId);
				        helper.setSubject(subject);
				        helper.setText(body, true);
				        javaMailSender.send(message);
				       
				    } catch (MessagingException e) {
				        e.printStackTrace();
				    }
				    customerDao.AddHm(emailId, body);
					return  true;
				}
			}
			return false;
		}
	 
	 @PutMapping("customerUpdate")
		public Customer customerUpdate(@RequestBody String emailId,@RequestBody String password){
			return customerDao.customerUpdate(emailId, password);
		}
		
		
		@PostMapping("getEmailOtp")
		public ResponseEntity<Map<String, String>> EmailOtp(@RequestBody String emailId) {
			Map <String, String> response = new HashMap<>();
			if(customerDao.generateOTP(emailId)) {
				response.put("message", "OTP is Sent");
				return ResponseEntity.ok(response);
			}
			else {
				return null;
			}
			
		}
		
		@PutMapping("validateEmailOtp/{emailId}/{otp}")
		public ResponseEntity<Map<String,String>> validateEmailOtp(@PathVariable("emailId") String emailId, @PathVariable("otp") int otp) {
			Map <String, String> response = new HashMap<>();
			if(customerDao.validateEmailOtp(emailId, otp)) {
				response.put("message", "OTP Verified");
				return ResponseEntity.ok(response);
			}
			else {
				return null;
			}
		}
		
		

@PutMapping("passwordReset/{emailId},{password}")
	public Customer userUpdate(@PathVariable("emailId") String emailId,@PathVariable() String password){
		return customerDao.customerUpdate(emailId, password);
	}



		
}

