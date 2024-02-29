package model;

import java.util.Arrays;

public enum Category {
    Male(0),
    Female(1),
    Unisex(2);

    private  final int value;

    Category(int value){this.value = value;}
    public  static Category fromName(int value) {
        return Arrays.stream(Category.values()).filter(e -> e.value==value).findFirst().orElseThrow();
    }
}
