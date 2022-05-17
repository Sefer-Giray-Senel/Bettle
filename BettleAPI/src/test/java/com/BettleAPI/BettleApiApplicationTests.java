package com.BettleAPI;

import com.BettleAPI.entity.*;
import com.BettleAPI.entity.compositeId.BansId;
import com.BettleAPI.entity.compositeId.FriendId;
import com.BettleAPI.entity.compositeId.HasSlipId;
import com.BettleAPI.repository.*;
import com.BettleAPI.service.FriendService;
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
	private final FriendRepository friendRepository;

	@Test
	public void insertUser() {

		//Friend newFriendship = new Friend();
		//FriendId friendId = new FriendId();
		//friendId.setFirstBettorId(1407770411);
		//friendId.setSecondBettorId(757819306);
		//newFriendship.setId(friendId);
		//friendRepository.save(newFriendship);
/*
		Friend newFriendship1 = new Friend();
		FriendId friendId1 = new FriendId();
		friendId1.setSecondBettorId(1407770411);
		friendId1.setFirstBettorId(757819306);
		newFriendship1.setId(friendId1);
		friendRepository.save(newFriendship1);
*/

	}
}

