package com.fleet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

}
