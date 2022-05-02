package implement;

import entity.Armadura;
import entity.Dispositivo;
import entity.Generador;
import entity.Objeto;
import entity.Repulsor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
CONSIDERACIONES PARA MEJORAR:
1. (HECHO) Utilizar como atributo de la armadura listas (de dos elementos) para los propulsores y repulsores.
Eso va a hacer mas facil el paso por parametro a las acciones y puedo settear consumos de energia distintos para c/ disp.

2. (HECHO) En lugar de usar atributos distintos para propulsores y repulsores, podria usar "dispositivos" (tienen = caracts).
A menos que los diferencie de alguna manera, ej: potencia de disparo de repulsores:
Podria hacer una superclase "dispositivo" de la cual hereden "prop" y "rep" y como atributo usar una list<disp>.

3. (HECHO) "Dispositivo" tambien seria la clase padre de sintonizador y consola (Por que no se me ocurrio antes lpm).

4. Para revisar los dispositivos podria hacer metodos especificos para cada uno (o hacer la lista de disp y problema resuelto).
De esa manera podria hacer que el metodo retorne algun valor y evitar el uso de void.

5. Puedo agregar un sistema que asigne automaticamente la resistencia del objeto dependiendo de su identificacion.

6. FALTA AGREGAR INTERACCION ENTRE REVISANDO DISPOSITIVOS Y OPCIONES EN EL MENU.

7. Agregar un atributo booleano "destruido".

8. Agregar probabilidad de fallo al metodo para disparar al enemigo.

9. Si agrego la interaccion entre las acciones y "revisando dispositivos", puedo usar los objetos ya creados en las acciones para el otro metodo.
Ej: propulsor derecho fue destruido.
 */
public class Jarvis {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void operation() throws IOException {

        // Creacion de la armadura.
        System.out.println("Buenos dias senior, ingrese la informacion de la armadura: ");
        ArmaduraImplementsService a = new ArmaduraImplementsService();
        Armadura armadura = a.crearArmadura();

        // Creo listas de los distintos tipos de dispositivos para poder usarlos en los distintos metodos.
        List<Dispositivo> propulsores = DispositivosImplementService.verificarDispositivo(armadura.getDispositivos(), "Propulsor");
        Dispositivo pd = propulsores.get(0);
        Dispositivo pi = propulsores.get(1);
        List<Dispositivo> repulsores = DispositivosImplementService.verificarDispositivo(armadura.getDispositivos(), "Repulsor");
        Dispositivo rd = repulsores.get(0);
        Dispositivo ri = repulsores.get(1);
        List<Dispositivo> consolas = DispositivosImplementService.verificarDispositivo(armadura.getDispositivos(), "Consola");
        Dispositivo consola = consolas.get(0);
        List<Dispositivo> sintetizadores = DispositivosImplementService.verificarDispositivo(armadura.getDispositivos(), "Sintetizador");
        Dispositivo sintetizador = sintetizadores.get(0);

        // Realizar acciones.
        AccionesImplementService acciones = new AccionesImplementService();
        Double energia_consumida = 0d;
        int opcion;
        do {
            System.out.println("Acciones: ");
            System.out.println("1. Caminar." + "\n"
                    + "2. Correr." + "\n"
                    + "3. Propulsar." + "\n"
                    + "4. Volar." + "\n"
                    + "5. Disparar." + "\n"
                    + "6. Escribir." + "\n"
                    + "7. Hablar." + "\n"
                    + "8. Null.");
            int tiempo;
            opcion = Integer.parseInt(br.readLine());
            switch (opcion) {
                case 1:
                    if (pd.getDanado() == false && pi.getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.caminar(pd, pi, tiempo);
                        propulsores.forEach((aux) -> aux.setDanado(probabilidadFallo(5)));
                    } else {
                        System.out.println("Revisando dispositivos ... ");
                        propulsores.forEach((aux) -> revisandoDispositivos(aux));
                    }
                    break;
                case 2:
                    if (pd.getDanado() == false && pi.getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.correr(pd, pi, tiempo);
                        propulsores.forEach((aux) -> aux.setDanado(probabilidadFallo(5)));
                    } else {
                        System.out.println("Revisando dispositivos ... ");
                        propulsores.forEach((aux) -> revisandoDispositivos(aux));
                    }
                    break;
                case 3:
                    if (pd.getDanado() == false && pi.getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.propulsar(pd, pi, tiempo);
                        propulsores.forEach((aux) -> aux.setDanado(probabilidadFallo(5)));
                    } else {
                        System.out.println("Revisando dispositivos ... ");
                        propulsores.forEach((aux) -> revisandoDispositivos(aux));
                    }
                    break;
                case 4:
                    if (pd.getDanado() == false && pi.getDanado() == false) {
                        if (rd.getDanado() == false && ri.getDanado() == false) {
                            System.out.print("Tiempo (minutos): ");
                            tiempo = Integer.parseInt(br.readLine());
                            energia_consumida += acciones.volar(pd, pi, rd, ri, tiempo);
                        }
                        propulsores.forEach((aux) -> aux.setDanado(probabilidadFallo(5)));
                        repulsores.forEach((aux) -> aux.setDanado(probabilidadFallo(5)));
                    } else {
                        System.out.println("Revisando dispositivos ... ");
                        propulsores.forEach((aux) -> revisandoDispositivos(aux));
                        repulsores.forEach((aux) -> revisandoDispositivos(aux));
                    }
                    break;
                case 5:
                    if (rd.getDanado() == false && ri.getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        System.out.println("Disparar ambos repulsores? 1/2. ");
                        int rta = Integer.parseInt(br.readLine());
                        if (rta == 2) {
                            energia_consumida += acciones.disparar(rd, tiempo);
                            energia_consumida += acciones.disparar(ri, tiempo);
                        } else {
                            energia_consumida += acciones.disparar(rd, tiempo);
                        }
                        repulsores.forEach((aux) -> aux.setDanado(probabilidadFallo(5)));
                    } else {
                        System.out.println("Revisando dispositivos ... ");
                        repulsores.forEach((aux) -> revisandoDispositivos(aux));
                    }
                    break;
                case 6:
                    if (consola.getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.escribir(consola, tiempo);
                        consola.setDanado(probabilidadFallo(5));
                    } else {
                        System.out.println("Revisando dispositivos ... ");
                        revisandoDispositivos(consola);
                    }
                    break;
                case 7:
                    if (sintetizador.getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.hablar(sintetizador, tiempo);
                        sintetizador.setDanado(probabilidadFallo(5));
                    } else {
                        System.out.println("Revisando dispositivos ... ");
                        revisandoDispositivos(sintetizador);
                    }
                default:
                    break;
            }
        } while (opcion != 8 || armadura.getGenerador().getCarga_actual() <= 0);

        // Resto el consumo de energia al total del generador.
        armadura.getGenerador().setCarga_actual(armadura.getGenerador().getCarga_maxima() - energia_consumida);

        // Mostrar ESTADO.
        System.out.println("Informacion del sistema: " + "\n"
                + armadura);

        // Mostrar Bateria del reactor.
        mostrarBateria(armadura.getGenerador());

        // Revisar TODOS los dispositivos.
        armadura.getDispositivos().forEach((aux) -> {
            revisandoDispositivos(aux);
        });

        // RADAR:
        Objeto[][][] radar = new Objeto[15][15][15];
        // Listas para generar objetos aleatorios ...
        ArrayList<Objeto> objetos = new ArrayList();
        ArrayList<Boolean> hostiles = new ArrayList();
        hostiles.add(Boolean.TRUE);
        hostiles.add(Boolean.FALSE);
        ArrayList<String> identificaciones = new ArrayList();
        identificaciones.add("AVION");
        identificaciones.add("BARCO");
        identificaciones.add("TANQUE");
        identificaciones.add("SUBMARINO");
        identificaciones.add("AUTO");
        identificaciones.add("OVNI");

        // Cantidad de objetos aleatorios.
        int random = (int) (Math.random() * 10);
        for (int i = 0; i < random; i++) {
            Objeto aux = new Objeto(identificaciones.get((int) (Math.random() * 6)), (int) (Math.random() * 15), (int) (Math.random() * 15), (int) (Math.random() * 15), hostiles.get((int) (Math.random() * 2)), null, (int) (Math.random() * 1000));
            objetos.add(aux);
            radar[aux.getX1()][aux.getY1()][aux.getZ1()] = aux;
        }

        // Calcular y mostrar distancia:
        objetos.stream().forEach((Objeto aux) -> aux.setDistancia(Radar.calcularDistancia(aux.getX1(), aux.getY1(), aux.getZ1())));
        objetos.stream().forEach(System.out::println);

        // Disparar.
        Integer potencia = 0;
        energia_consumida = 0d;

        for (Objeto aux : objetos) {
            if (aux.getHostil() == true && aux.getDistancia() < 25) {
                while (aux.getResistencia() > 0) {
                    if (rd.getDanado() == false && armadura.getGenerador().getCarga_actual() > 0) {
                        energia_consumida += acciones.disparar(rd, 1);
                        if (aux.getDistancia() < 15) {
                            if (rd instanceof Repulsor) {
                                Repulsor rep_d = (Repulsor) rd;
                                potencia = rep_d.getPotencia();
                            }
                        } else if (aux.getDistancia() > 15) {
                            potencia = 200;
                        }
                        rd.setDanado(probabilidadFallo(5));
                        aux.setResistencia(aux.getResistencia() - potencia);
                    } else if (rd.getDanado() == true) {
                        revisandoDispositivos(rd);
                    } else if (armadura.getGenerador().getCarga_actual() <= 0) {
                        mostrarBateria(armadura.getGenerador());
                        break;
                    }
                    if (ri.getDanado() == false && armadura.getGenerador().getCarga_actual() > 0) {
                        energia_consumida += acciones.disparar(rd, 1);
                        if (aux.getDistancia() < 15) {
                            if (ri instanceof Repulsor) {
                                Repulsor rep_i = (Repulsor) ri;
                                potencia = rep_i.getPotencia();
                            }
                        } else if (aux.getDistancia() > 15) {
                            potencia = 200;
                        }
                        ri.setDanado(probabilidadFallo(5));
                        aux.setResistencia(aux.getResistencia() - potencia);
                    } else if (ri.getDanado() == true) {
                        revisandoDispositivos(ri);
                    } else if (armadura.getGenerador().getCarga_actual() <= 0) {
                        mostrarBateria(armadura.getGenerador());
                        break;
                    }
                }
            }

            // Le resto la energia consumida por los disparos.
            armadura.getGenerador().setCarga_actual(armadura.getGenerador().getCarga_actual() - energia_consumida);
            if (aux.getResistencia() <= 0) {
                System.out.println(aux.getIdentificacion() + " enemigo fue destruido con exito.");
            }
        }

        // Acciones evasivas.
        Double carga_minima = (10 * armadura.getGenerador().getCarga_maxima()) / 100;
        if (armadura.getGenerador().getCarga_actual() <= carga_minima) {
            for (Objeto aux : objetos) {
                while (aux.getHostil() == true && aux.getDistancia() < 2) {
                    int x = aux.getX1(), y = aux.getY1(), z = aux.getZ1();
                    armadura.getPosicion()[0] = x + 3;
                    armadura.getPosicion()[1] = y + 3;
                    armadura.getPosicion()[2] = z + 3;
                }
                if (aux.getHostil() == true && aux.getDistancia() > 2) {
                    System.out.println("Hemos escapado de " + aux.getIdentificacion() + " enemigo.");
                }
            }
        }

    }
    
    public String mostrarBateria(Generador g) {
        return " - Energia restante del generador: " + (g.getCarga_actual() * 100) / g.getCarga_maxima() + "%";
    }

    // Generar la probabilidad de fallo antes y despues de realizar cada accion.
    public Boolean probabilidadFallo(int probabilidad) {
        Double random = (Math.random() * 100);
        return random <= probabilidad;
    }

    public void revisandoDispositivos(Dispositivo disp) {
        Double random;
        // En general es el 40% de las veces que se puede reparar un dispositivo.
        // Para esos intentos hay un 30% de posibilidades de que el dispositivo quede destruido.

        // Lo hice con un bucle while y no con un do while porque me olvide de la consigna ...
        while (disp.getDanado() == true) {
            random = (Math.random() * 100);
            if (random <= 40) {
                disp.setDanado(false);
                break;
            } else {
                random = (Math.random() * 100);
                if (random <= 30) {
                    System.out.println("El " + disp.getTipo().name() + " fue destruido.");
                    break;
                }
            }
        }
    }

}
