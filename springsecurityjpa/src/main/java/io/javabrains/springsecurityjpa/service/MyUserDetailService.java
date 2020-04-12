package io.javabrains.springsecurityjpa.service;

import io.javabrains.springsecurityjpa.domain.MyUserDetails;
import io.javabrains.springsecurityjpa.domain.User;
import io.javabrains.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
      private UserRepository userRepository;

    MyUserDetailService(){}


  /*  @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new MyUserDetails(s);
    }*/
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);

        user.orElseThrow(()-> new UsernameNotFoundException( s + "  Not Found"));
        return user.map(MyUserDetails::new).get();

    }
}
