package com.ms_course.hrworker.resources;

import java.util.List;
import java.util.Map;

import com.ms_course.hrworker.entities.Worker;
import com.ms_course.hrworker.repositories.WorkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return  ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker worker;
		try {
			worker  = repository.findById(id).get();
			if (worker != null){
				return ResponseEntity.ok(worker);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping(value = "find", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Worker> find( @RequestBody Map<String,Long> params){
		Worker worker;
		Long id = params.get("id");		
		try {
			worker  = repository.findById(id).get();
			if (worker != null){
				return ResponseEntity.ok(worker);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
