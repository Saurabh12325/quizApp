package com.CloudQuest.quizApp.Controller;
import com.CloudQuest.quizApp.DTO.admin.AdminLoginDTO;
import com.CloudQuest.quizApp.DTO.admin.AdminRegisterDTO;
import com.CloudQuest.quizApp.Entity.Admin;
import com.CloudQuest.quizApp.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    // Admin Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminRegisterDTO adminRegisterDTO) {
        try {
            Admin admin = new Admin();
            admin.setAdminId(adminRegisterDTO.getAdminId());
            admin.setPassword(adminRegisterDTO.getPassword());
            Admin createdAdmin = adminService.registerAdmin(adminRegisterDTO);
            log.info("Created successfully"+createdAdmin.toString());
            return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED); // 201 Created status
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400 Bad Request in case of error
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO) {
        try {
            // Use the login credentials to generate JWT token
            String token = adminService.loginAdmin(adminLoginDTO);
            return ResponseEntity.ok().body(new JwtResponse(token)); // 200 OK and return the token
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED); // 401 Unauthorized for invalid login
        }
    }
}

