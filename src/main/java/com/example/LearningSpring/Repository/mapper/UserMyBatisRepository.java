package com.example.LearningSpring.Repository.mapper;

import com.example.LearningSpring.Model.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMyBatisRepository {

    void insert(User user);
    Optional<User> findByUsername(@Param("username") String username);

}
