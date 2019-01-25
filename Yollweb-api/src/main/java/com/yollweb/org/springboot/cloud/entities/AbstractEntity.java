package com.yollweb.org.springboot.cloud.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data
public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String createBy;

    private Date createDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;
    
    private Long isValid;
    
    private Long rowVersion;
    
    private Long status;
    
    private String description;
}
