package com.project.bootcampsantander.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
// DTO: Data Transfer Object
public class StockDTO {
    
    private Long id; // Identificador da ação

    @NotNull
    private String name; // Nome da ação

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 6, fraction = 2) 
    private Double price;   // Preço da ação

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date; // Data

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Double variation; // Variação

    // Setters e Getters, métodos acessores
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }

}
