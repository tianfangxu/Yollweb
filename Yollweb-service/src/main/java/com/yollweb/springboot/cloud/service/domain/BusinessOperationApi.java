package com.yollweb.springboot.cloud.service.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface BusinessOperationApi {

    @GetMapping("/business")
    ResponseEntity business(@RequestParam(value = "business") String business);
}
