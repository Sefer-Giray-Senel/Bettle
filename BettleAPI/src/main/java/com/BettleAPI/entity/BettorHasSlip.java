package com.BettleAPI.entity;

import com.BettleAPI.entity.compositeId.FriendId;
import com.BettleAPI.entity.compositeId.HasSlipId;
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
public class BettorHasSlip {

    @EmbeddedId
    private HasSlipId id;

    private double placedCash;
}

