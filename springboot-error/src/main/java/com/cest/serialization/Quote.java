package com.cest.serialization;

import lombok.Getter;
import lombok.Setter;

/**
 * 引用对象
 */
@Getter
@Setter
public class Quote {

    private String id;

    private Student student;

    public Quote(String id, Student student) {
        this.id = id;
        this.student = student;
    }
}
