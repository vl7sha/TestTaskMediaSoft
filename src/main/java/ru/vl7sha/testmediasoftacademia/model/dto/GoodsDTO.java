package ru.vl7sha.testmediasoftacademia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsDTO {
    private String id;
    @Nonnull
    private String name;
    @Nonnull
    private String vendorCode;
    private String description;
    @Nonnull
    private String category;
    @Nonnull
    private Long price;
    @Nonnull
    private Long count;
}
