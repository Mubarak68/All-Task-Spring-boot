package com.letcode.SecureBankSystem;

import com.letcode.SecureBankSystem.entities.GuestEntity;
import com.letcode.SecureBankSystem.entities.UserEntity;
import com.letcode.SecureBankSystem.repositories.GuestRepository;
import com.letcode.SecureBankSystem.repositories.UserRepository;
import com.letcode.SecureBankSystem.services.suggestions.SuggestionsService;
import com.letcode.SecureBankSystem.services.user.UserService;
import com.letcode.SecureBankSystem.utils.enums.SuggestionStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SecureBankSystemApplicationTests {
	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@MockBean
	private GuestRepository guestRepository;

	@Autowired
	private SuggestionsService suggestionsService;


	@Test
	public void passLargerThanEight(){
		UserEntity user1 = new UserEntity();
		user1.setName("Mubarak");
		user1.setPassword("1234847mkoj987");

		UserEntity user2 = new UserEntity();
		user2.setName("Nawaf");
		user2.setPassword("1234567dggd89njjn");

		UserEntity user3 = new UserEntity();
		user3.setName("Ahmad");
		user3.setPassword("123456");

		List<UserEntity> mockUsers = Arrays.asList(user1, user2, user3);

		Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

		assertEquals(Arrays.asList("Mubarak", "Nawaf"), userService.getAllUsersWithStrongPassword());

	}
	@Test
	public void whenGetCreateStatusSuggestions_thenSuccess(){
		List<GuestEntity> suggestions = Arrays.asList(new
				GuestEntity("text", 5, SuggestionStatus.CREATE),
				new GuestEntity("text", 5, SuggestionStatus.CREATE),
				new GuestEntity("text", 5, SuggestionStatus.REMOVE),
				new GuestEntity("text", 5, SuggestionStatus.REMOVE),
				new GuestEntity("text", 5, SuggestionStatus.CREATE));
		Mockito.when(guestRepository.findAll()).thenReturn(suggestions);

		Assertions.assertEquals(Arrays.asList(new
				GuestEntity("text", 5,
				SuggestionStatus.CREATE).getStatus(), new
				GuestEntity("text", 5, SuggestionStatus.CREATE).getStatus(), new
				GuestEntity("text", 5, SuggestionStatus.CREATE).getStatus()),
				suggestionsService.findSuggestions("CREATE").stream().map(GuestEntity::getStatus).collect(Collectors.toList()));
	}

	@Test
	public void whenGetRemoveStatusSuggestions_thenSuccess(){
		List<GuestEntity> suggestions = Arrays.asList(new
				GuestEntity("text", 5,
				SuggestionStatus.CREATE), new
				GuestEntity("text", 5,
				SuggestionStatus.CREATE), new
				GuestEntity("text", 5,
				SuggestionStatus.REMOVE), new
				GuestEntity("text", 5,
				SuggestionStatus.REMOVE), new
				GuestEntity("text", 5,
				SuggestionStatus.CREATE));
		Mockito.when(guestRepository.findAll()).thenReturn(suggestions);

		Assertions.assertEquals(Arrays.asList(new
				GuestEntity("text", 5,
				SuggestionStatus.REMOVE).getStatus(), new
				GuestEntity("text", 5,
				SuggestionStatus.REMOVE).getStatus()),
				suggestionsService.findSuggestions("REMOVE").stream().map(GuestEntity::getStatus).collect(Collectors.toList()));
	}
}