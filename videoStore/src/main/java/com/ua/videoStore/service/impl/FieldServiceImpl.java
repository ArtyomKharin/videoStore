package com.ua.videoStore.service.impl;

import com.ua.videoStore.model.Field;
import com.ua.videoStore.repository.FieldRepository;
import com.ua.videoStore.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl implements FieldService {

    private final FieldRepository fieldRepository;

    @Autowired
    public FieldServiceImpl(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    @Override
    public Field findOne(Integer id) {
        return fieldRepository.findOne(id);
    }
}
