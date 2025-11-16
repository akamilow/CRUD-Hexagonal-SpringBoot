package udec.actividad2.crudhexagonal.domain.valueobject;

import java.util.Objects;

public final class HashedPassword {
    private final String value;

    public HashedPassword(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password hash inválido");
        }
        this.value = value;
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
        if (!(o instanceof HashedPassword)) return false;
        HashedPassword that = (HashedPassword) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
