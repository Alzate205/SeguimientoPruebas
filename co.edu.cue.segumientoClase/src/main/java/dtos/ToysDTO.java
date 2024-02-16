package dtos;

import model.Category;

public record ToysDTO(String name, Category Type, double price, double amount) {
}
