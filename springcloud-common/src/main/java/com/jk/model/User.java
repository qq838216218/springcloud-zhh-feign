package com.jk.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer userId;
    private String  userName;
    private String  address;
}
