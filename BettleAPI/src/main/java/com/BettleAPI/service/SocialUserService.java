package com.BettleAPI.service;

import com.BettleAPI.entity.SocialUser;

import com.BettleAPI.repository.SocialUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class SocialUserService {
    private final SocialUserRepository socialUserRepository;

    public SocialUser save(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public void delete(int id) {
        socialUserRepository.deleteById(id);
    }

    public List<SocialUser> findAll() {
        return socialUserRepository.findAll();
    }

    public SocialUser findOneById(int id) { return socialUserRepository.findOneById(id);}

    public void updateSocialUser(int id, String email, String firstName, String gender, String lastName, String nationality){
        socialUserRepository.updateSocialUser(id,email,firstName,gender,lastName,nationality);
    }
}

