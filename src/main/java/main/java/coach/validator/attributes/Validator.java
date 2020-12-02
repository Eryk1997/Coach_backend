package main.java.coach.validator.attributes;

public interface Validator<T> {
    String validate(T value);
}
