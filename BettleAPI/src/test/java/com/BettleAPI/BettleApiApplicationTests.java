package com.BettleAPI;

import com.BettleAPI.entity.*;
import com.BettleAPI.entity.compositeId.BansId;
import com.BettleAPI.entity.compositeId.HasSlipId;
import com.BettleAPI.repository.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;
import java.sql.Date;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
class BettleApiApplicationTests {

	private final AdminRepository adminRepository;
	private final UserRepository userRepository;
	private final BansRepository bansRepository;
	private final BetRepository betRepository;
	private final GameRepository gameRepository;
	private final BetSlipRepository betSlipRepository;
	private final BettorHasSlipRepository bettorHasSlipRepository;
	private final SocialUserRepository socialUserRepository;
	private final BettorRepository bettorRepository;

	@Test
	public void insertUser() {
		User newUser = new User();
		newUser.setId(190);
		newUser.setPassword("123");
		newUser.setUsername("usmanyilmaz");
		userRepository.save(newUser);

		SocialUser newSocialUser = new SocialUser();
		newSocialUser.setNationality("Turk");
		newSocialUser.setLastName("yilmaz");
		newSocialUser.setFirstName("osman");
		newSocialUser.setBanned(false);
		newSocialUser.setEmail("deneme1@email.com");
		newSocialUser.setGender("adam gibi adam");
		newSocialUser.setId(newUser.getId());
		socialUserRepository.save(newSocialUser);

		Bettor newBettor = new Bettor();
		newBettor.setId(newUser.getId());
		newBettor.setBalance(99999);
		newBettor.setFriendCount(31);
		bettorRepository.save(newBettor);
	}
}

