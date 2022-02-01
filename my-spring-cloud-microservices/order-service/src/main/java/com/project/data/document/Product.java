package com.project.data.document;

import com.project.service.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product extends BaseDocument<ProductDto>  {

    @Field("productName")
    private String productName;

    @Field("price")
    private Integer price;

    @Field("description")
    private String description;
}
