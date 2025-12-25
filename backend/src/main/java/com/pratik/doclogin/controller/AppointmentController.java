package com.pratik.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.doclogin.entity.Appoinment;
import com.pratik.login.repository.AppoinmentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2/appointments")
public class AppointmentController {

	  AppoinmentRepository appoinmentRepository;

	  public AppointmentController(AppoinmentRepository appoinmentRepository) {
		super();
		this.appoinmentRepository = appoinmentRepository;
	  }
	  
	  @PostMapping
	  public Appoinment createAppoinment (@RequestBody Appoinment appoinment)
	  {
		return appoinmentRepository.save(appoinment);
	  }
	  
	  @GetMapping
	  public List<Appoinment> getAllAppoinments()
	  {
		  return appoinmentRepository.findAll();
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable long id) {

	      Appoinment appointment = appoinmentRepository.findById(id)
	          .orElseThrow(() -> new RuntimeException("Appointment not found"));

	      appoinmentRepository.delete(appointment);

	      Map<String, Boolean> response = new HashMap<>();
	      response.put("deleted", Boolean.TRUE);

	      return ResponseEntity.ok(response);
	  }
	  
	  
	  
}

