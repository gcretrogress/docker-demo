package com.sumit.playjava.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.playjava.model.UserModel;

@RestController
public class MyController {
	
	private static final Map<String, Integer> iceCreamFlavors = new HashMap<>();
    static {
        iceCreamFlavors.put("vanilla", 30);
        iceCreamFlavors.put("chocolate", 25);
        iceCreamFlavors.put("strawberry", 20);
        iceCreamFlavors.put("mint chocolate chip", 15);
        iceCreamFlavors.put("cookie dough", 10);
    }

	@GetMapping("/test-docker")
	public String getData(
			@RequestParam("paramName") String param
			) {
		return "Hello" + param +
				" you are in docker tutorial project of play java";
	}
	
	@PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserModel userModel) {
        // get the data passed by user/passed to postman
        
       // return the saved data and an Okay.
        return new ResponseEntity(userModel.getName()+" is saved.", HttpStatus.OK);
    }
	
	@GetMapping("/most_common_flavor")
    public Map<String, Object> mostCommonFlavor() {
        // Find the most common ice cream flavor
        String mostCommonFlavor = iceCreamFlavors.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown");

        // Return the result
        Map<String, Object> result = new HashMap<>();
        result.put("most_common_flavor", mostCommonFlavor);
        result.put("popularity", iceCreamFlavors.get(mostCommonFlavor));

        return result;
    }
}
