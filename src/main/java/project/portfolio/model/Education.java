package project.portfolio.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "education")
public class Education implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gpa;
}