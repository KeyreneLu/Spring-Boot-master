package com.studies.keyrenelu.repository;

import com.studies.keyrenelu.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User>,Serializable{

    User findUserByUserName(String userName);

    User findUserByUserNameAndEmail(String userName, String email);
}