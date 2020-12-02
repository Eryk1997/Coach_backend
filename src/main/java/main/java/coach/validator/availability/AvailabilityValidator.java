package main.java.coach.validator.availability;

public interface AvailabilityValidator<T> {
    String validate(T value);
}
