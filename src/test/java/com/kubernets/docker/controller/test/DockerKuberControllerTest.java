package com.kubernets.docker.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kubernets.docker.controller.DockerKuberController;
import com.kubernets.docker.dto.Dto;
import com.kubernets.docker.entity.User;
import com.kubernets.docker.service.DockerKuberService;

@ExtendWith(MockitoExtension.class)
public class DockerKuberControllerTest {

	@Mock
	private DockerKuberService kuberService;

	@InjectMocks
	private DockerKuberController controller;

	User user = new User();
	Dto dto = new Dto();

	@BeforeEach
	public void userData() {
		user.setId(1);
		user.setAge(25);
		user.setUserName("dinedra");
	}

	@Test
	public void saveData() {
		dto.setId(user.getId());
		dto.setAge(user.getAge());
		dto.setUserName(user.getUserName());
		Mockito.when(kuberService.saveData(dto)).thenReturn("success");
		String u = controller.saveData(dto);
		assertEquals("success", u);
	}

	@Test
	public void getData() {
		List<User> u = new ArrayList<User>();
		u.add(user);
		Mockito.when(kuberService.getAllData()).thenReturn(u);
		List<User> response = controller.getResponseFromDb();
		assertEquals(response.size(), u.size());
	}

	@Test
	public void getUserById() {
		Mockito.when(kuberService.getUserById(user.getId())).thenReturn(user);
		User u = controller.getUserById(user.getId());
		assertEquals(u, user);

	}

}
