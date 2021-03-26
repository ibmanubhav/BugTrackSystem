package com.example.bts.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.bts.entity.Bug;

public interface BugRepository extends MongoRepository<Bug, String> {

}
