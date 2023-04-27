package kr.co.toppings.core.domain.user.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Habit {
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian"),
    LOWCARB("Low carb"),
    NOSUGAR("No sugar"),
    MUSLIMFRIENDLY("Muslim friendly"),
    HALAL("Halal"),
    BUDDHISM("Buddhism"),
    HINDUISM("Hinduism");

    public String getValue() {
        return value;
    }

    private final String value;
}
