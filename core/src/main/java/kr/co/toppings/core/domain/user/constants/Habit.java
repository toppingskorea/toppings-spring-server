package kr.co.toppings.core.domain.user.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@RequiredArgsConstructor
@ToString
public enum Habit {
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian"),
    LOWCARB("Low carb"),
    NOSUGAR("No sugar"),


    MUSLIMFRIENDLY("Muslim friendly"),
    HALAL("Halal"),
    BUDDHISM("Buddhism"),
    HINDUISM("Hinduism");

    private final String value;
}
