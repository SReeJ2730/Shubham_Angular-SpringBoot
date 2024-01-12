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

import com.dao.CdecorationDao;
import com.dao.CdecorationRepository;
import com.model.Cdecoration;


@RestController
public class CdecorationController {
	@Autowired
	CdecorationDao CdecorationDao;
	@Autowired
	CdecorationRepository cdecorationRepository;
	
	@GetMapping("getCdecorations")
	public List<Cdecoration> getCdecorations() {
		return CdecorationDao.getCdecorations();
	}
	
	
	@PostMapping("Cdecoration/{id}/{name}/{description}/{price}")
	public String Cdecoration (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Cdecoration c= new Cdecoration(name,description,price,file.getBytes());
		cdecorationRepository.save(c);
		return "success"; 
	}

	
	@PutMapping("updateCdecoration")
	public String updateCdecoration(@RequestBody Cdecoration cdecoration) {
		CdecorationDao.updateCdecoration(cdecoration);
		return "Event Updated Successfully!!!";
	}
	

	
}