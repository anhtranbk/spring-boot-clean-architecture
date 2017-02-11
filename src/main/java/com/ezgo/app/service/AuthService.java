package com.ezgo.app.service;

import com.ezgo.app.dto.SignUpDTO;
import com.ezgo.app.dto.UserDTO;

public interface AuthService {

    UserDTO userSignUp(SignUpDTO signUpDTO);
}
