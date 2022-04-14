package implement;

import entity.Armadura;
import entity.Consola;
import entity.Generador;
import entity.Propulsor;
import entity.Repulsor;
import entity.Sintetizador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import utility.Colores;
import utility.Estados;

public class ArmaduraImplementsService {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public Armadura crearArmadura() throws IOException{
        Armadura armadura = new Armadura();
        System.out.println("Ingresar Datos:");
        
        System.out.print("NOMBRE DE LA ARMADURA: ");
        armadura.setNombre(br.readLine());
        
        System.out.print("Color primario: ");
        String color = br.readLine();
        for (Colores aux : Colores.values()) {
            if (color.equalsIgnoreCase(aux.name())) {
                armadura.setColor1(aux);
                break;
            } else {
                armadura.setColor1(Colores.DORADO);
            }
        }
        
        System.out.print("Color secundario: ");
        color = br.readLine();
        for (Colores aux : Colores.values()) {
            if (color.equalsIgnoreCase(aux.name())) {
                armadura.setColor2(aux);
                break;
            } else {
                armadura.setColor2(Colores.ROJO);
            }
        }
        
        System.out.print("Resistencia: ");
        armadura.setResistencia(br.readLine());
        armadura.setSalud(100d);
        
        armadura.setPropulsor1(new Propulsor(15d));
        armadura.setPropulsor2(new Propulsor(15d));
        
        armadura.setRepulsor1(new Repulsor(10d));
        armadura.setRepulsor2(new Repulsor(10d));
        
        System.out.println("GENERADOR: ");
        System.out.print("Version del reactor ark: " );
        String version = br.readLine();
        Generador generador = new Generador(version, Estados.PERFECTO, 10000d);
        armadura.setGenerador(generador);
        
        armadura.setSintetizador(new Sintetizador(1d));
        armadura.setConsola(new Consola(1d));
        
        return armadura;
    }
}
