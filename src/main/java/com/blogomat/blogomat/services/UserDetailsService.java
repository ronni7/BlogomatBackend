package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.User;
import com.blogomat.blogomat.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        BCryptPasswordEncoder encoder = passwordEncoder();
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(name));
        System.out.println("hello");
        if (user.isPresent()) {
            User u = user.get();
            System.out.println("u = " + u);
            System.out.println("org.springframework.security.core.userdetails.User(u.getUsername(), encoder.encode(u.getPassword()),\n                    getAuthorities(u)); = " + new org.springframework.security.core.userdetails.User(u.getUsername(), encoder.encode(u.getPassword()),
                    getAuthorities(u)));
            return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),
                    getAuthorities(u));
        } else throw new UsernameNotFoundException("Username " + name + " not found");
    }

    private Collection<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (user.getRole().getName().equals("admin")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (user.getRole().getName().equals("user")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        System.out.println("grantedAuthorities = " + grantedAuthorities);
        return grantedAuthorities;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        System.out.println("ya me work bcrypt");
        return new BCryptPasswordEncoder();
    }
}
