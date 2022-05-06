package com.sofkau.finalprojectbe.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Category")
@Table(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Task.class,
            mappedBy = "category"
    )
    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>();

    public Category addTask(Task task) {
        this.tasks.add(task);
        return this;
    }

}
