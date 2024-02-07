package com.reactive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.entities.Player;
import com.reactive.repository.PlayerRepo;
import com.reactive.service.PlayerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepo playerRepo;

	@Override
	public Mono<Player> savePlayer(Player player) {
		Mono<Player> savedPlayer = playerRepo.save(player);
		return savedPlayer;
	}

	@Override
	public Flux<Player> getPlayers() {
		Flux<Player> players = playerRepo.findAll();
		return players;
	}

	@Override
	public Mono<Void> deletePlayer(int id) {
		Mono<Void> delete = playerRepo.deleteById(id);
		return delete;
	}

}
