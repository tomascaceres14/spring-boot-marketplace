package com.tomasdev.akhanta.professional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends MongoRepository<Professional, String>, PagingAndSortingRepository<Professional, String> {
}
