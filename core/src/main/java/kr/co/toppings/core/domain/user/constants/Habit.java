package kr.co.toppings.core.domain.user.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Habit {

    // Diet
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian"),
    LOWCARB("Low carb"),
    NOSUGAR("No sugar"),
    MUSLIMFRIENDLY("Muslim friendly"),
    HALAL("Halal"),

    // Religion
    BUDDHISM("Buddhism"),
    HINDUISM("Hinduism"),
    ;

    private final String value;
}
