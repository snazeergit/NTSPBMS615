package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.IPLTeam;
import com.nt.repository.IIPLTeamRepository;

@Service("teamService")
public class IPLTeamServiceImpl implements IIPLTeamService {
	
	@Autowired
	private IIPLTeamRepository teamRepo;

	@Override
	public String saveTeam(IPLTeam team) {
		return "team is saved with : "+teamRepo.save(team).getTeamId();
	}

	@Override
	public IPLTeam findTeamById(int id) {
		/*Optional<IPLTeam> optional = teamRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			throw new IllegalArgumentException("Invlaid team ID");
		}*/
	
	return teamRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid team ID"));
	}

	@Override
	public Iterable<IPLTeam> findAllTeams() {
		return teamRepo.findAll();
	}

}
