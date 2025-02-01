package tech.tognati.magalums.controller.dto;

import tech.tognati.magalums.entity.Channel;
import tech.tognati.magalums.entity.Notification;
import tech.tognati.magalums.entity.Status;

import java.time.LocalDateTime;

public record SchedulerNotificationDTO(LocalDateTime dateTime,
                                       String destination,
                                       String message,
                                       Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus());
    }
}
