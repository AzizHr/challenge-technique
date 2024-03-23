package com.example.challengetechnique.repositories;

import com.example.challengetechnique.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
