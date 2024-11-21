//package com.CloudQuest.quizApp.Service;
//
//package com.blogApp.auth.services;
////import com.blogApp.auth.entities.RefreshToken;
//import com.CloudQuest.quizApp.Entity.RefreshToken;
//import com.CloudQuest.quizApp.Entity.User;
//import com.CloudQuest.quizApp.Repository.RefreshTokenRepository;
//import com.CloudQuest.quizApp.Repository.UserRepository;
////import com.blogApp.auth.entities.User;
////import com.blogApp.auth.repositories.RefreshTokenRepository;
////import com.blogApp.auth.repositories.UserRepository;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import java.time.Instant;
//import java.util.UUID;
//
//@Service
//public class RefreshTokenService {
//    private final UserRepository userRepository;
//    private final RefreshTokenRepository refreshTokenRepository;
//
//    public RefreshTokenService(UserRepository userRepository, RefreshTokenRepository refreshTokenRepository) {
//        this.userRepository = userRepository;
//        this.refreshTokenRepository = refreshTokenRepository;
//    }
//
//    public RefreshToken createRefreshToken(String username) {
////        System.out.println("refresh token called");
//        User user = userRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with Username: " + username));
//        System.out.println(user.toString());
//        System.out.println("user found");
//        RefreshToken refreshToken = user.getRefreshToken();
//
//        if (refreshToken == null) {
//            long refreshTokenValidity = 30 * 100000;
//            refreshToken = RefreshToken.builder()
//                    .refreshToken(UUID.randomUUID().toString())
//                    .expirationTime(Instant.now().plusMillis(refreshTokenValidity))
//                    .user(user)
//                    .build();
//
//            refreshTokenRepository.save(refreshToken);
//        }
//        System.out.println("Refresh Token"+refreshToken);
//        return refreshToken;
//    }
//
//    public RefreshToken verifyRefreshToken(String refreshToken) {
//        RefreshToken refToken = RefreshTokenRepository.findByRefreshToken(refreshToken)
//                .orElseThrow(() -> new RuntimeException("Refresh token not found!"));
//
//        if (refToken.getExpirationTime().compareTo(Instant.now()) < 0) {
//            refreshTokenRepository.delete(refToken);
//            throw new RuntimeException("Refresh token has expired!");
//        }
//
//        return refToken;
//    }
//}