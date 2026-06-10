package com.junit.junit.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	public String getUserName(int id) {
        if (id == 1) {
            return "Ravikiran";
        }
        return "Unknown User";
    }
}
