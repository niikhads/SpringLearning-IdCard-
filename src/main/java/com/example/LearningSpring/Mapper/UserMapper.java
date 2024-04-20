package com.example.LearningSpring.Mapper;


import com.example.LearningSpring.Model.Dto.Request.RegisterRequest;
import com.example.LearningSpring.Model.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User toUser(RegisterRequest registerRequest);
}
