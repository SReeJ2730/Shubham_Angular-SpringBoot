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

import com.dao.PphotographyDao;
import com.dao.PphotographyRepository;
import com.model.Pphotography;


@RestController
public class PphotographyController {
	@Autowired
	PphotographyDao PphotographyDao;
	@Autowired
	PphotographyRepository pphotographyRepository;
	
	@GetMapping("getPphotographys")
	public List<Pphotography> getPphotographys() {
		return PphotographyDao.getPphotographys();
	}
	
	
	@PostMapping("Pphotography/{id}/{name}/{description}/{price}")
	public String Pphotography (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Pphotography p= new Pphotography(name,description,price,file.getBytes());
		pphotographyRepository.save(p);
		return "success"; 
	}

	
	@PutMapping("updatePphotography")
	public String updatePphotography(@RequestBody Pphotography pphotography) {
		PphotographyDao.updatePphotography(pphotography);
		return "Event Updated Successfully!!!";
	}
	

	
}