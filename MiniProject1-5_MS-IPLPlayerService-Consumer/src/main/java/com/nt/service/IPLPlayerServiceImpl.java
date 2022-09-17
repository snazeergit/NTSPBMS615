package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.client.IIPLTeamServiceConsumer;
import com.nt.model.IPLPlayer;
import com.nt.model.IPLTeam;
import com.nt.repository.IIPlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service("playerService")
@Slf4j
public class IPLPlayerServiceImpl implements IIPLPlayerService {

	@Autowired
	private IIPlayerRepository playerRepo;
	@Autowired
	private IIPLTeamServiceConsumer consumer;

	@Override
	public String registerPlayer(IPLPlayer player) {
		//Use feign client MS communication to get IPLTeam info being Player service
		IPLTeam team = consumer.searchTeamById(player.getTeamInfo().getTeamId()).getBody();
		log.info("The consumer player services has consumed team service using feign client");
		//assign team object to player object
		player.setTeamInfo(team);
		log.info("Player object is saved");
		//save player object
		return "Player with team details are saved with id value : " + playerRepo.save(player).getPlayerId();
	}

	@Override
	public Iterable<IPLPlayer> showAllPlayers() {
		log.info("All player details are retrieved");
		return playerRepo.findAll();
	}

}
