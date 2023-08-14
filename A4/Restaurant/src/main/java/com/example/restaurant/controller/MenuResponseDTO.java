package com.example.restaurant.controller;

import com.example.restaurant.Meal;
import com.example.restaurant.MealType;


public record MenuResponseDTO(Long id, String name, String description, double price, MealType type){
    public MenuResponseDTO(Meal meal){
        this(meal.getId(), meal.getName(), meal.getDescription(), meal.getPrice(), meal.getType());
    }
}
