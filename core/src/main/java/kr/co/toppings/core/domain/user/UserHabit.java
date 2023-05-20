package kr.co.toppings.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kr.co.toppings.core.domain.user.constants.Habit;
import kr.co.toppings.core.domain.common.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "t_user_habit")
public class UserHabit extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "user_habit_id")
	private Long id;

	@Enumerated(STRING)
	@Column(name = "user_habit_name", columnDefinition = "varchar(100)")
	private Habit habit;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	//==생성 Method==//
	public static UserHabit createUserHabit(User user, Habit habit) {
		return UserHabit.builder()
						.user(user)
						.habit(habit)
						.build();
	}

	//==편의 Method==//
}
