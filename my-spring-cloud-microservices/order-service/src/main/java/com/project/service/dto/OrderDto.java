package com.project.service.dto;

import com.project.data.document.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto extends BaseDto<Order> {

    private Integer personId;
    private Integer productId;
    private String status;
}
