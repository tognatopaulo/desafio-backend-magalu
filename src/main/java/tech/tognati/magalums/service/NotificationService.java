package tech.tognati.magalums.service;

import org.springframework.stereotype.Service;
import tech.tognati.magalums.controller.dto.SchedulerNotificationDTO;
import tech.tognati.magalums.repository.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(SchedulerNotificationDTO dto) {
        notificationRepository.save(dto.toNotification());
    }
}
