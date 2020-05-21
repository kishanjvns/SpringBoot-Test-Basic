package com.tech.kj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.kj.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

}
