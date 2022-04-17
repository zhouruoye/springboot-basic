package com.cest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boy implements Serializable {

    private static final long serialVersionUID = 8894587868775991234L;
    private String name;

    private int age;
}
