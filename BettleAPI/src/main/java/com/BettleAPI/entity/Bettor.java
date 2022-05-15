package com.BettleAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@EqualsAndHashCode()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bettor {

    @Id
    private long id;

    private double balance;
    private int friendCount;
}
