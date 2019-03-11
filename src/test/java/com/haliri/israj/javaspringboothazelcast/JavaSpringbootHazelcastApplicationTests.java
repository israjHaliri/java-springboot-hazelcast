package com.haliri.israj.javaspringboothazelcast;

import com.haliri.israj.javaspringboothazelcast.domain.User;
import com.haliri.israj.javaspringboothazelcast.service.CatchService;
import com.haliri.israj.javaspringboothazelcast.service.HazelcastSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaSpringbootHazelcastApplicationTests {

    @Autowired
    private HazelcastSerivce hazelcastSerivce;
    
    @Autowired
    private CatchService catchService;

    @Test
    public void contextLoads() {
        hazelcastSerivce.save("1", "israj");
        System.out.println("value 1 : " + hazelcastSerivce.get("1"));
        System.out.println("value all : " + hazelcastSerivce.get().toString());
        hazelcastSerivce.delete("1");
        System.out.println("value all : " + hazelcastSerivce.get().toString());

        System.out.println("---------------------------");

        catchService.findAll().forEach(s -> {
            System.out.println("value " + s.getId() + " : " + s.getName());
        });

        catchService.update(new User("1", "jono haliri"));
        System.out.println("value " + catchService.findById("1").getId() + " : " + catchService.findById("1").getName());

        catchService.delete("id");
    }

}
