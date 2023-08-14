package com.example.restaurant.controller;

import com.example.restaurant.Meal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MealController {
    private final List<Meal> meals = new ArrayList<>();

    @GetMapping
    public List<MenuResponseDTO> getAll() {
        return meals.stream().map(MenuResponseDTO::new).toList();
    }

    @PostMapping
    public void addMeal(@RequestBody MenuResponseDTO data){
        meals.add(new Meal(data));
    }

    @DeleteMapping
    public void deleteMeal(@RequestBody Long id){
        try {
            meals.remove(Math.toIntExact(id));
        }catch (IndexOutOfBoundsException ignored){}
    }

    @PutMapping("/{id}")
    public void editMeal(@RequestBody MenuResponseDTO data, @PathVariable Long id){
        Meal meal = meals.get(Math.toIntExact(id));

        meal.setName(data.name());
        meal.setDescription(data.description());
        meal.setPrice(data.price());
        meal.setType(data.type());

        meals.set(Math.toIntExact(id), meal);
    }
}
