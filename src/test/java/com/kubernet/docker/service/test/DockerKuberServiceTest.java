package com.kubernet.docker.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kubernets.docker.dto.Dto;
import com.kubernets.docker.entity.User;
import com.kubernets.docker.repository.DockerKuberRepository;
import com.kubernets.docker.service.DockerKuberService;

@ExtendWith(MockitoExtension.class)
public class DockerKuberServiceTest {

	@Mock
	private DockerKuberRepository repository;

	@InjectMocks
	private DockerKuberService dockerKuberService;

	Optional<User> u = Optional.of(new User());
     Dto dto = new Dto();
	@BeforeEach
	public void UserService() {
		u.get().setId(0);
		u.get().setAge(23);
		u.get().setUserName("shashank");
	}

	@Test
	public void saveData() {
		dto.setId(u.get().getId());
		dto.setAge(u.get().getAge());
		dto.setUserName(u.get().getUserName());
		Mockito.when(repository.save(u.get())).thenReturn(u.get());
		String response = dockerKuberService.saveData(dto);
		assertEquals("success",response);

	}

	@Test
	public void getUser() {
		Mockito.when(repository.findById(u.get().getId())).thenReturn(u);
		User user = dockerKuberService.getUserById(u.get().getId());
		assertEquals(user, u.get());

	}

	@Test
	public void getAllUser() {
		List<User> list = new ArrayList<User>();
		list.add(u.get());
		Mockito.when(repository.findAll()).thenReturn(list);
		List<User> response = dockerKuberService.getAllData();
		assertEquals(response.size(), list.size());

	}
}
