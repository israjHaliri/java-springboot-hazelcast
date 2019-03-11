package com.haliri.israj.javaspringboothazelcast.service;

import com.haliri.israj.javaspringboothazelcast.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatchService {

    private final String key = "employee";

    public User save(User user) {
        return user;
    }

    @Cacheable(value = key)
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1", "jono"));

        return userList;
    }

    @Cacheable(value = key, key = "#id")
    public User findById(String id) {
        return null;
    }

    @CachePut(value = key, key = "#user.id")
    public User update(User user) {
        return user;
    }

    @CacheEvict(value = key, key = "#id")
    public void delete(String id) {
    }
}
