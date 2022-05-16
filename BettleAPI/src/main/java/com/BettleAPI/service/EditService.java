package com.BettleAPI.service;

import com.BettleAPI.entity.Edit;

import com.BettleAPI.entity.compositeId.EditId;
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

    public void delete(EditId id) {
        editRepository.deleteById(id);
    }

    public List<Edit> findAll() {
        return editRepository.findAll();
    }

    public Edit findOneById(EditId id) { return editRepository.findOneById(id.getBetId(), id.getUserId());}

}