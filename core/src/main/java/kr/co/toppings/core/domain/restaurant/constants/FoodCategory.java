package kr.co.toppings.core.domain.restaurant.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FoodCategory {

    AMERICAN("American"),
    CHINESE("Chinese"),
    INDONESIAN("Indonesian"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    KOREAN("Korean"),
    MEXICAN("Mexican"),
    THAI("Thai"),
    VIETNAMESE("Vietnamese"),
    CHICKEN("Chicken"),
    FASTFOOD("Fastfood"),
    BBQ("BBQ"),
    CAFES("Cafes"),
    SEAFOOD("Seafood")
    ;

    private final String value;
}
