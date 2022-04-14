package com.introidx.lhc_backend.services;

import com.introidx.lhc_backend.domain.User;
import com.introidx.lhc_backend.exceptions.EtAuthException;

/**
 * Created by PRAKASH RANJAN on 11-04-2022
 */
public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String name, String email, String password, String role ) throws EtAuthException;
}
