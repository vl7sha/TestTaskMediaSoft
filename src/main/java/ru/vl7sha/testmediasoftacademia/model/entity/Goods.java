package ru.vl7sha.testmediasoftacademia.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "goods")
public class Goods extends AbstractEntity{

    private String name;

    @Column(name = "vendor_code", unique = true)
    private String vendorCode;

    private String description;

    private String category;

    private Long price;

    private Long count;

    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @Column(name = "create_data")
    private LocalDate createData;
}
