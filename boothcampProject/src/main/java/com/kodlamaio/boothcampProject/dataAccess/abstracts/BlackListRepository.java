package com.kodlamaio.boothcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.boothcampProject.entities.blackList.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {

}
