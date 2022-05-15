package com.BettleAPI.entity.compositeId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BansId implements Serializable {
    private long adminId;
    private long socialUserId;
}
