package com.example.myproject2.Dr;

import org.springframework.data.repository.CrudRepository;

public interface DrRepository extends CrudRepository<Dr, Integer> {
    public Long countById(Integer drID);
}
