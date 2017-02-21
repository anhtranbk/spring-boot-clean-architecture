package com.ezgo.app.repository;

import com.ezgo.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT COUNT(u.id) > 0 FROM User u WHERE u.email=:email OR u.username=:username)")
    boolean exists(@Param("username") String username,
                   @Param("email") String email);

    User findByEmail(String email);

    User findByUsername(String username);
}
