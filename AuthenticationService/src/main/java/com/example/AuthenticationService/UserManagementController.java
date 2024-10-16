package com.example.AuthenticationService;

import com.example.AuthenticationService.Models.Role;
import com.example.AuthenticationService.Models.User;
import com.example.AuthenticationService.Security.AuthenticationRequest;
import com.example.AuthenticationService.Security.AuthenticationResponse;
import com.example.AuthenticationService.Security.RegisterRequest;
import com.example.AuthenticationService.UserDAO.UserDAO;
import com.example.AuthenticationService.UserManagementService.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class UserManagementController {

    private final AuthenticationService service;
    private final UserDAO userDAO;
    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request
    ) {
        service.register(request);
       // User user = userDAO.GetById(352);
       // System.out.println(user.getTokensString().get(0));
        return "Merhaba";
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    )
    {
        return ResponseEntity.ok(service.authenticate(request));

    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }
    @GetMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable Integer id){
        service.deleteUserById(id);
    }
   //i will come back here
    @GetMapping("/updateUserRole/{userId}/{role}")
    public void updateUserRole(@PathVariable Role role,
                               @PathVariable Integer userId){
        service.updateUserRole(role,userId);
    }

}//203 token olucak mı