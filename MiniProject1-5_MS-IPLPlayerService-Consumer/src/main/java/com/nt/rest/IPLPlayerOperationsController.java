package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLPlayer;
import com.nt.service.IIPLPlayerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player")
@Slf4j
public class IPLPlayerOperationsController {
	
	@Autowired
	private IIPLPlayerService playerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		//use service
		String msg=playerService.registerPlayer(player);
		log.info("Rest Controller :: request came from Player saving");
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<IPLPlayer>> showAllPlayers(){
		Iterable<IPLPlayer> list=playerService.showAllPlayers();
		log.info("Rest Controller :: request came for showing all players");
		return new ResponseEntity<Iterable<IPLPlayer>>(list, HttpStatus.OK);
	}
	


}
