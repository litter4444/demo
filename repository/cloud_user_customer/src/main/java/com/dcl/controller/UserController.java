package com.dcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dcl.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{id}")
	public User query(@PathVariable Long id) {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("user-provider", false);
		String homePageUrl = instanceInfo.getHomePageUrl();
		System.out.println(homePageUrl);
		User user = restTemplate.getForObject(homePageUrl+"user/"+id, User.class);
		return user;
	}
}
