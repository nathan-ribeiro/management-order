package com.management.order.service;

import com.management.order.controller.request.OrderDTO;
import com.management.order.entity.OrderEntity;
import com.management.order.entity.ProductEntity;
import com.management.order.repository.OrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity createOrder(OrderDTO orderDTO){

        OrderEntity orderEntity = convertDTOToEntity(orderDTO);

        var entity = orderRepository.save(orderEntity);

        System.out.println(entity.getId());
        return entity;
    }

    private OrderEntity convertDTOToEntity(OrderDTO orderDTO){

        List<ProductEntity> productEntityList = new ArrayList<>();

        orderDTO.getProductList().forEach(productDTO -> {
            productEntityList.add(ProductEntity.builder()
                    .description(productDTO.getDescription())
                    .id(productDTO.getId())
                    .quantity(productDTO.getQuantity())
                    .build());
        });

        return OrderEntity.builder()
                .email(orderDTO.getEmail())
                .name(orderDTO.getName())
                .products(productEntityList)
                .build();
    }

}
