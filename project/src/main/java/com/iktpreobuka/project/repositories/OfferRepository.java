package com.iktpreobuka.project.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.project.entities.OfferEntity;
import com.iktpreobuka.project.entities.UserEntity;

public interface OfferRepository extends CrudRepository<OfferEntity, Integer> {

	Optional<OfferEntity> findById(Integer id);
}
