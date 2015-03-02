package com.spring.domain;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String name;
	private Boolean dead;
	private Date created;
}
