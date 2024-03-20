package com.ramasquare.backend.Dto.mapper;

import com.ramasquare.backend.Entity.AppUser;
import com.ramasquare.backend.Dto.auth.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoMapper {
  UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

  UserInfo mapToUserInfo(AppUser appUser);
}
