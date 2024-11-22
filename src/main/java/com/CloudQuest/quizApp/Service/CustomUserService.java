package com.CloudQuest.quizApp.Service;

import com.CloudQuest.quizApp.Entity.Admin;
import com.CloudQuest.quizApp.Entity.Player;
import com.CloudQuest.quizApp.Repository.AdminRepository;
import com.CloudQuest.quizApp.Repository.PlayerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final PlayerRepository playerRepository;

    public CustomUserService(AdminRepository adminRepository, PlayerRepository playerRepository) {
        this.adminRepository = adminRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByAdminId(username).orElse(null);
        if (admin != null) {
            return User.builder()
                    .username(admin.getAdminId())
                    .password("")
                    .authorities("ADMIN")
                    .build();
        }

        Player player = playerRepository.findUsersByUsername(username).orElse(null);
        if (player != null) {
            return User.builder()
                    .username(player.getUsername())
                    .password("")
                    .authorities("PLAYER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
