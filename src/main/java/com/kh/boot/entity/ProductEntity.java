package com.kh.boot.entity;

import com.kh.boot.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    private String id;

    private String name;

    public ProductDto toDTO(){
        ProductDto productDto = new ProductDto();
        productDto.setId(this.getId());
        productDto.setName(this.getName());

        return productDto;
    }
}
