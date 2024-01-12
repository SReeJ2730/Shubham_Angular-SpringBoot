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

import com.dao.WdecorationDao;
import com.dao.WdecorationRepository;
import com.model.Wdecoration;


@RestController
public class WdecorationController {
	@Autowired
	WdecorationDao wdecorationDao;
	@Autowired
	WdecorationRepository wdecorationRepository;
	
	@GetMapping("getWdecorations")
	public List<Wdecoration> getWdecorations() {
		return wdecorationDao.getWdecorations();
	}
	
	
	@PostMapping("Wdecoration/{id}/{name}/{description}/{price}")
	public String Wdecoration (@RequestParam("file") MultipartFile file,  @PathVariable("id") int id,@PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Wdecoration w= new Wdecoration(name,description,price,file.getBytes());
		wdecorationRepository.save(w);
		return "success"; 
	}

	
	@PutMapping("updateWdecoration")
	public String updateWdecoration(@RequestBody Wdecoration wdecoration) {
		wdecorationDao.updateWdecoration(wdecoration);
		return "Event Updated Successfully!!!";
	}
	
	
}