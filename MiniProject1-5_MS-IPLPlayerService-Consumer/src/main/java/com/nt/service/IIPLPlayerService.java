package com.nt.service;

import com.nt.model.IPLPlayer;

public interface IIPLPlayerService {

	public String registerPlayer(IPLPlayer player);

	public Iterable<IPLPlayer> showAllPlayers();
}
