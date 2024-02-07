package com.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.entities.Player;
import com.reactive.service.PlayerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping("/save") // Alternate of save API
	@ResponseStatus(value = HttpStatus.CREATED)
	public Mono<ResponseEntity<Player>> savePlayer(@RequestBody Player player) {
		Mono<ResponseEntity<Player>> map = playerService.savePlayer(player)
				.map(p -> ResponseEntity.status(HttpStatus.CREATED).body(p));
		return map;
	}

	@PostMapping("/save2") // Alternate of save API
	public ResponseEntity<Mono<Player>> savePlayer2(@RequestBody Player player) {
		Mono<Player> savePlayer = playerService.savePlayer(player);
		return new ResponseEntity<>(savePlayer, HttpStatus.CREATED);
	}

	@PostMapping("/save3") // Alternate of save API
	@ResponseStatus(value = HttpStatus.CREATED)
	public Mono<Player> savePlayer3(@RequestBody Player player) {
		Mono<Player> savePlayer = playerService.savePlayer(player);
		return savePlayer;
	}

	@GetMapping("/players")
	@ResponseStatus(value = HttpStatus.OK)
	public Flux<Player> getPlayers() {
		Flux<Player> players = playerService.getPlayers();
		return players;
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Mono<Void> deletePlayer(@PathVariable("id") int id) {
		Mono<Void> delete = playerService.deletePlayer(id);
		return delete;
	}

}
