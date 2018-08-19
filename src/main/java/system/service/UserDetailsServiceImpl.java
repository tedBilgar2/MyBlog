package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import system.model.Role;
import system.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.loadUserByEmail(s);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(Role.USER.name()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),roles);

        return userDetails;
    }
}
