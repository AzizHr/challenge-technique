package com.example.challengetechnique.utils;

import com.example.challengetechnique.enums.Role;
import com.example.challengetechnique.models.User;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FakeUserGenerator {
    private final Faker faker;

    public User generate(User user) {
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setBirthDate(faker.date().birthday());
        user.setCity(faker.address().city());
        user.setCountry(faker.address().country());
        user.setAvatar(faker.avatar().image());
        user.setCompany(faker.company().name());
        user.setJobPosition(faker.job().position());
        user.setMobile(faker.phoneNumber().phoneNumber());
        user.setEmail(faker.internet().emailAddress());
        user.setUsername(faker.internet().emailAddress());
        user.setPassword(faker.internet().password(6, 10));
        user.setRole(faker.random().nextBoolean() ? Role.ADMIN : Role.USER);
        return user;
    }
}
