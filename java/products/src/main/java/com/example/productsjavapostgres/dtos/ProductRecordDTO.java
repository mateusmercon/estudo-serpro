package com.example.productsjavapostgres.dtos;

import java.math.BigDecimal;

public record ProductRecordDTO(Long id, BigDecimal price, String name, int quantity) {
    
}
