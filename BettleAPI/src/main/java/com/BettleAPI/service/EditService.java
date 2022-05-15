package com.BettleAPI.service;

import com.BettleAPI.entity.Edit;

import com.BettleAPI.repository.EditRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class EditService {
    private final EditRepository editRepository;

    public Edit save(Edit edit) {
        return editRepository.save(edit);
    }
/*
    public void delete(UUID id) {
        editRepository.deleteById(id);
    }

    public List<Edit> findAll() {
        return editRepository.findAll();
    }

    public Edit getByID(UUID id) { return editRepository.getById(id);}

    public Long count() {
        return editRepository.count();
    }

 */
}