package tech.tognati.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tognati.magalums.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
