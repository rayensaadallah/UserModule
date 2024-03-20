package com.ramasquare.backend.Repository;

import com.ramasquare.backend.Entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppUserRepo extends MongoRepository<AppUser, String> {
  Optional<AppUser> findByEmail(String email);
  boolean existsByEmail(String email);
}
