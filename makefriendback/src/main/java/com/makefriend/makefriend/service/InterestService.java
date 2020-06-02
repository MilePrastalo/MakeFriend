package com.makefriend.makefriend.service;

import com.makefriend.makefriend.model.Interest;
import com.makefriend.makefriend.repository.InterestRepository;
import org.springframework.stereotype.Service;

@Service
public class InterestService {
    private InterestRepository interestRepository;

    public InterestService(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    public Interest findOne(Long interestId) {
        return interestRepository.findById(interestId).get();
    }

    public Interest findByName(String name){
        return interestRepository.findByName(name);
    }
}
