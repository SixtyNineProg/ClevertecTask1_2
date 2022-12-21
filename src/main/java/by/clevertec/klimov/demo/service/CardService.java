package by.clevertec.klimov.demo.service;

import by.clevertec.klimov.demo.dto.CardDto;

import java.util.List;

public interface CardService {
    int create(List<CardDto> cardDtos);
}
