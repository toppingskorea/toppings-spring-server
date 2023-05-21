package kr.co.toppings.core.global.entity;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.*;

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
