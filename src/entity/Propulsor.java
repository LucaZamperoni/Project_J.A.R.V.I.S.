package entity;

public class Propulsor {
    private Double energia;
    public Boolean danado = false;

    public Propulsor() {
    }

    public Propulsor(Double energia) {
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

    @Override
    public String toString() {
        return "Propulsor [" + "Consumo de energia por uso: " + energia + "| Danado: " + danado + ']';
    }
}
