package com.example.myproject2.Dr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DrService {
    @Autowired
    private DrRepository repo;

    public List<Dr> listAll() {
        return (List<Dr>) repo.findAll();
    }

    public void save(Dr dr) {
        repo.save(dr);
    }

    public Dr get(Integer id) throws DrNotFoundException {
        Optional<Dr> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new DrNotFoundException("could not find any user with ID " + id);
    }

    public void delete(Integer id) throws DrNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new DrNotFoundException("could not find any user with ID " + id);
        }
        repo.deleteById(id);
    }
}
