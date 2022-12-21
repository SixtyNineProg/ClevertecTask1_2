package by.clevertec.klimov.demo;

import by.clevertec.klimov.demo.constants.Constants;
import by.clevertec.klimov.demo.dto.CardDto;
import by.clevertec.klimov.demo.dto.ProductDto;
import by.clevertec.klimov.demo.service.CardService;
import by.clevertec.klimov.demo.service.ProductService;
import by.clevertec.klimov.demo.utils.CustomCsvToBean;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper
        .getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setFieldMatchingEnabled(true);
    return modelMapper;
  }

  @Bean
  public CommandLineRunner mappingDemo(ProductService productService, CardService cardService) {
    return args -> {
      CustomCsvToBean<CardDto> cardsCsvToBean = new CustomCsvToBean<>();
      List<CardDto> cardDtos =
          cardsCsvToBean.beanBuilder(Constants.PATH_CARDS_CSV, CardDto.class, ',');

      CustomCsvToBean<ProductDto> productsCsvToBean = new CustomCsvToBean<>();
      List<ProductDto> productDtos =
          productsCsvToBean.beanBuilder(Constants.PATH_PRODUCT_CSV, ProductDto.class, ',');

      log.debug(String.format("Saved cards = %s", cardService.create(cardDtos)));
      log.debug(String.format("Saved products = %s", productService.create(productDtos)));
    };
  }
}
