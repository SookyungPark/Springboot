package com.example.prj.login;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardUserDetailsService implements UserDetailsService {

    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = mapper.findById(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new BoardUserDetails(user);
    }
}
