package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.AddTrait;
import com.makefriend.makefriend.dto.InterestCategoryDTO;
import com.makefriend.makefriend.model.Interest;
import com.makefriend.makefriend.model.InterestCategory;
import com.makefriend.makefriend.repository.InterestCategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestCategoryService {
    private final InterestCategoryRepository interestCategoryRepository;

    public InterestCategoryService(InterestCategoryRepository interestCategoryRepository) {
        this.interestCategoryRepository = interestCategoryRepository;
    }

    public InterestCategory findOne(Long id) {
        return interestCategoryRepository.findById(id).get();
    }

    public List<InterestCategory> findAll() {
        return interestCategoryRepository.findAll();
    }

    public List<InterestCategory> addCategory(AddTrait addCategory){
        InterestCategory ic = new InterestCategory();
        ic.setName(addCategory.getName());
        interestCategoryRepository.save(ic);
        return findAll();
    }
    public InterestCategory save(InterestCategory interestCategory){
       return interestCategoryRepository.save(interestCategory);
    }

}
