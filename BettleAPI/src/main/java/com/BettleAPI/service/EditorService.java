package com.BettleAPI.service;

import com.BettleAPI.entity.Editor;

import com.BettleAPI.repository.EditorRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class EditorService {
    private final EditorRepository editorRepository;

    public Editor save(Editor editor) {
        return editorRepository.save(editor);
    }

    public void delete(int id) {
        editorRepository.deleteById(id);
    }

    public List<Editor> findAll() {
        return editorRepository.findAll();
    }

    public Editor findOneById(int id) { return editorRepository.findOneById(id);}

    public void updateEditor(int id, int subscriberCount, int successfulBetSlipCount){ editorRepository.updateEditor(id, subscriberCount, successfulBetSlipCount); }

}

