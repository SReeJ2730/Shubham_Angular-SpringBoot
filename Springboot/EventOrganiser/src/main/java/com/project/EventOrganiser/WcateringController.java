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

import com.dao.WcateringDao;
import com.dao.WcateringRepository;
import com.model.Wcatering;


@RestController
public class WcateringController {
	@Autowired
	WcateringDao wcateringDao;
	@Autowired
	WcateringRepository wcateringRepository;
	
	@GetMapping("getWcaterings")
	public List<Wcatering> getWcaterings() {
		return wcateringDao.getWcaterings();
	}
	
	
	@PostMapping("Wcatering/{id}/{name}/{description}/{price}")
	public String Wcatering (@RequestParam("file") MultipartFile file, @PathVariable("id") int id,@PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Wcatering w= new Wcatering(name,description,price,file.getBytes());
		wcateringRepository.save(w);
		return "success"; 
	}

	
	@PutMapping("updateWcatering")
	public String updateWcatering(@RequestBody Wcatering wcatering) {
		wcateringDao.updateWcatering(wcatering);
		return "Event Updated Successfully!!!";
	}
	
	
}
