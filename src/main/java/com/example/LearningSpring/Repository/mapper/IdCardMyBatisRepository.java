package com.example.LearningSpring.Repository.mapper;

import com.example.LearningSpring.Model.Entity.IdCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
@Mapper
public interface IdCardMyBatisRepository {


    List<IdCard> findAll();
        Optional<IdCard> findById(@Param("id") Long id);
        void insert(IdCard idCard);
        void update(IdCard idCard);
        void updateAge(@Param("id") Long id, @Param("age") Integer age);
        void delete(@Param("id") Long id);


}
