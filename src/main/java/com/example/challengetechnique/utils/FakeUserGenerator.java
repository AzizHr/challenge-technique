package com.example.challengetechnique.utils;

import com.example.challengetechnique.models.User;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FakeUserGenerator {
    private final Faker faker;

    public User generate(User user) {
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setBirthDate(faker.date().birthday());
        user.setCity();
        user.setCountry();
        user.setAvatar();
        user.setCompany();
        user.setJobPosition();
        user.setMobile();
        user.setEmail();
        user.setUsername();
        user.setPassword();
        user.setRole();
    }
}
