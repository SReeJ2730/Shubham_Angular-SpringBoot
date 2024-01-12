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

import com.dao.PmusicDao;
import com.dao.PmusicRepository;
import com.model.Pmusic;


@RestController
public class PmusicController {
	@Autowired
	PmusicDao PmusicDao;
	@Autowired
	PmusicRepository pmusicRepository;
	
	@GetMapping("getPmusics")
	public List<Pmusic> getPmusics() {
		return PmusicDao.getPmusics();
	}
	
	@PostMapping("Pmusic/{id}/{name}/{description}/{price}")
	public String Pmusic (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Pmusic p= new Pmusic(name,description,price,file.getBytes());
		pmusicRepository.save(p);
		return "success"; 
	}

	
	@PutMapping("updatePmusic")
	public String updatePmusic(@RequestBody Pmusic pmusic) {
		PmusicDao.updatePmusic(pmusic);
		return "Event Updated Successfully!!!";
	}

	
}