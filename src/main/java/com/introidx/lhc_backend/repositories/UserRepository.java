package com.introidx.lhc_backend.repositories;

import com.introidx.lhc_backend.domain.User;
import com.introidx.lhc_backend.exceptions.EtAuthException;

/**
 * Created by PRAKASH RANJAN on 11-04-2022
 */
public interface UserRepository {

    /** create User and return the generated userId */
    Integer create(String name, String email, String password, String role) throws EtAuthException;
    /** find user by id and return User if found */
    User findByEmailAndPassword(String email, String password) throws EtAuthException;
    /** Check if Email is already in Use */
    Integer getCountByEmail(String email);
    /** Find user by User id */
    User findById(Integer userId);

}
