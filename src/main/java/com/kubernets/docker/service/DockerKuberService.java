package com.kubernets.docker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.kubernets.docker.dto.Dto;
import com.kubernets.docker.entity.User;
import com.kubernets.docker.repository.DockerKuberRepository;

@Service
public class DockerKuberService {

	@Autowired
	private DockerKuberRepository repository;

	public String saveData(Dto userdto) {

		User u = new User();
	
		u.setUserName(userdto.getUserName());
		u.setAge(userdto.getAge());
		repository.save(u);
		return "success";
	}

	public List<User> getAllData() {
		List<User> users = repository.findAll();
		if (CollectionUtils.isEmpty(users)) {
			return new ArrayList<>();

		} else {

			return users;

		}
	}

	public User getUserById(Integer id) {
		Optional<User> u = repository.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		return null;
	}

}
