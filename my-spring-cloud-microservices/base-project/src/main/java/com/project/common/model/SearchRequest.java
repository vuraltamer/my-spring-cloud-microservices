package com.project.common.model;

import com.project.service.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest<T extends BaseDto> extends BaseRequest {
    private T searchDto;
}
