package com.example.LearningSpring.Model.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class IdCardRequest {


    private String name;
    private String surname;
    private Integer age;
    private String finCode;
    private String series;
    private String serialNumber;

}