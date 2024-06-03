package com.papervoult.research.mapping;

import com.papervoult.research.domain.model.entity.ResearchRecord;
import com.papervoult.research.resource.CreateResearchRecordResource;
import com.papervoult.research.resource.ResearchRecordResource;
import com.papervoult.research.resource.UpdateResearchRecordResource;
import com.papervoult.research.shared.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ResearchRecordMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ResearchRecord toModel(CreateResearchRecordResource resource) { return this.mapper.map(resource, ResearchRecord.class); }

    public ResearchRecord toModel(UpdateResearchRecordResource resource) { return this.mapper.map(resource, ResearchRecord.class); }

    public ResearchRecordResource toResource(ResearchRecord researchRecord){
        return this.mapper.map(researchRecord, ResearchRecordResource.class);
    }
}
