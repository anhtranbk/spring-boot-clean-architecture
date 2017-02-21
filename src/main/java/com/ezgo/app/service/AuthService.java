package com.ezgo.app.service;

import com.ezgo.app.dto.AccessTokenDTO;
import com.ezgo.app.dto.SignInDTO;
import com.ezgo.app.dto.SignUpDTO;
import com.ezgo.app.dto.UserDTO;

public interface AuthService {

    UserDTO userSignUp(SignUpDTO signUpDTO);

    AccessTokenDTO userSignIn(SignInDTO signInDTO);
}
