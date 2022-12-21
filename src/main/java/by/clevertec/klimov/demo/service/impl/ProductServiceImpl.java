package by.clevertec.klimov.demo.service.impl;

import by.clevertec.klimov.demo.dto.ProductDto;
import by.clevertec.klimov.demo.entity.Product;
import by.clevertec.klimov.demo.repository.ProductRepository;
import by.clevertec.klimov.demo.service.ProductService;
import by.clevertec.klimov.demo.utils.converter.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

  @Override
  public List<ProductDto> getProductsByIds(List<Long> ids) {
    log.debug("Get products by ids = {}", ids.toString());
    List<Product> products = productRepository.findAllById(ids);
    List<Product> fullProducts = new ArrayList<>();
    for (Long id : ids) {
      Optional<Product> product = products.stream().filter(p -> p.getId() == id).findFirst();
      product.ifPresent(fullProducts::add);
    }
    List<ProductDto> productDtos = converter.mapToDto(fullProducts, ProductDto.class);
    log.debug(String.format("Get products successful : %s", productDtos.toString()));
    return productDtos;
  }
}
