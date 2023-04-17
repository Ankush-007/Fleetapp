package com.fleet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.model.Client;
import com.fleet.model.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

}
