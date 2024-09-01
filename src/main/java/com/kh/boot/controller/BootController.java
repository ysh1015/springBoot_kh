package com.kh.boot.controller;

import com.kh.boot.dto.ProductDto;
import com.kh.boot.service.BootService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BootController {

    @Autowired
    BootService bootService;

    @GetMapping("/dummy")
    public String dummy(){
        log.info("dummy");
         return "{}";
    }
    @GetMapping("/dummy2")
    public String dummy2(){
        log.info("dummy2");
        return "dummy2";
    }

    @GetMapping("/member")
        public String getMember(@RequestParam(value = "memberKey", defaultValue = "111") String memberKey,
                                @RequestParam("year") int year){
            log.info("memberKey : {}", memberKey);
            log.info("year : {}", year);
            return "ok";
        }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id){
        log.info("id : {}", id);
        return "ok";
    }

    @PostMapping("/company")
    public String registerCompany(@RequestBody String company){
        log.info("company : {}", company);
        return "ok";
    }

    @PostMapping("/product")
    public String registerProduct(@RequestBody ProductDto ProductDto){
        log.info("ProductDto : {}", ProductDto);

        boolean p = bootService.registerProduct(ProductDto);


        return "ok";
    }

    @GetMapping("/product/{id}")
    public ProductDto getItem(@PathVariable("id") String id){
        log.info("id : {}", id);

        ProductDto productDto = bootService.getProductById(id);
        return productDto;
    }
}
