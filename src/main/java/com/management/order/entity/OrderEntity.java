package com.management.order.entity;

import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "orders")
public class OrderEntity {

    @Id
    private String id;
    private String email;
    private String name;
    private List<ProductEntity> products;

}
