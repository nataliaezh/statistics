package com.hedgehogs.statistics.repositories;


import com.hedgehogs.statistics.entities.Classifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifierRepository extends CrudRepository<Classifier, Long> {

}

