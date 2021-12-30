package com.codeinbp.hr.controller;

import com.codeinbp.hr.model.Hire;
import com.codeinbp.hr.repository.HireRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class HireController {

    private final HireRepository hireRepository;

    public HireController(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }


    // get all hires
    @GetMapping("/hires")
    public List<Hire> findAllHires() {
        return hireRepository.findAllHires();
    }


    // get hire by id
    @GetMapping("/hires/{id}")
    public ResponseEntity<Hire> findHireById(@PathVariable int id) throws Exception {
        Hire hire = hireRepository.findHiresById(id);
        if(hire == null) {
            // TODO: return not found message
          throw new Exception("not Found");
        }
        return ResponseEntity.ok(hire);
    }


    // delete hire
    @DeleteMapping("/hires/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHire(@PathVariable int id) {
        hireRepository.deleteHireById(id);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }


    // update hire
    @PutMapping("/hires/{id}")
    public ResponseEntity<Hire> updateHire(@PathVariable int id, @RequestBody Hire hireDetails) throws Exception {
        if(hireRepository.updateHire(new Hire(id, hireDetails.getFirstName(), hireDetails.getLastName(), hireDetails.getEmail(), hireDetails.getHireDate(), hireDetails.getContractType(), hireDetails.getSerialNumber(), hireDetails.getPhoto())) == 0) {
            throw new Exception("hire id not found");
        }
        return ResponseEntity.ok(hireRepository.findHiresById(id));
    }


    // add new hire
    @PostMapping("/hires")
    public Hire addNewHire(@RequestBody Hire hire) throws Exception {
       //TODO: use uuid
        int id = (int) (Math.random() * 12)+2;
        hire.setId(id);
        if(hireRepository.findHiresById(hire.getId()) == null) {
            hireRepository.addNewHire(hire);
            return hireRepository.findHiresById(hire.getId());
        } else {
            throw new Exception("Hire id already exit");
        }
    }

}
