package tech.tognati.magalums.service;

import org.springframework.stereotype.Service;
import tech.tognati.magalums.controller.dto.SchedulerNotificationDTO;
import tech.tognati.magalums.entity.Notification;
import tech.tognati.magalums.entity.Status;
import tech.tognati.magalums.repository.NotificationRepository;

import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(SchedulerNotificationDTO dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);
        if(notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }
}
