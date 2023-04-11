package com.kubernets.docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kubernets.docker.dto.Dto;
import com.kubernets.docker.entity.User;
import com.kubernets.docker.service.DockerKuberService;

@RestController
public class DockerKuberController {
	@Autowired
	private DockerKuberService service;

	@GetMapping("get")
	public List<User> getResponseFromDb() {
		return service.getAllData();

	}

	@PostMapping("save")
	public String saveData(@RequestBody Dto userdto) {
		return service.saveData(userdto);
	}

	@PostMapping("save")
	public String saveData1(@RequestBody Dto userdto) {
		return service.saveData(userdto);
	}

	@PostMapping("save")
	public String saveData2(@RequestBody Dto userdto) {
		return service.saveData(userdto);
	}
	
	@PostMapping("save")
	public String saveData3(@RequestBody Dto userdto) {
		return service.saveData(userdto);
	}

	
	public User getUserById(Integer id) {
		return service.getUserById(id);
	}
}
