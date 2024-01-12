package com.project.EventOrganiser;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dao.CcateringDao;
import com.dao.CcateringRepository;
import com.model.Ccatering;


@RestController
public class CcateringController {
	@Autowired
	CcateringDao CcateringDao;
	@Autowired
	CcateringRepository ccateringRepository;
	
	@GetMapping("getCcaterings")
	public List<Ccatering> getCcaterings() {
		return CcateringDao.getCcaterings();
	}
	
	
	@PostMapping("Ccatering/{id}/{name}/{description}/{price}")
	public String Ccatering (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Ccatering c= new Ccatering(name,description,price,file.getBytes());
		ccateringRepository.save(c);
		return "success"; 
	}

	
	@PutMapping("updateCcatering")
	public String updateCcatering(@RequestBody Ccatering ccatering) {
		CcateringDao.updateCcatering(ccatering);
		return "Event Updated Successfully!!!";
	}
	

	
}