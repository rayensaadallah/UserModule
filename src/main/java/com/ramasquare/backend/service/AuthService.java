package com.ramasquare.backend.service;

import com.ramasquare.backend.Dto.auth.LoginRequest;
import com.ramasquare.backend.Dto.auth.SignUpRequest;

public interface AuthService {
  String signUp(SignUpRequest signUpRequest);

  String login(LoginRequest loginRequest);

  String verifyToken(String accessToken);
}
