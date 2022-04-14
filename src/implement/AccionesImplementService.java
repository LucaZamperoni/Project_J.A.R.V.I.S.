package implement;

import entity.Consola;
import entity.Propulsor;
import entity.Repulsor;
import entity.Sintetizador;

public class AccionesImplementService {
    
    public Double caminar(Propulsor p, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += p.getEnergia();
            energia_consumida += p.getEnergia();
        }
        return energia_consumida;
    }
    
    public Double correr(Propulsor p, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (p.getEnergia() * 2);
            energia_consumida += (p.getEnergia() * 2);
        }
        return energia_consumida;
    }
    
    public Double propulsar(Propulsor p, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (p.getEnergia() * 3);
            energia_consumida += (p.getEnergia() * 3);
        }
        return energia_consumida;
    }
    
    public Double volar(Propulsor p, Repulsor r, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (p.getEnergia() * 3);
            energia_consumida += (p.getEnergia() * 3);
            energia_consumida += (r.getEnergia() * 2);
            energia_consumida += (r.getEnergia() * 2);
        }
        return energia_consumida;
    }
    
    public Double disparar(Repulsor r, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (r.getEnergia() * 3);
        }
        return energia_consumida;
    }
    
    public Double escribir(Consola c, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (c.getEnergia());
        }
        return energia_consumida;
    }
    
    public Double hablar(Sintetizador s, Integer minutos){
        Double energia_consumida = 0d;
        for (int i = 0; i < minutos; i++) {
            energia_consumida += (s.getEnergia());
        }
        return energia_consumida;
    }
}
