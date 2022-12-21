package by.clevertec.klimov.demo.controller;

import by.clevertec.klimov.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CheckController {
  private final ProductService productService;

  public CheckController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/")
  public ResponseEntity<?> getProductsBuIds(@RequestParam List<Long> itemId) {
    try {
      return ResponseEntity.ok(productService.getProductsByIds(itemId));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
