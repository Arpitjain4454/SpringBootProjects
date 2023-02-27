package com.arpit.studentPortal.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    @NotNull(message = "Landmark is mandatory")
    private String landmark;

    @NotNull(message = "Zipcode is mandatory")
    @Pattern(regexp = "\\d{6}", message = "Zipcode should be 6 digits")
    private String zipcode;

    @NotNull(message = "District is mandatory")
    private String district;

    @NotNull(message = "State is mandatory")
    private String state;

    @NotNull(message = "Country is mandatory")
    private String country;
}
