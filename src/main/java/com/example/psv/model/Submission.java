package com.example.psv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "submission")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private Long id;

    @Column(name = "competition_name")
    private String competitionName;

    @Column(name = "caption")
    private String caption;

    @Lob
    @Column(name = "media")
    private byte[] media;

    @ManyToOne
    @JsonBackReference(value = "owner")
    @JoinColumn(name = "owner_id")
    private User owner;


}
