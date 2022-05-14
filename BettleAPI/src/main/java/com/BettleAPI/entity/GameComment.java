package com.BettleAPI.entity;

import com.BettleAPI.entity.compositeId.DisplayId;
import com.BettleAPI.entity.compositeId.GameCommentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GameComment {

    @EmbeddedId
    private GameCommentId id;

    private String comment;
}
