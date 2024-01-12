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

import com.dao.WphotographyDao;
import com.dao.WphotographyRepository;
import com.model.Wphotography;


@RestController
public class WphotographyController {
	@Autowired
	WphotographyDao wphotographyDao;
	@Autowired
	WphotographyRepository wphotographyRepository;
	
	@GetMapping("getWphotographys")
	public List<Wphotography> getWphotographys() {
		return wphotographyDao.getWphotographys();
	}

	
	@PostMapping("Wphotography/{id}/{name}/{description}/{price}")
	public String Wphotography (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Wphotography w= new Wphotography(name,description,price,file.getBytes());
		wphotographyRepository.save(w);
		return "success"; 
	}

	
	@PutMapping("updateWphotography")
	public String updateWphotography(@RequestBody Wphotography wphotography) {
		wphotographyDao.updateWphotography(wphotography);
		return "Wphotography Updated Successfully!!!";
	}

	
}
