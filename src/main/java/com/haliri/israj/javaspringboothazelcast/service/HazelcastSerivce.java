package com.haliri.israj.javaspringboothazelcast.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HazelcastSerivce {

    private String keyMap = "visitor";

    @Autowired
    private HazelcastInstance hazelcastInstance;

    public void save(String key, String value){
        Map<String, String> hazelcastMap = hazelcastInstance.getMap(keyMap);

        hazelcastMap.put(key, value);
    }

    public void delete(String key){
        Map<String, String> hazelcastMap = hazelcastInstance.getMap(keyMap);

        ((IMap<String, String>) hazelcastMap).delete(key);
    }

    public Map<Object, Object> get(){
        return hazelcastInstance.getMap(keyMap);
    }

    public String get(String key){
        Map<String, String> hazelcastMap = hazelcastInstance.getMap(keyMap);

        return hazelcastMap.get(key);
    }
}
