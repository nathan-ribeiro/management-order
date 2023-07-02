package com.management.order.controller.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductDTO implements Serializable {

    private Long id;
    private String description;
    private Integer quantity;

}
