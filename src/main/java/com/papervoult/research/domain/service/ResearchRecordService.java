package com.papervoult.research.domain.service;

import com.papervoult.research.domain.model.entity.ResearchRecord;

import java.util.List;
import java.util.Optional;


public interface ResearchRecordService {
    List<ResearchRecord> getAllResearch();
    Optional<ResearchRecord> getResearchById(Integer id);
    ResearchRecord save(ResearchRecord researchRecord);
    ResearchRecord update(ResearchRecord researchRecord);
    boolean deleteById(Integer id);
}
