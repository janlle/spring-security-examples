package com.andy.repository;

import com.andy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: lyon
 * @since 2018-01-26
 **/
public interface UserRepository extends JpaRepository<User, Long> {



}
