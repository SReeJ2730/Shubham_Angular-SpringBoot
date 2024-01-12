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

import com.dao.CdrinkDao;
import com.dao.CdrinkRepository;
import com.model.Cdrink;


@RestController
public class CdrinkController {
	@Autowired
	CdrinkDao CdrinkDao;
	@Autowired
	CdrinkRepository cdrinkRepository;
	
	@GetMapping("getCdrinks")
	public List<Cdrink> getCdrinks() {
		return CdrinkDao.getCdrinks();
	}
	
	
	@PostMapping("Cdrink/{id}/{name}/{description}/{price}")
	public String Cdrink (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Cdrink c= new Cdrink(name,description,price,file.getBytes());
		cdrinkRepository.save(c);
		return "success"; 
	}

	
	@PutMapping("updateCdrink")
	public String updateCdrink(@RequestBody Cdrink cdrink) {
		CdrinkDao.updateCdrink(cdrink);
		return "Event Updated Successfully!!!";
	}

	
}