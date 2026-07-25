package ExerciseInterface.models.entities;

import ExerciseInterface.models.interfaces.Notifiable;

public class SMSNotification implements Notifiable {
    private final String phoneNumber;
    private final String message;

    public SMSNotification(final String phoneNumber, final String message){
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("The phone number cannot be null or empty!");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("The message cannot be null or empty!");
        }
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public String send() {
        return "[SMS] To: " + phoneNumber + " | Message: " + message;
    }
}
