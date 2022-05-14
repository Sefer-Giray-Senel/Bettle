package com.BettleAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bet extends BaseEntity{

    private String title;
    private double odd;
    private int mbn;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Match match;
}

