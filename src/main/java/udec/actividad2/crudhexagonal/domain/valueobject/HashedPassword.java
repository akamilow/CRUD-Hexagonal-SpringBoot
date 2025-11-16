
// Value Object que representa la contraseña hasheada de un usuario.
package udec.actividad2.crudhexagonal.domain.valueobject;

import java.util.Objects;

// Clase inmutable para el manejo seguro de contraseñas hasheadas.
public final class HashedPassword {
    // Valor de la contraseña hasheada.
    private final String value;

    // Constructor que valida que el hash no sea nulo ni vacío.
    public HashedPassword(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password hash inválido");
        }
        this.value = value;
    }

    // Retorna el valor de la contraseña hasheada.
    public String getValue() {
        return value;
    }

    // Representación en texto de la contraseña hasheada.
    @Override
    public String toString() {
        return value;
    }

    // Comparación de igualdad basada en el valor del hash.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashedPassword)) return false;
        HashedPassword that = (HashedPassword) o;
        return Objects.equals(value, that.value);
    }

    // Hash basado en el valor de la contraseña hasheada.
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
