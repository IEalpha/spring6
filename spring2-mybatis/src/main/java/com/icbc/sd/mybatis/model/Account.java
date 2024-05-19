package com.icbc.sd.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Account {
    private Integer id;
    private String name;
    private String balance;
    private String accno;
}
