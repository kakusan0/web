package com.jp.web.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "viewpostmaster")
public class Json implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postcodeleft")
    private String postcodeleft;

    @Column(name = "postcoderight")
    private String postcoderight;

    @Column(name = "address")
    private String address;
}
