package com.BettleAPI.service;

import com.BettleAPI.entity.GameComment;

import com.BettleAPI.repository.GameCommentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired,@NonNull}))
public class GameCommentService {
    private final GameCommentRepository gameCommentRepository;

    public GameComment save(GameComment gameComment) {
        return gameCommentRepository.save(gameComment);
    }

    public void delete(UUID id) {
        gameCommentRepository.deleteById(id);
    }

    public List<GameComment> findAll() {
        return gameCommentRepository.findAll();
    }

    public GameComment getByID(UUID id) { return gameCommentRepository.getById(id);}

    public Long count() {
        return gameCommentRepository.count();
    }
}
