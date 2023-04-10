package com.kubernets.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kubernets.docker.entity.User;

@Repository
public interface DockerKuberRepository extends JpaRepository<User, Integer> {


}
