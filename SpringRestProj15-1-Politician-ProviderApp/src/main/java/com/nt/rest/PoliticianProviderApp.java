package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Politician;

@RestController
@RequestMapping("/politician/api")
public class PoliticianProviderApp {

	@GetMapping("/get")
	public ResponseEntity<Politician> getPoliticianDetails() {
		System.out.println("PoliticianProviderApp.getPoliticianDetails()");
		Politician politician = new Politician(123, "Jagan", "YSRCP", "CM", 45.0f);
		return new ResponseEntity<Politician>(politician, HttpStatus.OK);
	}

	@GetMapping("/getList")
	public ResponseEntity<List<Politician>> getPoliticianListDetails() {
		System.out.println("PoliticianProviderApp.getPoliticianListDetails()");
		List<Politician> politiciansList = List.of(new Politician(123, "Jagan", "YSRCP", "CM", 49.0f),
				new Politician(324, "Pawan", "JANASENA", "Leader", 50.0f),
				new Politician(143, "Loki", "TDP", "Ex-MLC", 39.0f));
		return new ResponseEntity<List<Politician>>(politiciansList, HttpStatus.OK);
	}

	@GetMapping("/getMap")
	public ResponseEntity<Map<String, String>> getPoliticianMapDetails() {
		System.out.println("PoliticianProviderApp.getPoliticianMapDetails()");
		Map<String, String> politiciansMap = Map.of("Aadhar", "AAA12312312", "VoterID", "VVVV123231", "Passport",
				"PPP1233");
		return new ResponseEntity<Map<String, String>>(politiciansMap, HttpStatus.OK);
	}

}
