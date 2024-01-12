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

import com.dao.WmusicDao;
import com.dao.WmusicRepository;
import com.model.Wmusic;


@RestController
public class WmusicController {
	@Autowired
	WmusicDao wmusicDao;
	@Autowired
	WmusicRepository wmusicRepository;
	
	@GetMapping("getWmusics")
	public List<Wmusic> getWmusics() {
		return wmusicDao.getWmusics();
	}

	
	@PostMapping("Wmusic/{id}/{name}/{description}/{price}")
	public String Wmusic (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Wmusic w= new Wmusic(name,description,price,file.getBytes());
		wmusicRepository.save(w);
		return "success"; 
	}

	
	@PutMapping("updateWmusic")
	public String updateWmakeup(@RequestBody Wmusic wmusic) {
		wmusicDao.updateWmusic(wmusic);
		return "Event Updated Successfully!!!";
	}

	
}