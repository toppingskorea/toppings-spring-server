package kr.co.toppings.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kr.co.toppings.core.domain.user.constants.Habit;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "t_user_habit")
public class UserHabit {

	@Id
	@Column(name = "user_habit_id")
	private String id;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_habit_name", columnDefinition = "varchar(100)")
	private Habit name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	//==편의 Method==//
	public Habit getUserHabit(String habitName) {
		return Arrays.stream(Habit.values())
					 .filter(habit -> habit.name()
										   .equalsIgnoreCase(habitName))
					 .findFirst()
					 .orElse(null);
	}
}
