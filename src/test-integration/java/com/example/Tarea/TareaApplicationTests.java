package com.example.Tarea;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TareaApplicationTests {

    @Test
    public void pruebaPaginaPrincipal() {
        Configuration.headless = true; // Ejecuta sin abrir navegador. .
        open("http://localhost:8081/");
        $("body").shouldHave(text("¡Aplicación operando correctamente! - DevOps -")); // Cambia "Bienvenido" por un texto de tu página
    }
}
