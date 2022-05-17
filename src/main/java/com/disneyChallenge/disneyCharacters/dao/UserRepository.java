package com.disneyChallenge.disneyCharacters.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disneyChallenge.disneyCharacters.model.Usr;

@Repository
public interface UserRepository extends JpaRepository<Usr, Long> {
	Usr findByUsername(String username);

	Usr findByEmail(String email);
}
