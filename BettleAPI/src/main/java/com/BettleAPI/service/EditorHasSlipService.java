package com.BettleAPI.service;

import com.BettleAPI.entity.EditorHasSlip;

import com.BettleAPI.entity.compositeId.HasSlipId;
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

    public void delete(HasSlipId id) {
        editorHasSlipRepository.deleteById(id);
    }

    public List<EditorHasSlip> findAll() {
        return editorHasSlipRepository.findAll();
    }

    public EditorHasSlip findOneById(HasSlipId id) { return editorHasSlipRepository.findOneById(id.getUserId(), id.getBetSlipId());}
/*
    public Long count() {
        return editorHasSlipRepository.count();
    }

 */
}
