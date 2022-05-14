package com.BettleAPI.entity;

import com.BettleAPI.entity.compositeId.GameCommentId;
import com.BettleAPI.entity.compositeId.SubscribeId;
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
public class Subscribe {

    @EmbeddedId
    private SubscribeId id;
}