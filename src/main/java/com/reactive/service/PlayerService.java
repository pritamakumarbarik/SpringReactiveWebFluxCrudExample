package com.reactive.service;

import com.reactive.entities.Player;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerService {

	Mono<Player> savePlayer(Player player);

	Flux<Player> getPlayers();

	Mono<Void> deletePlayer(int id);

}
