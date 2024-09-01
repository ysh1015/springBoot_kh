package com.kh.boot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface BootMapper {
    HashMap<String, Object> findById(HashMap<String, Object> paramMap);

    void registerProduct(HashMap<String, Object> paramMap);
}
