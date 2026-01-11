package dev.akibaz.user_managament_rest_api.user.dao;

import dev.akibaz.user_managament_rest_api.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndActiveTrue(String email);

    Page<User> findAllByActiveTrue(Pageable pageable);
}
