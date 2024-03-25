package com.example.challengetechnique.services;

import com.example.challengetechnique.exceptions.InvalidCountValueException;
import com.example.challengetechnique.models.User;
import java.util.List;

public interface UsersGeneratorService {
    List<User> generateUsers(int count) throws InvalidCountValueException;
}
