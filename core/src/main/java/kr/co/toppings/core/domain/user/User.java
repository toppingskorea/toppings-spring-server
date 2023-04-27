package kr.co.toppings.core.domain.user;

import kr.co.toppings.core.domain.user.constants.Country;
import kr.co.toppings.core.domain.user.constants.Habit;
import kr.co.toppings.core.domain.user.constants.UserRole;
import kr.co.toppings.core.global.entity.BaseEntity;
import kr.co.toppings.core.global.entity.embedded.Image;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    // 스프링 시큐리티에서 사용자 계정 아이디
    @Column(name = "user_username", columnDefinition = "varchar(100)")
    private String username;

    @Column(name = "user_password", columnDefinition = "varchar(255)")
    private String password;

    // 사용자 이름
    @Column(name = "user_name", columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "user_email", columnDefinition = "varchar(100)", unique = true)
    private String email;

    @Column(name = "user_country", columnDefinition = "varchar(100)")
    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
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
    public static User createUser(String name, String email, Country country) {

        return User.builder()
                   .name(name)
                   .country(country)
                   .email(email)
                   .build();
    }

    //==편의 Method==//

}
