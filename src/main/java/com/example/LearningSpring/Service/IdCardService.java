package com.example.LearningSpring.Service;

import com.example.LearningSpring.Model.Dto.Request.IdCardRequest;
import com.example.LearningSpring.Model.Dto.Response.IdCardResponse;

import java.util.List;

public interface IdCardService {

    List<IdCardResponse> getAllIdCards();
    IdCardResponse getIdCardById(Long id);
    void addIdCard(IdCardRequest idCardRequest);
    void updateIdCard(Long id, IdCardRequest idCardRequest);
    void updateIdCardAge(Long id, Integer age);
    void deleteIdCard(Long id);

}