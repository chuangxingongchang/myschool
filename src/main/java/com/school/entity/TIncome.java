package com.school.entity;

import lombok.Data;

@Data
public class TIncome {
    private Integer id;

    private Integer fkUid;

    private String content;

    private String moneytime;

    private Double moneys;

}