package com.project.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse<T> {
    private int currentPage;
    private int elementCount;
    private List<T> elements;
}
