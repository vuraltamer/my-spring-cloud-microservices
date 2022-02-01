package com.project.service;

import com.project.common.model.SearchRequest;
import com.project.common.model.SearchResponse;
import com.project.data.document.Order;
import com.project.data.repository.BaseRepository;
import com.project.data.repository.OrderRepository;
import com.project.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.common.util.ApplicationUtil.getMatchingAllContainsStringMatcher;

@Service
@RequiredArgsConstructor
public class OrderService extends BaseService<Order, OrderDto, Integer> {

    private final OrderRepository repository;

    @Override
    public BaseRepository<Order, Integer> getRepository() {
        return repository;
    }

    @Override
    public SearchResponse<OrderDto> search(SearchRequest searchRequest) {
        final OrderDto searchModel = (OrderDto) searchRequest.getSearchDto();
        final Example<Order> example = Example.of(searchModel.toDocument(), getMatchingAllContainsStringMatcher());
        final Page<Order> personPage = repository.findAll(example, searchRequest.pageRequest());
        final List<OrderDto> orderDtoList = (List<OrderDto>) toDto(personPage.toList());
        final int elementCount = Long.valueOf(personPage.getTotalElements()).intValue();
        return new SearchResponse<>(searchRequest.getPagination().getCurrentPage(), elementCount, orderDtoList);
    }
}
