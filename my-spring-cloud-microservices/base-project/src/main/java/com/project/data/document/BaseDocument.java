package com.project.data.document;

import com.project.service.dto.BaseDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

@Data
@NoArgsConstructor
public abstract class BaseDocument<D extends BaseDto> implements Serializable {

    @Id
    protected Integer id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Field("create_date")
    protected Date createDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Field("update_date")
    protected Date updateDate;

    /**
     * Generic toDto converter for entity
     * @return
     */
    public D toDto() {
        try {
            final Type actualTypeArgument = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Class<?> aClass = Class.forName(actualTypeArgument.getTypeName());
            return (D) mapper().map(this, aClass);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static DozerBeanMapper mapper;

    private static DozerBeanMapper mapper() {
        if (mapper == null) {
            mapper = new DozerBeanMapper();
        }
        return mapper;
    }
}
