package com.management.order.dto;

import com.management.order.controller.request.ProductDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderMessageDTO implements Serializable {

    private String id;
    private String email;
    private String name;
    private List<ProductDTO> products;

}
