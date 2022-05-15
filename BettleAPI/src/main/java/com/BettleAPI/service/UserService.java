package com.BettleAPI.service;

import com.BettleAPI.entity.MyUserDetails;
import com.BettleAPI.entity.User;

import com.BettleAPI.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByPassword(username);

        user.orElseThrow(()->new UsernameNotFoundException("user with email " + username + " not found"));

        return user.map(MyUserDetails::new).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getByID(UUID id) { return userRepository.getById(id);}

    public Long count() {
        return userRepository.count();
    }
}

