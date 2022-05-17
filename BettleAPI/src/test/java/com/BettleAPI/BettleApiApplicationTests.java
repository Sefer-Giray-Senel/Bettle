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

		Date date = new Date(100);
		Game newGame = new Game();
		newGame.setFirstTeamName("GS");
		newGame.setSecondTeamName("FB");
		newGame.setId(1);
		newGame.setDate(date);
		gameRepository.save(newGame);

		Bet newBet = new Bet();
		newBet.setOdd(1.5);
		newBet.setId(1);
		newBet.setGameId(1);
		newBet.setTitle("3.5 üst");
		newBet.setMbn(1);
		betRepository.save(newBet);

		Bet newBet2 = new Bet();
		newBet2.setOdd(2.8);
		newBet2.setId(2);
		newBet2.setGameId(1);
		newBet2.setTitle("3.5 alt");
		newBet2.setMbn(2);
		betRepository.save(newBet2);
	}
}

