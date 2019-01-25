package com.yollweb.springboot.cloud.service2.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface AgricultureOperationApi {

    @GetMapping("/agriculture")
    ResponseEntity agriculture(@RequestParam(value = "agriculture") String agriculture);
}
