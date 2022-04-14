package main;

import implement.Jarvis;
import java.io.IOException;

// El objetivo de JARVIS es que analice toda la información de la armadura y del entorno y tome decisiones inteligentes.
public class Main {
    public static void main(String[] args) throws IOException {
        Jarvis start = new Jarvis();
        start.operation();
    }
}
