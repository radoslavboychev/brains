package com.iktpreobuka.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.project.entities.BillEntity;
import com.iktpreobuka.project.entities.UserEntity;

public interface BillRepository extends CrudRepository<BillEntity, Integer> {

	List<BillEntity> findByUser(UserEntity user);
}
