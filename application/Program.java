package ExerciseInterface.application;

import ExerciseInterface.models.composition.NotifcationLog;
import ExerciseInterface.models.entities.EmailNotification;
import ExerciseInterface.models.entities.PushNotification;
import ExerciseInterface.models.entities.SMSNotification;
import ExerciseInterface.models.interfaces.Notifiable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        boolean running = true;
        try(Scanner sc = new Scanner(System.in)) {
            final List<NotifcationLog> list = new ArrayList<>();


            while (running) {
                System.out.println("""
                        === Notification System ===
                        1. Send notification
                        2. List all notifications
                        3. Count by type
                        4. Exit
                        """);
                System.out.print("Choose an option: ");
                final int n = sc.nextInt();
                sc.nextLine();

                switch (n) {
                    case 1 -> {
                        try {
                            System.out.print("Type (e/s/p): ");
                            char type = sc.nextLine().charAt(0);

                            Notifiable notification = createNotification(sc, type);

                            list.add(new NotifcationLog(notification, LocalDateTime.now()));
                            System.out.println("Notification sent!");
                            System.out.println();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            System.out.println("All notifications:");
                            listNotification(list);
                            System.out.println();
                        }
                        catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            System.out.println("Count by type:");
                            countByType(list);
                        }catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                            System.out.println();
                        }
                    }
                    case 4 -> {
                        System.out.println("Thank you for using us systems.");
                        running = false;
                    }
                }
            }
        }
    }

    private static Notifiable createNotification(Scanner sc, char type) {
        if (type == 'e') {
            System.out.print("Recipient: ");
            final String recipient = sc.nextLine();
            System.out.print("Subject: ");
            final String subject = sc.nextLine();
            System.out.print("Body: ");
            final String body = sc.nextLine();
            return new EmailNotification(recipient, subject, body);
        } else if (type == 's') {
            System.out.print("Phone number: ");
            final String phoneNumber = sc.nextLine();
            System.out.print("Message: ");
            final String message = sc.nextLine();
            return new SMSNotification(phoneNumber, message);
        } else if (type == 'p') {
            System.out.print("Device id: ");
            final String deviceId = sc.nextLine();
            System.out.print("Title: ");
            final String title = sc.nextLine();
            System.out.print("Message: ");
            final String message = sc.nextLine();
            return new PushNotification(deviceId, title, message);
        }
        else {
            throw new IllegalArgumentException("Invalid type!");
        }
    }
    private static void listNotification(List<NotifcationLog> list) {
        for (NotifcationLog e: list) {
            System.out.println(e.getFormattedLog());
        }
    }
    private static void countByType(List<NotifcationLog> list) {
        long emailCount = list.stream().filter(log -> log.getNotification() instanceof EmailNotification).count();
        long pushCount = list.stream().filter(log -> log.getNotification() instanceof  PushNotification).count();
        long smsCount = list.stream().filter(log -> log.getNotification() instanceof SMSNotification).count();

        System.out.println("Email: " + emailCount);
        System.out.println("Push: " + pushCount);
        System.out.println("SMS: " + smsCount);
    }
}
