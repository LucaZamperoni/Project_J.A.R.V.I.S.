package entity;

public class Consola {
    private Double energia;
    public Boolean danado = false;

    public Consola() {
    }

    public Consola(Double energia) {
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
        return "Consola [" + "Consumo de energia por uso: " + energia + "| Danado: " + danado + ']';
    }
}
