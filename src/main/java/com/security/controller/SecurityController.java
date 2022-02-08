package com.security.controller;

import com.security.dto.JwtRequest;
import com.security.dto.JwtResponse;
import com.security.service.UserManagementService;
import com.security.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
       log.info("Entered in generateToken() method "+ jwtRequest);
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(),jwtRequest.getPassword()));
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new BadCredentialsException("Bad Credentials");
        }catch(BadCredentialsException e){
            e.printStackTrace();
            throw new BadCredentialsException("Bad Credentials");
        }

        UserDetails userDetails = this.userManagementService.loadUserByUsername(jwtRequest.getUserName());
        String token = this.jwtUtil.generateToken(userDetails);
        log.info("Exit from generateToken() method with token "+ token);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
