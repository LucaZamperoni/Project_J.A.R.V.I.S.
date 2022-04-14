package entity;

import utility.Estados;

public class Generador {
    private String version;
    private Estados estado;
    private final Double carga_maxima = 100000d;
    private Double carga_actual;

    public Generador() {
    }

    public Generador(String version, Estados estado, Double carga_actual) {
        this.version = version;
        this.estado = estado;
        this.carga_actual = carga_actual;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Double getCarga_actual() {
        return carga_actual;
    }

    public void setCarga_actual(Double carga_actual) {
        this.carga_actual = carga_actual;
    }

    public Double getCarga_maxima() {
        return carga_maxima;
    }

    @Override
    public String toString() {
        return "Generador [" + "Version: " + version + "| Estado: " + estado + "| Carga maxima: " + carga_maxima + "| Carga actual: " + carga_actual + ']';
    }
}
