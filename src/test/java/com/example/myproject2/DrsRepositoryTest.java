package com.example.myproject2;

import com.example.myproject2.Dr.Dr;
import com.example.myproject2.Dr.DrRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class DrsRepositoryTest {
    @Autowired
    private DrRepository repo;

    @Test
    public void testAddNew() {
        Dr dr = new Dr();
        dr.setDrName("Martina");
        dr.setDrAge(20);
        dr.setDrPhone("0120");

        Dr savedDr = repo.save(dr);
        Assertions.assertThat(savedDr).isNotNull();
        Assertions.assertThat(savedDr.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Dr> allDrs = repo.findAll();
        Assertions.assertThat(allDrs).hasSizeGreaterThan(0);

        for (Dr dr : allDrs) {
            System.out.println(dr.toString());
        }
    }

    @Test
    public void testUpdate() {
        int drId = 1;
        Optional<Dr> optionalDr = repo.findById(drId);
        Dr dr = optionalDr.get();
        dr.setDrName("Mina Emad");
        repo.save(dr);

        Dr updatedDr = repo.findById(drId).get();
        Assertions.assertThat(updatedDr.getDrName()).isEqualTo("Mina Emad");
    }

    @Test
    public void testGet() {
        int drId = 2;
        Optional<Dr> optionalDr = repo.findById(drId);
        Assertions.assertThat(optionalDr).isPresent();
        System.out.println(optionalDr.get());
    }

    @Test
    public void testDelete() {
        int drId = 3;
        repo.deleteById(drId);
        Optional<Dr> optionalDr = repo.findById(drId);
        Assertions.assertThat(optionalDr).isNotPresent();
    }

}
