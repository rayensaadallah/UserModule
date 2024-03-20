package com.ramasquare.backend.Dto.mapper;

import com.ramasquare.backend.Dto.auth.AuthRequest;
import com.ramasquare.backend.Dto.auth.LoginRequest;
import com.ramasquare.backend.Dto.auth.SignUpRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthRequestMapper {
  AuthRequestMapper INSTANCE = Mappers.getMapper(AuthRequestMapper.class);

  SignUpRequest mapToSignUpRequest(AuthRequest authRequest);

  LoginRequest mapToLoginRequest(AuthRequest authRequest);
}
