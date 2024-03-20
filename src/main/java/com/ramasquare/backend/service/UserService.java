package com.ramasquare.backend.service;

import com.ramasquare.backend.Entity.AppUser;

public interface UserService {
  AppUser getUserInfo(String userId);

  void changePassword(String userId, String oldPassword, String newPassword);

  AppUser updateName(String userId, String name);

  AppUser updateEmail(String userId, String email);
}
