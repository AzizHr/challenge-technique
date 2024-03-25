package com.example.challengetechnique.services.impl;

import com.example.challengetechnique.exceptions.InvalidCountValueException;
import com.example.challengetechnique.models.User;
import com.example.challengetechnique.services.UsersGeneratorService;
import com.example.challengetechnique.utils.FakeUserGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersGeneratorServiceImpl implements UsersGeneratorService {

    private final FakeUserGenerator fakeUserGenerator;

    @Override
    public List<User> generateUsers(int count) throws InvalidCountValueException {
        if(count <= 0) {
            throw new InvalidCountValueException("Count value must be greater than 0");
        }
        List<User> users = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            User user = fakeUserGenerator.generate(new User());
            users.add(user);
        }
        return users;
    }
}
