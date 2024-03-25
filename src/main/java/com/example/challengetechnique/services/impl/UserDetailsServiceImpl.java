package com.example.challengetechnique.services.impl;

import com.example.challengetechnique.repositories.UserRepository;
import com.example.challengetechnique.security.authenticators.UserAuthenticator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserByUsername(username).orElseThrow( () -> new UsernameNotFoundException("No user found"));
        return new UserAuthenticator(user);
    }
}
