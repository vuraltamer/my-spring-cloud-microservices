package com.project.data.document;

import com.project.service.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order")
public class Order extends BaseDocument<OrderDto> {

    @Indexed(unique = true)
    @Field("personId")
    private Integer personId;

    @Indexed(unique = true)
    @Field("productId")
    private Integer productId;

    @Field("status")
    private String status;

}
