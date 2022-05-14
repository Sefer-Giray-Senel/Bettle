package com.BettleAPI.entity;

import com.BettleAPI.entity.compositeId.EditId;
import com.BettleAPI.entity.compositeId.FriendId;
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
public class Edit {
    @EmbeddedId
    private EditId id;
}

