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

	@Test
	void contextLoads() {
	}
/*
	@Test
	public void basicInsertTest() {
		Game game1 = new Game();
		Game game2 = new Game();
		Bet	bet1 = new Bet();
		Bet bet2 = new Bet();
		Date date = new Date(500);

		game1.setDate(date);
		game1.setId(1);
		game1.setFirstTeamName("FB");
		game1.setSecondTeamName("GS");

		game2.setId(2);
		game2.setDate(date);
		game2.setFirstTeamName("kB");
		game2.setSecondTeamName("er");

		bet1.setTitle("deneme1");
		bet1.setGameId(1);
		bet1.setMbn(10);
		bet1.setOdd(2.1);
		bet1.setId(1);

		bet2.setTitle("deneme2");
		bet2.setGameId(2);
		bet2.setMbn(21);
		bet2.setOdd(3.1);
		bet2.setId(2);

		User deneme = new User();
		deneme.setId(13);
		deneme.setPassword("123");
		deneme.setUsername("kaan");

		//userRepository.save(deneme);

		//System.out.println("username: " + userRepository.findOneById(13).getUsername() + " password: " + userRepository.findOneById(13).getPassword());
		//gameRepository.save(game1);
		//gameRepository.save(game2);

		//betRepository.save(bet1);
		//betRepository.save(bet2);
	}*/
/*
	@Test
	public void betInsert() {
		Bet bet = new Bet();
		bet.setId(5);
		bet.setTitle("KG");
		bet.setMbn(1);
		bet.setOdd(1.7);
		bet.setGameId(2);

		betRepository.save(bet);

	}
 */
}

