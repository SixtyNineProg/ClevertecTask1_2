package by.clevertec.klimov.demo.service.impl;

import by.clevertec.klimov.demo.dto.ProductDto;
import by.clevertec.klimov.demo.entity.Card;
import by.clevertec.klimov.demo.entity.Product;
import by.clevertec.klimov.demo.repository.ProductRepository;
import by.clevertec.klimov.demo.service.ProductService;
import by.clevertec.klimov.demo.utils.converter.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final Converter converter;

  public ProductServiceImpl(ProductRepository productRepository, Converter converter) {
    this.productRepository = productRepository;
    this.converter = converter;
  }

  @Override
  public int create(List<ProductDto> productDtos) {
    log.debug("Products save");
    int savedSize =
        productRepository.saveAll(converter.mapToEntity(productDtos, Product.class)).size();
    log.debug(String.format("Products saved successful : %s", savedSize));
    return savedSize;
  }
}
