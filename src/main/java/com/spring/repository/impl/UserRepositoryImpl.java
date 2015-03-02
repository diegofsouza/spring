package com.spring.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.spring.domain.User;
import com.spring.repository.UserRepository;
import com.spring.util.CacheConstants;
import com.spring.util.PropertiesConstants;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private RestTemplate restTemplate;

	@Value(PropertiesConstants.MOCKY_IO.USERS)
	private String url;

	@Override
	@Cacheable(CacheConstants.MOCKY_IO.USERS)
	public List<User> list() {
		User[] users = restTemplate.getForObject(url, User[].class);
		return Arrays.asList(users);
	}

}
