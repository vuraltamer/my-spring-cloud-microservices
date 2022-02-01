package com.project.client.model.base;

import com.project.data.document.BaseDocument;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dozer.DozerBeanMapper;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class BaseApiModel implements Serializable {
	protected Integer id;
	protected Date createDate;
	protected Date updateDate;
}
