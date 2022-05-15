package com.BettleAPI;

import com.BettleAPI.entity.Admin;
import com.BettleAPI.entity.Bet;
import com.BettleAPI.entity.User;
import com.BettleAPI.repository.AdminRepository;
import com.BettleAPI.repository.BetRepository;
import com.BettleAPI.repository.UserRepository;
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

	private final AdminRepository adminRepository;
	private final UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void basicInsertTest() {
		int id = 100;
		Admin admin = new Admin();
		admin.setPhoneNumber("100");
		admin.setSalary(10);
		admin.setId(id);

		System.out.println("admin id: "+ admin.getId());

		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		user1.setUsername("usman");
		user2.setUsername("kaan");
		user3.setUsername("elif");
		user4.setUsername("giray");
		user1.setPassword("123");
		user2.setPassword("123");
		user3.setPassword("123");
		user4.setPassword("123");
		user1.setToken("bos");
		user2.setToken("bos");
		user3.setToken("bos");
		user4.setToken("bos");
		user1.setId(1);
		user2.setId(2);
		user3.setId(3);
		user4.setId(4);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		Admin admin2 = adminRepository.findOneById(admin.getId());
		System.out.println("admin id: "+ admin2.getSalary());
	}


}
