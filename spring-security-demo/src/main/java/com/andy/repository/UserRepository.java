package com.andy.repository;

import com.andy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Mr.lyon
 * @createBy: 2018-01-26 23:20
 **/
public interface UserRepository extends JpaRepository<User, Long> {



}
