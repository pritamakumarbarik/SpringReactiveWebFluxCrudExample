package com.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.entities.Player;

import reactor.core.publisher.Mono;

@Repository
public interface PlayerRepo extends ReactiveCrudRepository<Player, Integer> {


}
