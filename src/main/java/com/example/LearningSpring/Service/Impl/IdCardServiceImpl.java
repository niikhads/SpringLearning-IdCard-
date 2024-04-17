package com.example.LearningSpring.Service.Impl;

import com.example.LearningSpring.Mapper.IdCardMapper;
import com.example.LearningSpring.Model.Dto.Request.IdCardRequest;
import com.example.LearningSpring.Model.Dto.Response.IdCardResponse;
import com.example.LearningSpring.Model.Entity.IdCard;
import com.example.LearningSpring.Repository.IdCardRepository;
import com.example.LearningSpring.Service.IdCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j

@Service
//@RequiredArgsConstructor
public class IdCardServiceImpl implements IdCardService {

    private final IdCardMapper idCardMapper;
    private final IdCardRepository idCardRepository;

    public IdCardServiceImpl(IdCardMapper idCardMapper, IdCardRepository idCardRepository) {
        this.idCardMapper = idCardMapper;
        this.idCardRepository = idCardRepository;
    }

    @Override
    public List<IdCardResponse> getAllIdCards() {
        List<IdCard> idCards = idCardRepository.getAll();

        List<IdCardResponse> idCardResponseList = idCardMapper.toIdCardResponseList(idCards);

        return idCardResponseList;
    }



    @Override
    public IdCardResponse getIdCardById(Long id) {
        IdCard idCard = idCardRepository.getById(id);

        IdCardResponse idCardResponse = idCardMapper.toIdCardResponse(idCard);

        return idCardResponse;
    }

    @Override
    public void addIdCard(IdCardRequest idCardRequest) {
        log.info("AddIdCard request recieved.IdCardRequest: {}" , idCardRequest);
        IdCard idCard = idCardMapper.toIdCard(idCardRequest);
        log.info("IdCardRequest mapped to IdCard, IdCard : {}", idCard);
        idCardRepository.insert(idCard);
        log.info("ADD process sucsesfull.");
        log.warn("Just warning {}" , idCardRequest);
        log.error("Just error {}", idCardRequest);
    }

    @Override
    public void updateIdCard(Long id, IdCardRequest idCardRequest) {
        IdCard idCard = idCardMapper.toIdCard(id, idCardRequest);
        idCardRepository.update(idCard);
    }

    @Override
    public void updateIdCardAge(Long id, Integer age) {
        idCardRepository.updateAge(id, age);
    }

    @Override
    public void deleteIdCard(Long id) {
        idCardRepository.delete(id);
    }

}