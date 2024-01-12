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

import com.dao.WmakeupDao;
import com.dao.WmakeupRepository;
import com.model.Wmakeup;


@RestController
public class WmakeupController {
	@Autowired
	WmakeupDao wmakeupDao;
	@Autowired
	WmakeupRepository wmakeupRepository;
	
	@GetMapping("getWmakeups")
	public List<Wmakeup> getWmakeups() {
		return wmakeupDao.getWmakeups();
	}

	
	@PostMapping("Wmakeup/{id}/{name}/{description}/{price}")
	public String Wmakeup (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Wmakeup w= new Wmakeup(name,description,price,file.getBytes());
		wmakeupRepository.save(w);
		return "success"; 
	}

	
	@PutMapping("updateWmakeup")
	public String updateWmakeup(@RequestBody Wmakeup wmakeup) {
		wmakeupDao.updateWmakeup(wmakeup);
		return "Event Updated Successfully!!!";
	}
	
	
}