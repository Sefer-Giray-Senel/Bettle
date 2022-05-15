package com.BettleAPI;

import com.BettleAPI.entity.Bet;
import com.BettleAPI.repository.BetRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
class BettleApiApplicationTests {

	private final BetRepository betRepository;

	@Test
	void contextLoads() {
	}
/*
	@Test
	public void basicInsertTest() {
		UUID gameId = UUID.randomUUID();
		UUID id = UUID.randomUUID();
		Bet bet = new Bet();
		bet.setId(id);
		bet.setGameId(gameId);
		bet.setMbn(3);
		bet.setOdd(1.5);
		bet.setTitle("Over 2.5");
		System.out.println("bet id: "+ bet.getId() + " game id: " + bet.getGameId());
		betRepository.save(bet);

		Bet bet2 = betRepository.getById(bet.getId());
		System.out.println("bet id: "+ bet2.getId() + " title: " + bet2.getTitle());
	}
 */

}
