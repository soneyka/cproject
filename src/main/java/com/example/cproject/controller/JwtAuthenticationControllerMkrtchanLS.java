package com.example.cproject.controller;

import com.example.cproject.config.JwtTokenUtilMcrtchanLS;
import com.example.cproject.dto.LoginDTOMkrchantLS;
import com.example.cproject.dto.UserDTOMkrtchanLS;
import com.example.cproject.service.JwtUserDetailsServiceMkrtchanLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class JwtAuthenticationControllerMkrtchanLS {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtilMcrtchanLS jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceMkrtchanLS userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTOMkrtchanLS authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails.getUsername());
        LoginDTOMkrchantLS response = new LoginDTOMkrchantLS();
        response.setToken(token);
        return ResponseEntity.ok(response);
    }
}
