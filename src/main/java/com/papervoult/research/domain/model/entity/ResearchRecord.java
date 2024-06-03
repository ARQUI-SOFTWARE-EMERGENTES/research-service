package com.papervoult.research.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "researches")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResearchRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1000, nullable = false)
    private String title;

    @Column(length = 2000)
    private String abstractText;

    @Lob
    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private ReviewStatus reviewStatus;

    @Column(nullable = false)
    private boolean authenticated;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date submissionDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date lastModifiedDate;


}
