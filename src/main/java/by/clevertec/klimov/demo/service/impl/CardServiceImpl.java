package by.clevertec.klimov.demo.service.impl;

import by.clevertec.klimov.demo.dto.CardDto;
import by.clevertec.klimov.demo.entity.Card;
import by.clevertec.klimov.demo.repository.CardRepository;
import by.clevertec.klimov.demo.service.CardService;
import by.clevertec.klimov.demo.utils.converter.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@Slf4j
public class CardServiceImpl implements CardService {
  private final CardRepository cardRepository;
  private final Converter converter;

  public CardServiceImpl(CardRepository cardRepository, Converter converter) {
    this.cardRepository = cardRepository;
    this.converter = converter;
  }

  @Override
  public int create(List<CardDto> cardDtos) {
    log.debug("Cards save");
    int savedSize = cardRepository.saveAll(converter.mapToEntity(cardDtos, Card.class)).size();
    log.debug(String.format("Cards saved successful : %s", savedSize));
    return savedSize;
  }
}
