package com.codeinbp.hr.controller;

import com.codeinbp.hr.model.Hire;
import com.codeinbp.hr.repository.HireRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HireController {

    private final HireRepository hireRepository;

    public HireController(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }


    // get all hires
    @GetMapping("/hires")
    private List<Hire> findAllHires() {
        return hireRepository.findAllHires();
    }


    // get hire by id
    @GetMapping("/hires/{id}")
    private ResponseEntity<Hire> findHireById(@PathVariable int id) throws Exception {
        Hire hire = hireRepository.findHiresById(id);
        if(hire == null) {
            // TODO: return not found message
          throw new Exception("not Found");
        }
        return ResponseEntity.ok(hire);
    }




}
