package com.icbc.sd.factoryBeanUsage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

}
