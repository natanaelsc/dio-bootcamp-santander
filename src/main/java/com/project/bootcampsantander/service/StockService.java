package com.project.bootcampsantander.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.project.bootcampsantander.exceptions.BusinessException;
import com.project.bootcampsantander.mapper.StockMapper;
import com.project.bootcampsantander.model.Stock;
import com.project.bootcampsantander.model.dto.StockDTO;
import com.project.bootcampsantander.repository.StockRepository;
import com.project.bootcampsantander.util.MessageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

}
