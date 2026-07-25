package ExerciseInterface.models.entities;

import ExerciseInterface.models.interfaces.Notifiable;

public class PushNotification implements Notifiable {

    private final String deviceId;
    private final String title;
    private final String message;

    public PushNotification(final String deviceId, final String title, final String message) {
        if (deviceId == null || deviceId.trim().isEmpty()) {
            throw new IllegalArgumentException("The DeviceID cannot be null or empty!");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("The title cannot be null or empty!");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("The message cannot be null or empty!");
        }
        this.deviceId = deviceId;
        this.title = title;
        this.message = message;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public String send() {
        return "[PUSH] Device: " + deviceId + " | " + title + ": " + message;
    }
}
