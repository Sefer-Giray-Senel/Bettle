package com.BettleAPI.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
}