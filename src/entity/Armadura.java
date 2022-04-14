package entity;

import utility.Colores;

// Cada dispositivo de la armadura de Iron Man (botas, guantes, consola y sintetizador) tienen un consumo de energía asociado. 
public class Armadura {
    private String nombre;
    private Colores color1;
    private Colores color2;
    private String resistencia;
    private Double salud;
    private Propulsor propulsor1;
    private Propulsor propulsor2;
    private Repulsor repulsor1;
    private Repulsor repulsor2;
    private Generador generador;
    private Sintetizador sintetizador;
    private Consola consola;
    private int [] posicion = new int[3];

    public Armadura() {
    }

    public Armadura(String nombre, Colores color1, Colores color2, String resistencia, Double salud, Propulsor propulsor1, Propulsor propulsor2, Repulsor repulsor1, Repulsor repulsor2, Generador generador, Sintetizador sintetizador, Consola consola) {
        this.nombre = nombre;
        this.color1 = color1;
        this.color2 = color2;
        this.resistencia = resistencia;
        this.salud = salud;
        this.propulsor1 = propulsor1;
        this.propulsor2 = propulsor2;
        this.repulsor1 = repulsor1;
        this.repulsor2 = repulsor2;
        this.generador = generador;
        this.sintetizador = sintetizador;
        this.consola = consola;
        this.posicion[0] = 0;
        this.posicion[1] = 0;
        this.posicion[2] = 0;
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

    public Propulsor getPropulsor1() {
        return propulsor1;
    }

    public void setPropulsor1(Propulsor propulsor1) {
        this.propulsor1 = propulsor1;
    }

    public Propulsor getPropulsor2() {
        return propulsor2;
    }

    public void setPropulsor2(Propulsor propulsor2) {
        this.propulsor2 = propulsor2;
    }

    public Repulsor getRepulsor1() {
        return repulsor1;
    }

    public void setRepulsor1(Repulsor repulsor1) {
        this.repulsor1 = repulsor1;
    }

    public Repulsor getRepulsor2() {
        return repulsor2;
    }

    public void setRepulsor2(Repulsor repulsor2) {
        this.repulsor2 = repulsor2;
    }

    public Generador getGenerador() {
        return generador;
    }

    public void setGenerador(Generador generador) {
        this.generador = generador;
    }

    public Sintetizador getSintetizador() {
        return sintetizador;
    }

    public void setSintetizador(Sintetizador sintetizador) {
        this.sintetizador = sintetizador;
    }

    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }
    
    @Override
    public String toString() {
        return "Armadura:" + "\nNombre: " + nombre + "\nColor primario: " + color1 + "\nColor secundario: " + color2 + "\nResistencia: " + resistencia + "\nSalud: " + salud + "\nPropulsor derecho: " + propulsor1 + "\nPropulsor izquierdo: " + propulsor2 + "\nRepulsor derecho: " + repulsor1 + "\nRepulsor izquierdo: " + repulsor2 + "\nGenerador: " + generador + "\nSintetizador: " + sintetizador + "\nConsola: " + consola + "\nPosicion: " + posicion[0] + "," + posicion[1] + "," + posicion[2];
    }
}
