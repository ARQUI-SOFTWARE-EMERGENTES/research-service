package com.papervoult.research.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("researchRecordMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ResearchRecordMapper researchRecordMapper(){ return new ResearchRecordMapper();}
}
