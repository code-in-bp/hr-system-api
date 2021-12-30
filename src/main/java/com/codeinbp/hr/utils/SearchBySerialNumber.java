package com.codeinbp.hr.utils;

import com.codeinbp.hr.model.Hire;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SearchBySerialNumber {

   public static  BiFunction<String, List<Hire>, String> searchBySerialNumber = (serialNumber, listOfHires) -> {
       List<Hire> x = listOfHires.stream()
               .filter(h -> h.getSerialNumber().equals(serialNumber))
               .collect(Collectors.toList());

       return String.valueOf(x.get(0));
    };


}
