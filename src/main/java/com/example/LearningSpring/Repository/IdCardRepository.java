package com.example.LearningSpring.Repository;


import com.example.LearningSpring.Model.Entity.IdCard;

import java.util.List;

public interface IdCardRepository {

    List<IdCard> getAll();
    IdCard getById(Long id);
    boolean insert(IdCard idCard);
    boolean update(IdCard idCard);
    boolean updateAge(Long id, Integer age);
    boolean delete(Long id);

}
