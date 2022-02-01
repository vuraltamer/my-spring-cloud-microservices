package com.project.service.dto;

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
public abstract class BaseDto<E extends BaseDocument> implements Serializable {

	protected Integer id;
	protected Date createDate;
	protected Date updateDate;

	/**
	 * Generic toEntity converter for dto
	 * @return
	 */
	public E toDocument() {
		try {
			final Type actualTypeArgument = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			Class<?> aClass = Class.forName(actualTypeArgument.getTypeName());
			return (E) mapper().map(this, aClass);
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
