package com.project.bootcampsantander.service;

import java.util.List;
import java.util.Optional;

import com.project.bootcampsantander.exceptions.BusinessException;
import com.project.bootcampsantander.exceptions.NotFoundException;
import com.project.bootcampsantander.mapper.StockMapper;
import com.project.bootcampsantander.model.Stock;
import com.project.bootcampsantander.model.dto.StockDTO;
import com.project.bootcampsantander.repository.StockRepository;
import com.project.bootcampsantander.util.MessageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;
    // Inserção
    @Transactional
    public StockDTO save(StockDTO dto) {
        // Verificação
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }
    // Alteração
    @Transactional
    public StockDTO update(StockDTO dto) {
        // Verificação
        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    // Visualização
    @Transactional(readOnly = true) // Apenas leitura de dados
    public List<StockDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }

    // Visualização por ID
    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

}
