package com.skillforge.skillforge_login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillforge.skillforge_login.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	
    // built-in CRUD methods: save, findAll, findById, deleteById
	Optional<User> findById(Long id);
	boolean existsByEmail(Long id);
	Optional<User> findByEmail(String email);
}
