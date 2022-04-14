package com.introidx.lhc_backend.services;

import com.introidx.lhc_backend.domain.User;
import com.introidx.lhc_backend.exceptions.EtAuthException;
import com.introidx.lhc_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

/**
 * Created by PRAKASH RANJAN on 11-04-2022
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email , password);
    }

    @Override
    public User registerUser(String name, String email, String password, String role) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid Email Format");
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new EtAuthException("Email Already In Use");
        Integer userId = userRepository.create(name, email, password, role);
        return userRepository.findById(userId);
    }
}
