package com.yollweb.springboot.cloud.service2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AgricultureDTO {
    private String id;
    private String username;
    private String name;
    private String description;
    private String agriculture;
}
