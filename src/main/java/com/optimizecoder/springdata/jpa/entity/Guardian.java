package com.optimizecoder.springdata.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "names",
                column = @Column(name = "guardianName")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardianEmail")
                ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardianMobile")
        )
})
@Builder
public class Guardian {
    private String names;
    private String email;
    private String mobile;
}
