package com.BettleAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.UUID;

@EqualsAndHashCode()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SocialUser {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String nationality;
    private String email;
    private String gender;
    private boolean isBanned;
}
