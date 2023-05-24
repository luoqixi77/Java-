package com.Stream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author implements Comparable<Author> {
    private Long id;
    private String name;
    private Integer age;
    private String intro;
    private List<Books> books;

    @Override
    public int compareTo(Author o) {
        return this.getAge()-o.getAge();
    }
}
