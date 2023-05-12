package com.example.bootcampdemo1;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COUNTRY_TABLE_ID_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    @Setter
    private int id;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "presidentName", length = 100, nullable = false)
    private String presidentName;
}
