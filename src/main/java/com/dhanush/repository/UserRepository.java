package com.dhanush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhanush.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Object findByUsername(String username);

}
