package com.BettleAPI.entity;

import com.BettleAPI.entity.compositeId.PostLikeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PostLike {

    @EmbeddedId
    private PostLikeId id;
}
