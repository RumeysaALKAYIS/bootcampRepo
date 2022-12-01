package com.kodlamaio.boothcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.boothcampProject.entities.users.Instructor;

public interface InstracterRepository extends JpaRepository<Instructor, Integer>{

}
