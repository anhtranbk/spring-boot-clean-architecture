package com.ezgo.app.service.impl;

import com.ezgo.app.domain.User;
import com.ezgo.app.dto.AccessTokenDTO;
import com.ezgo.app.dto.SignInDTO;
import com.ezgo.app.dto.SignUpDTO;
import com.ezgo.app.dto.UserDTO;
import com.ezgo.app.exception.InvalidCredentialsException;
import com.ezgo.app.exception.UserAlreadyExistsException;
import com.ezgo.app.repository.RefreshTokenRepository;
import com.ezgo.app.repository.UserRepository;
import com.ezgo.app.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final RefreshTokenRepository refreshTokenRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO userSignUp(SignUpDTO signUpDTO) {
        if (userRepository.exists(signUpDTO.getUsername(), signUpDTO.getEmail())) {
            throw new UserAlreadyExistsException("Username or email already existed");
        }

        User user = new User();
        user.setUsername(signUpDTO.getUsername());
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        user.setGender(signUpDTO.getGender());
        user.setAddress(signUpDTO.getAddress());
        user.setDob(signUpDTO.getDob());

        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public AccessTokenDTO userSignIn(SignInDTO signInDTO) {
        User user;
        if ((user = userRepository.findByEmail(signInDTO.getEmail())) == null) {
            throw new InvalidCredentialsException("Email or password is incorrect");
        }
        if (!passwordEncoder.matches(signInDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Email or password is incorrect");
        }

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setAccessToken(
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InNpZXVuaGFucTJAZ21haWwu" +
                        "Y29tIiwiZXhwIjoxNjQ4OTkxMjM4LCJpYXQiOjE2NDg5ODc2MzgsImp0aSI6IjRlNTFiMDA0L" +
                        "WNiYzktNGUwMS1iM2U5LTgwY2M0MGI3NWUzYyIsInN1YiI6IjY4NTk5MSJ9.mgrdA6ZqEzGSE" +
                        "4uQ4RFQ0f_J8f7EpwiTUS-xnNh7_dI"
        );
        accessTokenDTO.setTokenType("Bearer");
        accessTokenDTO.setExpiresAt(new Date(System.currentTimeMillis() + 60 * 1000));
        accessTokenDTO.setRefreshToken("A6n15JquqaQzIZL8");
        return accessTokenDTO;
    }
}
