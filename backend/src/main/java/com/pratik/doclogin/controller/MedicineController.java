package com.pratik.doclogin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.doclogin.entity.Medicine;
import com.pratik.exception.PatientNotFoundException;
import com.pratik.login.repository.MedicineRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v3")
public class MedicineController {
  
	 MedicineRepository medicineRepository;

	 public MedicineController(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	 }
	 
	 @PostMapping("/insert")
	 public Medicine createMedicine(@RequestBody Medicine medicine)
	 {
		 return medicineRepository.save(medicine);
	 }
	 
	 @GetMapping("/medicines")
	 public List<Medicine> getAllMedicine()
	 {
		 return medicineRepository.findAll();
	 }
	 
	 @GetMapping("/medicines/{id}")
	 public Medicine getMedicineById(@PathVariable Long id) {
	     return medicineRepository.findById(id)
	             .orElseThrow(() -> new RuntimeException("Medicine not found with id " + id));
	 }

	 
	 @PutMapping("/medicines/{id}")
	 public Medicine updateMedicine(
	         @PathVariable Long id,
	         @RequestBody Medicine medicine) {

	     Medicine existing = medicineRepository.findById(id)
	             .orElseThrow(() -> new RuntimeException("Medicine not found with id " + id));

	     existing.setDrugName(medicine.getDrugName());
	     existing.setStock(medicine.getStock());

	     return medicineRepository.save(existing);
	 }

	 @DeleteMapping("/medicines/{id}")
	 public String deleteMedicine(@PathVariable Long id) {

	     if (!medicineRepository.existsById(id)) {
	         throw new PatientNotFoundException(id); 
	         // किंवा MedicineNotFoundException वापर (best)
	     }

	     medicineRepository.deleteById(id);
	     return "Medicine deleted successfully";
	 }


	 
}
