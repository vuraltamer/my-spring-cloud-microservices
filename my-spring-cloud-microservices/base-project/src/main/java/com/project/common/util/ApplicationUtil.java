package com.project.common.util;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import static com.project.common.constant.Constants.ID;

public class ApplicationUtil {

    public static Sort sortAscending(String sortParameter) {
        return Sort.by(Sort.Direction.ASC, sortParameter != null ? sortParameter : ID);
    }

    public static Sort sortDescending(String sortParameter) {
        return Sort.by(Sort.Direction.DESC, sortParameter != null ? sortParameter : ID);
    }

    public static ExampleMatcher getMatchingAllContainsStringMatcher() {
        return ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase();
    }
}
