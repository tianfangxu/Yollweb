package com.yollweb.springboot.cloud.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessDTO implements Serializable {
    private String uid;
    private String username;
    private String description;
    private String business;
}
