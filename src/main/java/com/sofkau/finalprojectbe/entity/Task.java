package com.sofkau.finalprojectbe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "Task")
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private Boolean done;

    @ManyToOne(
            targetEntity = Category.class,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "category")
    @JsonBackReference
    private Category category;
}
