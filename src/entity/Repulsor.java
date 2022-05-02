package entity;

import utility.Dispositivos;

public class Repulsor extends Dispositivo{
    
    private Integer potencia;

    public Repulsor() {
    }

    public Repulsor(Integer potencia) {
        this.potencia = potencia;
    }

    public Repulsor(Integer potencia, Dispositivos tipo, Double energia) {
        super(tipo, energia);
        this.potencia = potencia;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return super.toString() + " - Repulsor [" + "Potencia: " + potencia + ']';
    }
}
