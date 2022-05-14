package com.BettleAPI.entity;

import com.BettleAPI.entity.compositeId.BansId;
import com.BettleAPI.entity.compositeId.FriendId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@EqualsAndHashCode()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bans {

    @EmbeddedId
    private BansId id;

    private String banReason;
    private Date date;
}
