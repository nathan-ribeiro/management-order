package com.management.order.service;

import com.management.order.controller.request.OrderDTO;
import com.management.order.controller.request.ProductDTO;
import com.management.order.dto.OrderMessageDTO;
import com.management.order.entity.OrderEntity;
import com.management.order.entity.ProductEntity;
import com.management.order.repository.OrderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public OrderEntity createOrder(OrderDTO orderDTO){

        OrderEntity orderEntity = convertDTOToEntity(orderDTO);

        var entity = orderRepository.save(orderEntity);

        List<ProductDTO> products = new ArrayList<>();

        entity.getProducts().forEach(productEntity -> {
            products.add(ProductDTO.builder()
                    .description(productEntity.getDescription())
                    .id(productEntity.getId())
                    .quantity(productEntity.getQuantity())
                    .build());
        });

        System.out.println(OrderMessageDTO.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .products(products)
                .build());

        rabbitTemplate.convertAndSend("order.process", OrderMessageDTO.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .products(products)
                .build());

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
