package com.jp.web.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "viewpostmaster")
public class Json implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postcodeleft")
    private String left;

    @Column(name = "postcoderight")
    private String right;

    @Column(name = "address")
    private String address;
}
