package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Radar {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Double calcularDistancia(int x1, int y1, int z1) {
        int x2 = 0;
        int y2 = 0;
        int z2 = 0;

        Double distancia = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
        return distancia;
    }
}
