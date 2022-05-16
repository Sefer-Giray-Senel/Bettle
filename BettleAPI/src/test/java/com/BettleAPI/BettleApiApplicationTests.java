package com.BettleAPI;

import com.BettleAPI.entity.Admin;
import com.BettleAPI.entity.Bans;
import com.BettleAPI.entity.Bet;
import com.BettleAPI.entity.User;
import com.BettleAPI.entity.compositeId.BansId;
import com.BettleAPI.repository.AdminRepository;
import com.BettleAPI.repository.BansRepository;
import com.BettleAPI.repository.BetRepository;
import com.BettleAPI.repository.UserRepository;
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

	@Test
	void contextLoads() {
	}
/*
	@Test
	public void basicInsertTest() {

		User user = userRepository.findPasswordByUsername("usman");
		System.out.println(user.getPassword());
	}


 */

}
