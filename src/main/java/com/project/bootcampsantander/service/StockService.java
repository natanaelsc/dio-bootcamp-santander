package com.project.bootcampsantander.service;

import javax.transaction.Transactional;

import com.project.bootcampsantander.mapper.StockMapper;
import com.project.bootcampsantander.model.Stock;
import com.project.bootcampsantander.model.StockDTO;
import com.project.bootcampsantander.repository.StockRepository;

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
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

}
