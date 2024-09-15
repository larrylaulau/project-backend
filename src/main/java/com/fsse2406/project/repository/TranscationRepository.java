package com.fsse2406.project.repository;

import com.fsse2406.project.data.transcation.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TranscationRepository extends CrudRepository<TransactionEntity, Integer> {
    Optional<TransactionEntity>findByTidAndUser_FirebaseUid(Integer tid, String firebaseUid);
}
