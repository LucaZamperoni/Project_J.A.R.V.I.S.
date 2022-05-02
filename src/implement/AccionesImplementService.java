package implement;

import entity.Dispositivo;
import entity.Repulsor;

public class AccionesImplementService {
    
    public Double caminar(Dispositivo p1, Dispositivo p2, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += p1.getEnergia();
            energia_consumida += p2.getEnergia();
        }
        return energia_consumida;
    }
    
    public Double correr(Dispositivo p1, Dispositivo p2, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (p1.getEnergia() * 2);
            energia_consumida += (p2.getEnergia() * 2);
        }
        return energia_consumida;
    }
    
    public Double propulsar(Dispositivo p1, Dispositivo p2, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (p1.getEnergia() * 3);
            energia_consumida += (p2.getEnergia() * 3);
        }
        return energia_consumida;
    }
    
    public Double volar(Dispositivo p1, Dispositivo p2, Dispositivo r1, Dispositivo r2, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (p1.getEnergia() * 3);
            energia_consumida += (p2.getEnergia() * 3);
            energia_consumida += (r1.getEnergia() * 2);
            energia_consumida += (r2.getEnergia() * 2);
        }
        return energia_consumida;
    }
    
    public Double disparar(Dispositivo r, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (r.getEnergia() * 3);
        }
        return energia_consumida;
    }
    
    public Double escribir(Dispositivo c, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (c.getEnergia());
        }
        return energia_consumida;
    }
    
    public Double hablar(Dispositivo s, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (s.getEnergia());
        }
        return energia_consumida;
    }
}
