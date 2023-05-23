package kr.co.toppings.core.global.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import kr.co.toppings.core.domain.common.entity.BaseEntity;

@MappedSuperclass
public abstract class BaseAggregateRoot extends BaseEntity {

	@Transient
	private final List<Object> domainEvents = new ArrayList<>();

	protected void registerEvent(@NotNull Object event) {
		domainEvents.add(Objects.requireNonNull(event));
	}

	@AfterDomainEventPublication
	protected void clearDomainEvents() {
		this.domainEvents.clear();
	}

	@DomainEvents
	protected Collection<Object> domainEvents() {
		return Collections.unmodifiableList(domainEvents);
	}
}
