package teamvoy.com.mytask;

import teamvoy.com.mytask.modelSunriseSunset.Results;
import teamvoy.com.mytask.processor.GooglePlaceProcessor;
import teamvoy.com.mytask.processor.SunriseSunsetProcessor;

import java.util.Scanner;

public class UserInterface {
    public void run() {
        greeting();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            String command = scanner.next();
            switch (command) {
                case "coordinates": {
                    processCoordinates(scanner);
                    break;
                }
                case "place": {
                    processPlace(scanner);
                    break;
                }
                case "exit": {
                    return;
                }
                default: {
                    System.out.println("Invalid command, please try again");
                }
            }
        }

    }

    private void processPlace(Scanner scanner) {
        System.out.println("Enter place");
        String place = scanner.next();
        Results results = new GooglePlaceProcessor().getSunriseSunsetFromPlace(place);
        if (results == null) {
            System.out.println("Invalid place");
            System.out.println("Enter new command");
        } else {
            System.out.println("sunrise" + results.getSunrise());
            System.out.println("sunset" + results.getSunset());
            System.out.println("Enter new command");
        }
    }

    private void processCoordinates(Scanner scanner) {
        System.out.println("Enter latitude");
        Double lat = scanner.nextDouble();
        System.out.println("Enter longitude");
        Double lng = scanner.nextDouble();
        Results results = new SunriseSunsetProcessor().getSunriseSunsetFromCoordinates(lat, lng);
        if (results == null) {
            System.out.println("Invalid coordinates");
            System.out.println("Enter new command");
        } else {
            System.out.println("sunrise" + results.getSunrise());
            System.out.println("sunset" + results.getSunset());
            System.out.println("Enter new command");
        }
    }

    private void greeting() {
        System.out.println("Hello, user");
        System.out.println("Please enter command for getting information about sunrise and sunset");
        System.out.println("For coordinates enter coordinates");
        System.out.println("For city/country enter place");
        System.out.println("For exit enter exit");
    }
}
