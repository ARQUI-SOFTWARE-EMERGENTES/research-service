package com.papervoult.research.service;

import com.papervoult.research.domain.model.entity.ResearchRecord;
import com.papervoult.research.domain.persistance.ResearchRecordRepository;
import com.papervoult.research.domain.service.ResearchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ResearchRecordServiceImpl implements ResearchRecordService {

    @Autowired
    private ResearchRecordRepository researchRecordRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResearchRecord> getAllResearch() {
        return researchRecordRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ResearchRecord> getResearchById(Integer id) {
        return researchRecordRepository.findById(id);
    }

    @Transactional
    @Override
    public ResearchRecord save(ResearchRecord researchRecord) {
        return researchRecordRepository.save(researchRecord);
    }

    @Transactional
    @Override
    public ResearchRecord update(ResearchRecord researchRecord) {
        return researchRecordRepository.save(researchRecord);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (researchRecordRepository.existsById(id)){
            researchRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
