package com.project.controller;

import com.project.common.constant.Apis;
import com.project.common.model.BaseRequest;
import com.project.common.model.SearchRequest;
import com.project.common.model.SearchResponse;
import com.project.data.document.Order;
import com.project.service.OrderService;
import com.project.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(Apis.ORDER)
@RequiredArgsConstructor
public class OrderController implements BaseController<OrderDto> {

    private final static Logger LOGGER = Logger.getLogger(OrderController.class.getName());

    private final OrderService orderService;

    @Override
    @GetMapping(value = "{id}")
    public OrderDto get(@PathVariable("id") Integer id) {
         LOGGER.info("OrderController get method is start.");
        final OrderDto orderDto = orderService.get(id);
        LOGGER.info("OrderController get method is end.");
        return orderDto;
    }

    @Override
    @PostMapping(value = "create")
    public OrderDto create(@RequestBody OrderDto orderDto) {
        LOGGER.info("OrderController create method is start.");
        final Order order = orderService.save(orderDto.toDocument());
        LOGGER.info("OrderController create method is end.");
        return order.toDto();
    }

    @Override
    @PostMapping("update")
    public OrderDto update(@RequestBody OrderDto orderDto) {
        LOGGER.info("OrderController update method is start.");
        final Order order = orderService.update(orderDto.toDocument());
        LOGGER.info("OrderController update method is end");
        return order.toDto();
    }

    @Override
    @PostMapping(value = "search")
    public SearchResponse<OrderDto> search(@RequestBody SearchRequest<OrderDto> request) {
        LOGGER.info("OrderController search method is start.");
        final SearchResponse<OrderDto> search = orderService.search(request);
        LOGGER.info("OrderController search method is end.");
        return search;
    }

    @Override
    @PostMapping(value = "all")
    public SearchResponse<OrderDto> all(@RequestBody BaseRequest request) {
        LOGGER.info("OrderController all method is start.");
        final SearchResponse<OrderDto> searchResponse = orderService.all(request);
        LOGGER.info("OrderController all method is end.");
        return searchResponse;
    }

    @Override
    @GetMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        LOGGER.info("OrderController delete method is start.");
        orderService.delete(id);
        LOGGER.info("OrderController delete method is end.");
    }
}
