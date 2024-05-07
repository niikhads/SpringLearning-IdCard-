package com.example.LearningSpring.config;

import com.example.LearningSpring.Mapper.IdCardMapper;
import com.example.LearningSpring.Mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigure {
    @Bean
    public IdCardMapper idCardMapper() {
        return IdCardMapper.INSTANCE;
    }

    @Bean
    public UserMapper userMapper(){
        return UserMapper.INSTANCE;
    }
}
//artiq lazim deyil exception hisseden -1 evvel
