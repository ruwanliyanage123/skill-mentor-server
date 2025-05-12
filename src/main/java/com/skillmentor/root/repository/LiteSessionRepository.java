package com.skillmentor.root.repository;

import com.skillmentor.root.entity.LiteSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteSessionRepository extends JpaRepository<LiteSessionEntity, Integer> {
}
