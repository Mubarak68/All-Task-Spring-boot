package com.letcode.SecureBankSystem;

import com.letcode.SecureBankSystem.entities.UserEntity;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repositories.UserRepository;
import com.letcode.SecureBankSystem.ropsitory.UserRepository;
import com.letcode.SecureBankSystem.service.user.UserService;
import com.letcode.SecureBankSystem.services.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SecureBankSystemApplicationTests {
	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Test
	public void passLargerThanEight(){
		UserEntity user1 = new UserEntity();
		user1.setName("Mubarak");
		user1.setPassword("12348ssf847");

		UserEntity user2 = new UserEntity();
		user2.setName("Nawaf");
		user2.setPassword("1234567dggd89");

		UserEntity user3 = new UserEntity();
		user3.setName("Ahmad");
		user3.setPassword("123456");

		List<UserEntity> mockUsers = Arrays.asList(user1, user2, user3);

		Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

		assertEquals(Arrays.asList("Mubarak", "Nawaf"), userService.getAllUsersWithStrongPassword());
	}

}
