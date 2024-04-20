package com.example.LearningSpring.Model.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private LocalDateTime createdAt;
    private LocalDateTime lastlogin;
    private Long idcardId;

}
