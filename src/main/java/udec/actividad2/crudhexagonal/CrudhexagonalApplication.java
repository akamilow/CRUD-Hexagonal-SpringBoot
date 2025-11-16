
// Archivo principal de la aplicación Spring Boot.
// Esta clase inicia el contexto de la aplicación y configura los componentes.
package udec.actividad2.crudhexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación que indica que esta clase es la principal de una aplicación Spring Boot.
@SpringBootApplication
public class CrudhexagonalApplication {

    // Método principal que inicia la aplicación.
    // args: argumentos de línea de comandos.
	public static void main(String[] args) {
		SpringApplication.run(CrudhexagonalApplication.class, args);
	}

}
