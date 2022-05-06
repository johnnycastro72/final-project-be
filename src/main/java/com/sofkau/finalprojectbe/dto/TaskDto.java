package com.sofkau.finalprojectbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Serializable {
    private Long id;
    private String message;
    private Boolean done;
}
