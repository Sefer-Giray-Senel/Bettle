package com.BettleAPI.service;

import com.BettleAPI.entity.EditorHasSlip;

import com.BettleAPI.repository.EditorHasSlipRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class EditorHasSlipService {
    private final EditorHasSlipRepository editorHasSlipRepository;

    public EditorHasSlip save(EditorHasSlip editorHasSlip) {
        return editorHasSlipRepository.save(editorHasSlip);
    }
/*
    public void delete(UUID id) {
        editorHasSlipRepository.deleteById(id);
    }

    public List<EditorHasSlip> findAll() {
        return editorHasSlipRepository.findAll();
    }

    public EditorHasSlip getByID(UUID id) { return editorHasSlipRepository.getById(id);}

    public Long count() {
        return editorHasSlipRepository.count();
    }

 */
}
