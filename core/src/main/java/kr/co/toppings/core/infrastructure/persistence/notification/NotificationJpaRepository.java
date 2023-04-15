package kr.co.toppings.core.infrastructure.persistence.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.toppings.core.domain.notification.Notification;

public interface NotificationJpaRepository extends JpaRepository<Notification, Long> {
}
