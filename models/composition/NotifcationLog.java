package ExerciseInterface.models.composition;

import ExerciseInterface.models.interfaces.Notifiable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotifcationLog {
    final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    private final Notifiable notification;
    private final LocalDateTime timestamp;

    public NotifcationLog(final Notifiable notification, final LocalDateTime timestamp) {
        if (notification == null) {
            throw new IllegalArgumentException("The notification cannot be null!");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("The timestamp cannot be null!");
        }
        this.notification = notification;
        this.timestamp = timestamp;
    }

    public Notifiable getNotification() {
        return notification;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getFormattedLog() {
        return "[" + dtf.format(timestamp) +"] " + notification.send();
    }


}
