package com.jp.web.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "postmaster")
public class Json implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NationalLocalGovernmentCode")
    private Integer nationalLocalGovernmentCode;

    @Column(name = "oldPostalCode")
    private String oldPostalCode;

    @Column(name = "postCode")
    private String postCode;

    @Column(name = "prefecturesKana")
    private String prefecturesKana;

    @Column(name = "municipalitiesKana")
    private String municipalitiesKana;

    @Column(name = "townAreaKana")
    private String townAreaKana;

    @Column(name = "prefecturesKanzi")
    private String prefecturesKanzi;

    @Column(name = "municipalitiesKanzi")
    private String municipalitiesKanzi;

    @Column(name = "townAreaKanzi")
    private String townAreaKanzi;

    // Custom constructor if needed
    public Json(Integer nationalLocalGovernmentCode, String oldPostalCode) {
        this.nationalLocalGovernmentCode = nationalLocalGovernmentCode;
        this.oldPostalCode = oldPostalCode;
        // Initialize other fields as necessary
    }
}
