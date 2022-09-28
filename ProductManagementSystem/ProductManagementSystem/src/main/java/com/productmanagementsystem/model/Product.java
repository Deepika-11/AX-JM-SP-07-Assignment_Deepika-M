package com.productmanagementsystem.model;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Product {

    private int productId;

    private String productName;

    private LocalDate manufacturingDate;

    private String expiringDetails;

}
