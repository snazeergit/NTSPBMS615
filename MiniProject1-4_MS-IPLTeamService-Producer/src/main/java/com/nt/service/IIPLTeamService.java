package com.nt.service;

import com.nt.model.IPLTeam;

public interface IIPLTeamService {

	public String saveTeam(IPLTeam team);

	public IPLTeam findTeamById(int id);

	public Iterable<IPLTeam> findAllTeams();

}
