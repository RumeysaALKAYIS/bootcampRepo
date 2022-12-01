package com.kodlamaio.boothcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.boothcampProject.entities.bootcamps.Boothcamp;

public interface BootCampRepository extends JpaRepository<Boothcamp, Integer> {

}
