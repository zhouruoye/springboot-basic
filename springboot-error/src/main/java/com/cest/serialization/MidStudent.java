package com.cest.serialization;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class MidStudent extends Student implements Serializable {

    private String otherName;

    public MidStudent(String name, String otherName) {
        super(name);
        this.otherName = otherName;
    }


}
