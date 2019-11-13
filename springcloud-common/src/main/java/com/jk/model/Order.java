package com.jk.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {
    private Integer orderId;
    private String  orderName;
    private String  orderCreateDate;
}
