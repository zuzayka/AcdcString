package com.javarush.lesson01.service;

import com.javarush.lesson01.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service // аннотация для ApplicationContext
@AllArgsConstructor
@ToString
public class UserService {
    private final UserRepo userRepo;
//    private final String admin;
}
