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

import com.dao.PcateringDao;
import com.dao.PcateringRepository;
import com.model.Pcatering;


@RestController
public class PcateringController {
	@Autowired
	PcateringDao pcateringDao;
	@Autowired
	PcateringRepository pcateringRepository;
	
	@GetMapping("getPcaterings")
	public List<Pcatering> getPcaterings() {
		return pcateringDao.getPcaterings();
	}
	
	
	@PostMapping("Pcatering/{id}/{name}/{description}/{price}")
	public String Pcatering (@RequestParam("file") MultipartFile file, @PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description ,@PathVariable("price") int price) throws IOException{
		Pcatering p= new Pcatering(name,description,price,file.getBytes());
		pcateringRepository.save(p);
		return "success"; 
	}

	
	@PutMapping("updatePcatering")
	public String updatePcatering(@RequestBody Pcatering pcatering) {
		pcateringDao.updatePcatering(pcatering);
		return "Event Updated Successfully!!!";
	}
	

}