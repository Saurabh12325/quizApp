package com.CloudQuest.quizApp.Controller;


import com.CloudQuest.quizApp.DTO.admin.AdminLoginDTO;
import com.CloudQuest.quizApp.DTO.admin.AdminRegisterDTO;
import com.CloudQuest.quizApp.Entity.Admin;
import com.CloudQuest.quizApp.Service.AdminService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {


    private final AdminService adminService;

    // Admin Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody AdminRegisterDTO adminRegisterDTO) {
        try {

            Admin admin = new Admin();
            admin.setAdminId(adminRegisterDTO.getAdminId());
            admin.setPassword(adminRegisterDTO.getPassword());
            Admin createdAdmin = adminService.registerAdmin(adminRegisterDTO);
            return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED); // 201 Created status
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400 Bad Request in case of error
        }
    }


    @PostMapping("/login")
    public ResponseEntity<Object> loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO) {
        try {
            // Use the login credentials to generate JWT token
            String token = adminService.loginAdmin(adminLoginDTO);
            return ResponseEntity.ok().body(new JwtResponse(token)); // 200 OK and return the token
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED); // 401 Unauthorized for invalid login
        }
    }
}
