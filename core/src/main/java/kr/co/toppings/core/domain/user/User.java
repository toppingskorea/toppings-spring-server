package kr.co.toppings.core.domain.user;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.*;
import static kr.co.toppings.core.domain.user.UserHabit.*;
import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import kr.co.toppings.core.domain.user.constants.UserRole;
import kr.co.toppings.core.global.entity.BaseEntity;
import kr.co.toppings.core.global.entity.embedded.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Table(name = "t_user")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id")
	private Long id;

	// 스프링 시큐리티에서 사용자 계정 아이디
	@Column(name = "user_username", columnDefinition = "varchar(100)")
	private String username;

	@Column(name = "user_password", columnDefinition = "varchar(255)")
	private String password;

	// 사용자 닉네임
	@Embedded
	private NickName nickName;

	@Embedded
	private Email email;

	@Column(name = "user_country", columnDefinition = "varchar(100)")
	@Enumerated(EnumType.STRING)
	private Country country;

	@OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true)
	private List<UserHabit> habits = new ArrayList<>();

	@Column(name = "user_role", columnDefinition = "varchar(20)")
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Embedded
	@AttributeOverride(name = "url", column = @Column(name = "user_profile_url", columnDefinition = "longtext"))
	@AttributeOverride(name = "path", column = @Column(name = "user_profile_path", columnDefinition = "varchar(200)"))
	private Image profile;

	@Column(name = "delete_yn", columnDefinition = "varchar(1) default 'N'")
	private String deleteYn;

	//==생성 Method==//
	public User(
		NickName nickName,
		Email email,
		Country country,
		List<Habit> habits
	) {
		this.nickName = nickName;
		this.email = email;
		this.country = country;
		applyHabits(habits);
	}

	public static User createUser(
		String nickName,
		String email,
		Country country,
		List<Habit> habits
	) {
		return new User(new NickName(nickName), new Email(email), country, habits);
	}

	//==편의 Method==//
	private void applyHabits(List<Habit> habitList) {
		habitList.forEach(habit -> habits.add(createUserHabit(this, habit)));
	}

	public String getNickNameValue() {
		return nickName.getValue();
	}

	public String getEmailValue() {
		return email.getValue();
	}
}
