package com.papervoult.research.shared;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;

public class EnhancedModelMapper extends ModelMapper {

    public EnhancedModelMapper(){
        super();
        this.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(item -> this.map(item, targetClass)).toList();
    }
}
