package com.example.LearningSpring.Mapper;

import com.example.LearningSpring.Model.Dto.Request.IdCardRequest;
import com.example.LearningSpring.Model.Dto.Response.IdCardResponse;
import com.example.LearningSpring.Model.Entity.IdCard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdCardMapper {

    public List<IdCardResponse> toIdCardResponseList(List<IdCard> idCardList) {
        List<IdCardResponse> idCardResponseList = new ArrayList<>();

        for (IdCard idCard : idCardList) {
            IdCardResponse idCardResponse = toIdCardResponse(idCard);
            idCardResponseList.add(idCardResponse);
        }

        return idCardResponseList;
    }

    public IdCardResponse toIdCardResponse(IdCard idCard) {
        IdCardResponse idCardResponse = IdCardResponse.builder()
                .id(idCard.getId())
                .name(idCard.getName())
                .surname(idCard.getSurname())
                .age(idCard.getAge())
                .finCode(idCard.getFinCode())
                .series(idCard.getSeries())
                .serialNumber(idCard.getSerialNumber())
                .build();

        return idCardResponse;
    }

    public IdCard toIdCard(IdCardRequest idCardRequest) {
        return IdCard.builder()
                .name(idCardRequest.getName())
                .surname(idCardRequest.getSurname())
                .age(idCardRequest.getAge())
                .finCode(idCardRequest.getFinCode())
                .series(idCardRequest.getSeries())
                .serialNumber(idCardRequest.getSerialNumber())
                .build();
    }

    public IdCard toIdCard(Long id, IdCardRequest idCardRequest) {
        return IdCard.builder()
                .id(id)
                .name(idCardRequest.getName())
                .surname(idCardRequest.getSurname())
                .age(idCardRequest.getAge())
                .finCode(idCardRequest.getFinCode())
                .series(idCardRequest.getSeries())
                .serialNumber(idCardRequest.getSerialNumber())
                .build();
    }

}