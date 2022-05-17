package com.BettleAPI;

import com.BettleAPI.entity.*;
import com.BettleAPI.entity.compositeId.BansId;
import com.BettleAPI.entity.compositeId.FriendId;
import com.BettleAPI.entity.compositeId.HasSlipId;
import com.BettleAPI.entity.compositeId.PostedId;
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
	private final FriendRepository friendRepository;
	private final BetSlipPostRepository betSlipPostRepository;
	private final PostedRepository postedRepository;

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

	@Test
	public void betSlipPostInsert() {
		/*BetSlipPost betSlipPost = new BetSlipPost();
		betSlipPost.setPostText("Usmanin Postu");
		betSlipPost.setId(13);
		betSlipPost.setTestCount(2);

		betSlipPostRepository.save(betSlipPost);
		*/
		/*
		Posted posted = new Posted();
		PostedId postedId = new PostedId();

		postedId.setUserId(180);
		postedId.setBetSlipPostId(12);
		postedId.setBetSlipId(1);

		posted.setId(postedId);
		postedRepository.save(posted);

		 */
	}

/*	@Test
	public void friendInsert() {
		Friend friend = new Friend();
		FriendId friendId = new FriendId();

		friendId.setFirstBettorId(180);
		friendId.setSecondBettorId(190);
		friend.setId(friendId);
		friendRepository.save(friend);

		Friend friend2 = new Friend();
		FriendId friendId2 = new FriendId();

		friendId2.setFirstBettorId(190);
		friendId2.setSecondBettorId(180);
		friend2.setId(friendId2);
		friendRepository.save(friend2);

		//List<BetSlipPost> betSlipPosts = betSlipPostRepository.findBetSlipPostsOfFriendsByUserId(180);
		//System.out.println(betSlipPosts.get(0).getPostText());
	}
*/

}

