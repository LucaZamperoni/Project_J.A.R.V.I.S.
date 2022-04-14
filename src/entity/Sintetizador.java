package entity;

public class Sintetizador {
    private Double energia;
    public Boolean danado = false;

    public Sintetizador() {
    }

    public Sintetizador(Double energia) {
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
        return "Sintetizador [" + "Consumo de energia por uso: " + energia + "| Danado: " + danado + ']';
    }
}
