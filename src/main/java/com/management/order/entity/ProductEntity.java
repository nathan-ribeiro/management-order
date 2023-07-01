package com.management.order.entity;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    private Long id;
    private String description;
    private Integer quantity;

}
