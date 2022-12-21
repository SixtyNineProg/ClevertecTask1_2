package by.clevertec.klimov.demo.utils;

import by.clevertec.klimov.demo.constants.Constants;
import by.clevertec.klimov.demo.dto.CardDto;
import by.clevertec.klimov.demo.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomCsvToBeanTest {

  @Test
  void beanBuilderCard() throws Exception {
    CustomCsvToBean<CardDto> csvToBean = new CustomCsvToBean<>();
    List<CardDto> cardDtos = csvToBean.beanBuilder(Constants.PATH_CARDS_CSV, CardDto.class, ',');
    Assertions.assertFalse(cardDtos.isEmpty());
  }

  @Test
  void beanBuilderProduct() throws Exception {
    CustomCsvToBean<ProductDto> csvToBean = new CustomCsvToBean<>();
    List<ProductDto> productDtos =
        csvToBean.beanBuilder(Constants.PATH_PRODUCT_CSV, ProductDto.class, ',');
    Assertions.assertFalse(productDtos.isEmpty());
  }
}
