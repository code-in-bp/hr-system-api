package com.codeinbp.hr.controller;

import com.codeinbp.hr.model.Hire;
import com.codeinbp.hr.repository.HireRepository;
import com.codeinbp.hr.utils.SearchBySerialNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class HireController {

    private final HireRepository hireRepository;

    public HireController(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }


    // TODO: secure all routes
    // TODO: implement search by serial number

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
    public ResponseEntity<Hire> addNewHire(@RequestBody Hire hire) {
        try {
            //TODO: use uuid
            int id = (int) (Math.random() * 12)+2;
            hire.setId(id);
            if(hireRepository.findHiresById(hire.getId()) == null)
                hireRepository.addNewHire(hire);
                return new ResponseEntity<>(hireRepository.findHiresById(hire.getId()), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/hires/search/{serialNumber}")
    public ResponseEntity<String> searchHireBySerialNum(@PathVariable String serialNumber) {
        try {
            List<Hire> hires = hireRepository.findAllHires();
            String searchedHire = SearchBySerialNumber.searchBySerialNumber.apply(serialNumber, hires);

            return ResponseEntity.ok(searchedHire);
        } catch (Exception e) {
            return new  ResponseEntity<>("404 not found", HttpStatus.NOT_FOUND);
        }


    }
}
