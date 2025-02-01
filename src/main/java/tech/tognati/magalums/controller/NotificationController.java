package tech.tognati.magalums.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.tognati.magalums.controller.dto.SchedulerNotificationDTO;
import tech.tognati.magalums.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody SchedulerNotificationDTO dto) {
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("{notificationId}")
    public ResponseEntity<?> getNotification(@PathVariable Long notificationId) {
        var notification = notificationService.findById(notificationId);
        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notification.get());
    }

    @DeleteMapping("{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable Long notificationId) {
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}
