package com.klu.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    // Add this method
    boolean existsByGmail(String gmail);
}
