package blog.service;

import blog.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserSession {


    @Autowired
    UserMapper userMapper;




}

