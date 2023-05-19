package kr.co.toppings.core.domain.restaurant;

import kr.co.toppings.core.domain.user.User;
import kr.co.toppings.core.global.entity.BaseAggregateRoot;
import kr.co.toppings.core.global.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "t_saved_restaurant")
public class SavedRestaurant extends BaseAggregateRoot {

    @Id
    @GeneratedValue
    @Column(name = "saved_restaurant_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
