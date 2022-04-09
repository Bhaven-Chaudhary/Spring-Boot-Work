package com.jpa.exp.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.exp.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
