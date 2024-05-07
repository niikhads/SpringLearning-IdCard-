package com.example.LearningSpring.Mapper;


import com.example.LearningSpring.Model.Dto.Request.IdCardRequest;
import com.example.LearningSpring.Model.Dto.response.IdCardResponse;
import com.example.LearningSpring.Model.Entity.IdCard;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface IdCardMapper {

        IdCardMapper INSTANCE = Mappers.getMapper(IdCardMapper.class);
        List<IdCardResponse> toIdCardResponseList(List<IdCard> idCardList);
        @Mapping(target = "id", source = "id", qualifiedByName = "buildUserFriendIdCard")
        IdCardResponse toIdCardResponse(IdCard idCard );
        @Named("buildUserFriendIdCard")
        default Long buildUserFriendIdCard(Long id){
            if(id == null){
                return null;
            }
            return  id+1;
        };

        IdCard toIdCard (IdCardRequest idCardRequest );

        IdCard toIdCard (Long id, IdCardRequest idCardRequest );
    }
