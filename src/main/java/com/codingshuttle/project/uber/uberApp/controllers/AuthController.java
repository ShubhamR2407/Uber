package com.codingshuttle.project.uber.uberApp.controllers;

import com.codingshuttle.project.uber.uberApp.dto.DriverDto;
import com.codingshuttle.project.uber.uberApp.dto.OnBoardNewDriverDto;
import com.codingshuttle.project.uber.uberApp.dto.SignupDto;
import com.codingshuttle.project.uber.uberApp.dto.UserDto;
import com.codingshuttle.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignupDto signupDto) {
        return new ResponseEntity<>(authService.signup(signupDto), HttpStatus.CREATED);
    }

    @PostMapping("/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDto> onBoardDriver(@RequestBody Long userId, @RequestBody OnBoardNewDriverDto onBoardNewDriverDto) {
        return new ResponseEntity<>(authService.onboardNewDriver(userId, onBoardNewDriverDto.getVehicleId()), HttpStatus.CREATED);
    }

}
