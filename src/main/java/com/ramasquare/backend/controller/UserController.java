package com.ramasquare.backend.controller;

import com.ramasquare.backend.constant.LoggingConstants;
import com.ramasquare.backend.Dto.auth.ChangePasswordRequest;
import com.ramasquare.backend.Dto.auth.UserDetails;
import com.ramasquare.backend.Dto.auth.UserInfo;
import com.ramasquare.backend.Dto.mapper.UserInfoMapper;
import com.ramasquare.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserService userService;

  // Get user info
  @GetMapping("/{userId}")
  public ResponseEntity<UserInfo> getUserInfo(
      @PathVariable String userId
  ) {
    var methodName = "UserController:signUp";
    log.info(LoggingConstants.START_METHOD_LOG, methodName, userId);

    var appUser = userService.getUserInfo(userId);

    log.info(LoggingConstants.END_METHOD_LOG, methodName);

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(UserInfoMapper.INSTANCE.mapToUserInfo(appUser));
  }

  // Change password
  @PostMapping("/{userId}/change-password")
  public ResponseEntity<Void> changePassword(
      @PathVariable String userId,
      @RequestBody ChangePasswordRequest changePasswordRequest
  ) {
    var methodName = "UserController:changePassword";
    log.info(LoggingConstants.START_METHOD_LOG, methodName, userId);

    userService.changePassword(
        userId,
        changePasswordRequest.getOldPassword(),
        changePasswordRequest.getNewPassword()
    );

    log.info(LoggingConstants.END_METHOD_LOG, methodName);

    return ResponseEntity
        .ok()
        .build();
  }

  // Update user details
  @PostMapping("/update/{userId}")
  public ResponseEntity<UserInfo> updateUserDetails(
      @PathVariable String userId,
      @RequestBody UserDetails userDetails
  ) {
    var methodName = "UserController:changePassword";
    log.info(LoggingConstants.START_METHOD_LOG, methodName, userId);

    var appUser = switch (userDetails.getRequestType()) {
      case UPDATE_EMAIL -> userService.updateEmail(userId, userDetails.getEmail());
      case UPDATE_NAME -> userService.updateName(userId, userDetails.getName());
    };

    log.info(LoggingConstants.END_METHOD_LOG, methodName);

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(UserInfoMapper.INSTANCE.mapToUserInfo(appUser));
  }


}
