package com.CloudQuest.quizApp.Controller;
import com.CloudQuest.quizApp.Entity.Admin;
import com.CloudQuest.quizApp.Entity.Player;
import com.CloudQuest.quizApp.Service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register/admin")
    public String registerAdmin(@RequestBody Admin admin) {
        return authService.registerAdmin(admin);
    }

    @PostMapping("/register/player")
    public String registerPlayer(@RequestBody Player user) {
        return authService.registerPlayer(user);
    }

    @PostMapping("/login/admin")
    public String loginAdmin(@RequestParam String adminId, @RequestParam String password) {
        return authService.authenticateAdmin(adminId, password);
    }

    @PostMapping("/login/player")
    public String loginPlayer(@RequestParam String username) {
        return authService.authenticatePlayer(username);
    }
}
