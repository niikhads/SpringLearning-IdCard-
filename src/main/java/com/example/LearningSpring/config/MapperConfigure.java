package com.example.LearningSpring.config;

import com.example.LearningSpring.Mapper.IdCardMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigure {
    @Bean
    public IdCardMapper idCardMapper(){
        return IdCardMapper.INSTANCE;
    }
}
