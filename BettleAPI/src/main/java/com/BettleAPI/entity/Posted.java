package com.BettleAPI.entity;

import com.BettleAPI.entity.compositeId.PostLikeId;
import com.BettleAPI.entity.compositeId.PostedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@EqualsAndHashCode()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posted {

    @EmbeddedId
    private PostedId id;
}
