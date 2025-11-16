package udec.actividad2.crudhexagonal.domain.valueobject;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private final String value;

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email no puede ser vacío");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Formato de email inválido");
        }
        this.value = value.toLowerCase();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
