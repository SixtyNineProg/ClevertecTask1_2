package by.clevertec.klimov.demo.repository;

import by.clevertec.klimov.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
