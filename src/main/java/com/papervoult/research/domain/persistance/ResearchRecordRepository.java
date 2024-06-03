package com.papervoult.research.domain.persistance;

import com.papervoult.research.domain.model.entity.ResearchRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchRecordRepository extends JpaRepository<ResearchRecord, Integer> {
}
