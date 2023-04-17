package com.fleet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.model.Client;
import com.fleet.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
