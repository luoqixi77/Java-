package com.Stream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Books {
    private Long id;
    private String name;
    private String category;
    private Integer score;
    private String intro;
}
