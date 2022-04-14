package entity;

public class Objeto {
    private String identificacion;
    private int x1;
    private int y1;
    private int z1;
    private Boolean hostil;
    private Double distancia;
    private Integer resistencia;

    public Objeto(String identificacion, int x1, int y1, int z1, Boolean hostil, Double distancia, Integer resistencia) {
        this.identificacion = identificacion;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.hostil = hostil;
        this.distancia = distancia;
        this.resistencia = resistencia;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getZ1() {
        return z1;
    }

    public void setZ1(int z1) {
        this.z1 = z1;
    }

    public Boolean getHostil() {
        return hostil;
    }

    public void setHostil(Boolean hostil) {
        this.hostil = hostil;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return " - Objeto [" + "Identificacion: " + identificacion + "| POSICION: (" + x1 + ") (" + y1 + ") (" + z1 + ") | Hostil:" + hostil + "| DISTANCIA: " + distancia + "m " + "| Resistencia: " + resistencia +']';
    }
}
