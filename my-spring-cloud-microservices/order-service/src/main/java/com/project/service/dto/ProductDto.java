package com.project.service.dto;

import com.project.data.document.Order;
import com.project.data.document.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto extends BaseDto<Product> {

    private String productName;
    private Integer price;
    private String description;
}
