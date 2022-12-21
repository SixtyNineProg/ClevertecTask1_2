package by.clevertec.klimov.demo.repository;

import by.clevertec.klimov.demo.entity.Card;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CardRepository extends JpaRepository<Card, Long> {}
