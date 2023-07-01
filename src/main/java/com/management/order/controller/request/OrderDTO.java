package com.management.order.controller.request;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO implements Serializable {

    private String email;
    private String name;
    private List<ProductDTO> productList;

}
