package com.andy.security.repository;

import com.andy.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Leone
 * @since 2018-01-26
 **/
public interface UserRepository extends JpaRepository<User, Long> {


}
