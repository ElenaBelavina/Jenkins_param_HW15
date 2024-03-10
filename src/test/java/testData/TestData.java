package testdata;

import com.github.javafaker.Faker;
import config.RegistrationConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    Faker faker = new Faker();
    RegistrationConfig registrationConfig = ConfigFactory.create(RegistrationConfig.class);
    public String firstName = registrationConfig.firstName(),
            lastName = registrationConfig.lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male","Female","Other"),
            userNumber = String.valueOf(faker.phoneNumber().subscriberNumber(10)),
            dateDay = String.valueOf(faker.number().numberBetween(1, 28)),
            dateMonth = faker.options().option("January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"),
            dateYear = String.valueOf(faker.number().numberBetween(1900, 2024)),
            subjects = faker.options().option("Accounting","Arts","Biology","Chemistry",
                    "Computer Science","Commerce","Civics","English","Economics","Hindi","History",
                    "Maths","Physics","Social Studies"),
            hobbies = faker.options().option("Sports","Reading","Music"),
            picture = getPicture(),
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("Haryana","NCR", "Rajasthan","Uttar Pradesh"),
            city = chooseCity(state);


    String chooseCity(String state) {
        switch (state) {
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
        }
        return null;
    }
    String getPicture(){
        return faker.options().option("giraffe.jpeg", "kitten.jpeg", "puppy.jpg");
    }
}