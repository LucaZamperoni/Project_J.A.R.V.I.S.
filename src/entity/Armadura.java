package entity;

import java.util.Arrays;
import java.util.List;
import utility.Colores;

// Cada dispositivo de la armadura de Iron Man (botas, guantes, consola y sintetizador) tienen un consumo de energía asociado. 
public class Armadura {
    private String nombre;
    private Colores color1;
    private Colores color2;
    private String resistencia;
    private Double salud;
    private List<Dispositivo> dispositivos;
    private Generador generador;
    private int [] posicion = new int[3];

    public Armadura() {
    }

    public Armadura(String nombre, Colores color1, Colores color2, String resistencia, Double salud, List<Dispositivo> dispositivos, Generador generador) {
        this.nombre = nombre;
        this.color1 = color1;
        this.color2 = color2;
        this.resistencia = resistencia;
        this.salud = salud;
        this.dispositivos = dispositivos;
        this.generador = generador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Colores getColor1() {
        return color1;
    }

    public void setColor1(Colores color1) {
        this.color1 = color1;
    }

    public Colores getColor2() {
        return color2;
    }

    public void setColor2(Colores color2) {
        this.color2 = color2;
    }

    public String getResistencia() {
        return resistencia;
    }

    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }

    public Double getSalud() {
        return salud;
    }

    public void setSalud(Double salud) {
        this.salud = salud;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public Generador getGenerador() {
        return generador;
    }

    public void setGenerador(Generador generador) {
        this.generador = generador;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Armadura[" + "\nNombre: " + nombre + "\nColor Primario: " + color1 + "\nColor Secundario: " + color2 + "\nResistencia: " + resistencia + "\nSalud: " + salud + "\nDispositivos: " + dispositivos + "\nGenerador: " + generador + "\nPosicion: " + Arrays.toString(posicion) + ']';
    }
}
