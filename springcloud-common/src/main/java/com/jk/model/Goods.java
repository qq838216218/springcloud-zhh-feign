package com.jk.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Goods {
    private Integer goodsId;
    private String  goodsName;
    private String  goodsPrice;
    private Integer goodsNumber;
}
