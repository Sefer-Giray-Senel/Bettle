package com.BettleAPI.entity;

import com.BettleAPI.entity.compositeId.GameCommentId;
import com.BettleAPI.entity.compositeId.PostLikeId;
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
public class SlipComment {

    @EmbeddedId
    private PostLikeId id; //same with

    private String comment;
}
