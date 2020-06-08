package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.AddInterestDTO;
import com.makefriend.makefriend.model.Interest;
import com.makefriend.makefriend.model.InterestCategory;
import com.makefriend.makefriend.repository.InterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestService {
    private InterestRepository interestRepository;
    private InterestCategoryService interestCategoryService;
    public InterestService(InterestRepository interestRepository, InterestCategoryService interestCategoryService) {
        this.interestRepository = interestRepository;
        this.interestCategoryService = interestCategoryService;
    }

    public Interest findOne(Long interestId) {
        return interestRepository.findById(interestId).get();
    }

    public Interest findByName(String name){
        return interestRepository.findByName(name);
    }

    public List<InterestCategory> addInterest(AddInterestDTO interestDTO){
        Interest interest = new Interest();
        interest.setName(interestDTO.getName());
        InterestCategory cat = interestCategoryService.findOne(interestDTO.getCategoryId());
        interest.setCategory(cat);
        interest = interestRepository.save(interest);
        cat.getInterests().add(interest);
        interestCategoryService.save(cat);
        return interestCategoryService.findAll();
    }
}
