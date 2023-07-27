package ru.sberbank.jd.module12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.module12.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
