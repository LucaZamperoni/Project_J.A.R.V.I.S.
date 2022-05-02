package implement;

import entity.Armadura;
import entity.Dispositivo;
import entity.Generador;
import entity.Repulsor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import utility.Colores;
import utility.Dispositivos;
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
        
        ArrayList<Dispositivo> dispositivos = new ArrayList();
        dispositivos.add(new Dispositivo(Dispositivos.PROPULSOR, 10d));
        dispositivos.add(new Dispositivo(Dispositivos.PROPULSOR, 10d));
        dispositivos.add(new Repulsor(1000, Dispositivos.REPULSOR, 10d));
        dispositivos.add(new Repulsor(1000, Dispositivos.REPULSOR, 10d));
        dispositivos.add(new Dispositivo(Dispositivos.CONSOLA, 5d));
        dispositivos.add(new Dispositivo(Dispositivos.SINTETIZADOR, 5d));
        armadura.setDispositivos(dispositivos);
        
        System.out.println("GENERADOR: ");
        System.out.print("Version del reactor ark: " );
        String version = br.readLine();
        Generador generador = new Generador(version, Estados.PERFECTO, 10000d);
        armadura.setGenerador(generador);
        
        return armadura;
    }
}
