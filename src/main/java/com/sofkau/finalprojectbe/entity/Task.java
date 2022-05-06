package com.sofkau.finalprojectbe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.validation.constraints.NotBlank;

@Entity(name = "Task")
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String message;

    private Boolean done;

    @ManyToOne(
            targetEntity = Category.class,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;
}
