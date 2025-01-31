package com.ramasquare.backend.Dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
  private String username;
  private String phoneNumber;
  private String email;
  private String password;
}
