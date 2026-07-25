package ExerciseInterface.models.entities;

import ExerciseInterface.models.interfaces.Notifiable;

public class EmailNotification implements Notifiable {
    private final String recipient;
    private final String subject;
    private final String body;


    public EmailNotification(final String recipient, final String subject, final String body) {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("The recipient cannot be null or empty!");
        }
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("The subject cannot be null our empty!");
        }
        if (body == null || body.trim().isEmpty()) {
            throw new IllegalArgumentException("The body cannot be null or empty!");
        }
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String send() {
        return "[EMAIL] To: " + recipient + " | Subject: " + subject + " | Body: " + body;
    }
}
