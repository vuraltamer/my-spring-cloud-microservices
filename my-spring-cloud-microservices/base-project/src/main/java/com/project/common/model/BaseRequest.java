package com.project.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static com.project.common.constant.Constants.ID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest {
    protected Pagination pagination;
    protected SortType sortType;

    @Data
    @NoArgsConstructor
    public static class Pagination {
        protected int currentPage = 0;
        protected int pageSize = 5;
    }

    @Data
    @NoArgsConstructor
    public static class SortType {
        private Sort.Direction sort = Sort.Direction.ASC;
        private String sortParameter;
    }

    public PageRequest pageRequest() {
        if (this.pagination == null) {
            this.pagination = new Pagination();
        }
        return PageRequest.of(this.pagination.currentPage, this.pagination.pageSize, sort());
    }

    public Sort sort() {
        if (this.sortType == null || this.sortType.sort == null || StringUtils.isEmpty(this.sortType.sortParameter)) {
            return Sort.by(Sort.Direction.ASC, ID);
        }
        return Sort.by(this.sortType.sort, this.sortType.sortParameter);
    }
}
