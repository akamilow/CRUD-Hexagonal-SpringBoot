
// Value Object que representa y valida el correo electrónico de un usuario.
package udec.actividad2.crudhexagonal.domain.valueobject;

import java.util.Objects;
import java.util.regex.Pattern;

// Clase inmutable para el manejo seguro de emails.
public final class Email {
    // Patrón de expresión regular para validar el formato del email.
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    // Valor del email.
    private final String value;

    // Constructor que valida el formato y valor del email.
    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email no puede ser vacío");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Formato de email inválido");
        }
        this.value = value.toLowerCase();
    }

    // Retorna el valor del email.
    public String getValue() {
        return value;
    }

    // Representación en texto del email.
    @Override
    public String toString() {
        return value;
    }

    // Comparación de igualdad basada en el valor del email.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    // Hash basado en el valor del email.
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
