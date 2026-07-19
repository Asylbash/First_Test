package ru.zhyldyz.test_data;

import com.github.javafaker.Faker;

public class TestData {

    private final Faker faker = new Faker();

    public static String
            firstname = "John",
            lastname = "Doe",
            userEmail = "test@test.com",
            userNumber = "1234567890",
            gender = "Male",
            dayOfBirth = "12",
            monthOfBirth = "February",
            yearOfBirth = "1990",
            state = "NCR",
            city = "Delhi",
            currentAddress = "via U.Foscolo 9, Tombolo, Italy",
            permanentAddress = "via Tuscolana 1, Rome , Italy",
            subject = "Maths",
            hobby = "Sports",
            selectPic = "pictures/foto (1).png";

    private static final String[] MONTHS = {

            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"

    };

    private static final String[] SUBJECTS = {

            "Maths",
            "Physics",
            "Chemistry",
            "Biology",
            "Computer Science",
            "Economics",
            "History",
            "Civics"

    };

    private static final String[] HOBBIES = {

            "Sports",
            "Reading",
            "Music"

    };

    private static final String[] STATES = {

            "NCR",
            "Uttar Pradesh",
            "Haryana",
            "Rajasthan"

    };

    public RandomPracticeFormData randomPracticeFormData() {

        String state = randomState();

        return new RandomPracticeFormData(

                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().safeEmailAddress(),
                faker.options().option("Male", "Female"),
                faker.phoneNumber().subscriberNumber(10),
                String.valueOf(faker.number().numberBetween(1, 28)),
                faker.options().option(MONTHS),
                String.valueOf(faker.number().numberBetween(1980, 2005)),
                faker.options().option(SUBJECTS),
                faker.options().option(SUBJECTS),
                faker.options().option(HOBBIES),
                faker.options().option(HOBBIES),
                faker.address().streetAddress(),
                state,
                randomCity(state),
                "pictures/foto (1).png"

        );

    }

    private String randomState() {

        return faker.options().option(STATES);

    }

    private String randomCity(String state) {

        return switch (state) {

            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaisalmer");
            default -> throw new IllegalArgumentException("Unknown state: " + state);

        };

    }

    public RandomTextBox randomTextBox() {

        return new RandomTextBox(

                faker.name().fullName(),
                faker.internet().safeEmailAddress(),
                faker.address().streetAddress(),
                faker.address().fullAddress()

        );

    }

}