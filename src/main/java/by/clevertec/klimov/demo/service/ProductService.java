package by.clevertec.klimov.demo.service;

import by.clevertec.klimov.demo.dto.ProductDto;

import java.util.List;

public interface ProductService {
    int create(List<ProductDto> productDtos);
}
