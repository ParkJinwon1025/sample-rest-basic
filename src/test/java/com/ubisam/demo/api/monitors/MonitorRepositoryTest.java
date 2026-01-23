package com.ubisam.demo.api.monitors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ubisam.demo.domain.Monitor;

@SpringBootTest
public class MonitorRepositoryTest {

    @Autowired
    private MonitorRepository monitorRepository;

    @Test
    void contextLoads() {

        // Create
        Monitor m1 = new Monitor();
        m1.setName("Samsung");
        monitorRepository.save(m1);

        Monitor m2 = new Monitor();
        m2.setName("LG");
        monitorRepository.save(m2);

        // Read
        Object findAll = monitorRepository.findAll();
        System.out.println("Find All: " + findAll);

        Object findById = monitorRepository.findById(m2.getId());
        System.out.println("Find Monitor with ID " + m2.getId() + " : " + findById);

        // Update
        m2.setName("Dell");
        Object updated = monitorRepository.save(m2);
        System.out.println("Update Monitor with ID " + m2.getId() + ": " + updated);

        // Delete
        System.out.println("Delete Monitor with ID " + m2.getId());
        monitorRepository.deleteById(m2.getId());

        Object finalResult = monitorRepository.findAll();
        System.out.println("Final Result: " + finalResult);
    }
}
