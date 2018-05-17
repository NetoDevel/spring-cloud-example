package br.com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.auth.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);
}