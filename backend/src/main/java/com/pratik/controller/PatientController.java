package com.pratik.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.entity.patient;
import com.pratik.repository.PatientRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/v1")
public class PatientController {
      
	
	private PatientRepository patientRepository;

	public PatientController(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
	
	 @PostMapping("/insert")
	    public patient createPatient(@RequestBody patient patient) {
	        return patientRepository.save(patient);
	    }
	  
	 @GetMapping("/patients")
	 public List<patient>getAllPatient()
	 {
		return patientRepository.findAll(); 
	 }
	 
	 @GetMapping("patients/{id}")
	 public ResponseEntity<patient> getpatientById(@PathVariable long id) throws AttributeNotFoundException
	 {
		patient patient= patientRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient NotFound With Id:"+id));
		
		return ResponseEntity.ok(patient);
	 }
	 
	 
	 @PutMapping("/patients/{id}")
	 public ResponseEntity<patient> updatePatientById(@PathVariable long id, @RequestBody patient patient) throws AttributeNotFoundException {
	     patient existingPatient = patientRepository.findById(id)
	         .orElseThrow(() -> new AttributeNotFoundException("Patient Not Found With id " + id));

	     existingPatient.setName(patient.getName());
	     existingPatient.setAge(patient.getAge());
	     existingPatient.setBlood(patient.getBlood());
	     existingPatient.setPrescription(patient.getPrescription());
	     existingPatient.setDose(patient.getDose());
	     existingPatient.setUrgency(patient.getUrgency());

	     patientRepository.save(existingPatient);

	     return ResponseEntity.ok(existingPatient);
	 }

 
	 @DeleteMapping("/patients/{id}")
	 public ResponseEntity<Void> deletePatient(@PathVariable long id) {

	     if (!patientRepository.existsById(id)) {
	         return ResponseEntity.notFound().build();
	     }

	     patientRepository.deleteById(id);
	     return ResponseEntity.noContent().build(); // 👈 IMPORTANT
	 }


	 
	 
}
