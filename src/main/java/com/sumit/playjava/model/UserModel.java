package com.sumit.playjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public UserModel() {
    }

    public UserModel(String name, Integer age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
