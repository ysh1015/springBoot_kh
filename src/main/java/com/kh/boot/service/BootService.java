package com.kh.boot.service;

import com.kh.boot.dto.ProductDto;
import com.kh.boot.entity.ProductEntity;
import com.kh.boot.mapper.BootMapper;
import com.kh.boot.mapper.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class BootService {

    @Autowired
    private BootMapper bootMapper;

    @Autowired
    private ProductRepository productRepository;

    public ProductDto getProductById(String id){

//        HashMap<String, Object> memberMap = new HashMap<>();
//        memberMap.put("id", id);
//
//        HashMap<String, Object> res = bootMapper.findById(memberMap);
//        if(res != null){
//            ProductDto productDto = new ProductDto();
//            productDto.setId((String)res.get("ID"));
//            productDto.setName((String)res.get("NAME"));
//            return productDto;
//        }
//
//        return null;

        ProductEntity productEntity = productRepository.findById(id).get();

        if(productEntity != null){
            ProductDto productDto = productEntity.toDTO();
            return productDto;
        }

        return null;
    }

    public boolean registerProduct(ProductDto productDto){

        //----------------------myBatis----------------------
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", productDto.getId());
//        paramMap.put("name", productDto.getName());
//
//        bootMapper.registerProduct(paramMap);
//
//        return true;

        //---------------------jpa------------------------
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDto.getId());
        productEntity.setName(productDto.getName());

        productRepository.save(productEntity);

        return true;
    }
}
