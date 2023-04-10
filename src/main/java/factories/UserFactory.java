package factories;

import com.github.javafaker.Faker;
import models.User;
import common.TimeStampGeneration;

import static common.Config.*;

public class UserFactory {

    private static final Faker faker;

    static {
        faker = new Faker();
    }

    public static User createDefault() {
        User user = new User();

        user.setEmail(TimeStampGeneration.buildUniqueTextByPrefix(faker.internet().safeEmailAddress()));
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setTelephone(faker.phoneNumber().phoneNumber());
        user.setPassword(DEFAULT_PASSWORD);
        user.setPasswordConfirm(DEFAULT_PASSWORD);
        user.setAgreePrivacyPolicy(true);
        user.setShouldSubscribe(false);
        return user;
    }
}
