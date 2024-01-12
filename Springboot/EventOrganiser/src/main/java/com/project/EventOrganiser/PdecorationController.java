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

import com.dao.PdecorationDao;
import com.dao.PdecorationRepository;
import com.model.Pdecoration;


@RestController
public class PdecorationController {
	@Autowired
	PdecorationDao PdecorationDao;
	@Autowired
	PdecorationRepository pdecorationRepository;
	
	@GetMapping("getPdecorations")
	public List<Pdecoration> getPdecorations() {
		return PdecorationDao.getPdecorations();
	}
	

	
	@PostMapping("Pdecoration/{id}/{name}/{description}/{price}")
	public String Pdecoration (@RequestParam("file") MultipartFile file, @PathVariable("id") int id,@PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Pdecoration p= new Pdecoration(name,description,price,file.getBytes());
		pdecorationRepository.save(p);
		return "success"; 
	}

	
	@PutMapping("updatePdecoration")
	public String updatePdecoration(@RequestBody Pdecoration pdecoration) {
		PdecorationDao.updatePdecoration(pdecoration);
		return "Event Updated Successfully!!!";
	}
	

	
}