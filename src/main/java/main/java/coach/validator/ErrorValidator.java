package main.java.coach.validator;

public interface ErrorValidator {
    String EMPTY_NAME_MESSAGE = "Name cannot be empty";
    String EMPTY_SURNAME_MESSAGE = "Surname cannot be empty";
    String EMPTY_EMAIL_MESSAGE = "Email cannot be empty";
    String EMPTY_PASSWORD_MESSAGE = "Password cannot be empty";
    String EMPTY_GROWTH_MESSAGE = "Growth cannot be empty";
    String EMPTY_WEIGHT_MESSAGE = "Weight cannot be empty";
    String EMPTY_AGE_MESSAGE = "Age cannot be empty";
    String EMPTY_ID_TRAINER_MESSAGE = "Id_trainer cannot be empty";

    String NAME_IS_TOO_SHORT = "name is too short";
    String NAME_IS_TOO_LONG = "name is too long";
    String PASSWORD_IS_TOO_LONG = "password is too long";
    String PASSWORD_IS_TOO_SHORT = "password is too short";
    String SURNAME_IS_TOO_LONG = "surname is too long";
    String SURNAME_IS_TOO_SHORT = "surname is too short";
    String GROWTH_IS_TOO_SHORT = "growth is too short";
    String GROWTH_IS_TOO_LONG = "growth is too long";
    String WEIGHT_IS_TOO_SHORT = "weight is too short";
    String WEIGHT_IS_TOO_LONG = "weight is too long";
    String AGE_IS_TOO_SHORT = "age is too short";
    String AGE_IS_TOO_LONG = "age is too long";

    String INCORRECT_EMAIL_ADDRESS = "incorrect email address";

    String SURNAME_CONTAINS_ILLEGAL_CHARACTER = "surname contains illegal character";
    String PASSWORD_CONTAINS_ILLEGAL_CHARACTER = " password contains illegal character";
    String NAME_CONTAINS_ILLEGAL_CHARACTER = "name contains illegal character";
    String GROWTH_CONTAINS_ILLEGAL_CHARACTER = "growth contains illegal character";

    String NOT_AVAILABLE_EMAIL_MESSAGE = "email already exists";

    String NOT_FOUND_EXERCISE = "Not found exercise";
    String NOT_FOUND_PUPIL = "Not found pupil";
}
