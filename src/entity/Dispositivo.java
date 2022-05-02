package entity;

import utility.Dispositivos;

public class Dispositivo {

    protected Dispositivos tipo;
    protected Double energia;
    protected Boolean danado = false;

    public Dispositivo() {
    }

    public Dispositivo(Dispositivos tipo, Double energia) {
        this.tipo = tipo;
        this.energia = energia;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        this.energia = energia;
    }

    public Boolean getDanado() {
        return danado;
    }

    public void setDanado(Boolean danado) {
        this.danado = danado;
    }

    public Dispositivos getTipo() {
        return tipo;
    }

    public void setTipo(Dispositivos tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "Dispositivo [" + "Tipo: " + tipo.name() + "| Consumo de energia por uso: " + energia + "| Danado: " + danado + ']';
    }
}
