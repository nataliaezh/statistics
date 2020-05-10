package com.hedgehogs.statistics.services;

import com.hedgehogs.statistics.entities.Classifier;
import com.hedgehogs.statistics.repositories.ClassifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Service
public class ClassifierService {
    private ClassifierRepository classifierRepository;

    @Autowired
    public void setClassifierRepository(ClassifierRepository classifierRepository) {
        this.classifierRepository = classifierRepository;
    }

    public List<Classifier> findAll() {
        return (List<Classifier>) classifierRepository.findAll();
    }

    public Classifier findById(Long id) {
        return classifierRepository.findById(id).get();
    }
}
