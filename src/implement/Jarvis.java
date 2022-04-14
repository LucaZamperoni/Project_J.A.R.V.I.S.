package implement;

import entity.Armadura;
import entity.Generador;
import entity.Objeto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
CONSIDERACIONES PARA MEJORAR:
1. Utilizar como atributo de la armadura listas (de dos elementos) para los propulsores y repulsores.
Eso va a hacer mas facil el paso por parametro a las acciones y puedo settear consumos de energia distintos para c/ disp.

2. En lugar de usar atributos distintos para propulsores y repulsores, podria usar "dispositivos" (tienen = caracts).
A menos que los diferencie de alguna manera, ej: potencia de disparo de repulsores:
Podria hacer una superclase "dispositivo" de la cual hereden "prop" y "rep" y como atributo usar una list<disp>.

3. "Dispositivo" tambien seria la clase padre de sintonizador y consola (Por que no se me ocurrio antes lpm).

4. Para revisar los dispositivos podria hacer metodos especificos para cada uno (o hacer la lista de disp y problema resuelto).
De esa manera podria hacer que el metodo retorne algun valor y evitar el uso de void.

5. Puedo agregar un sistema que asigne automaticamente la resistencia del objeto dependiendo de su identificacion.

6. FALTA AGREGAR INTERACCION ENTRE REVISANDO DISPOSITIVOS Y OPCIONES EN EL MENU.

7. Agregar un atributo booleano "destruido".

8. Agregar probabilidad de fallo al metodo para disparar al enemigo.
 */
public class Jarvis {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void operation() throws IOException {

        // Creacion de la armadura.
        System.out.println("Buenos dias senior, ingrese la informacion de la armadura: ");
        ArmaduraImplementsService a = new ArmaduraImplementsService();
        Armadura armadura = a.crearArmadura();

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
                    if (armadura.getPropulsor1().getDanado() == false && armadura.getPropulsor2().getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.caminar(armadura.getPropulsor1(), tiempo);
                        armadura.getPropulsor1().setDanado(probabilidadFallo(50));
                        armadura.getPropulsor2().setDanado(probabilidadFallo(50));
                    } else {
                        if (armadura.getPropulsor1().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el propulsor 1 esta danado.");
                        } else if (armadura.getPropulsor2().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el propulsor 2 esta danado.");
                        }
                    }
                    break;
                case 2:
                    if (armadura.getPropulsor1().getDanado() == false && armadura.getPropulsor2().getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.correr(armadura.getPropulsor1(), tiempo);
                        armadura.getPropulsor1().setDanado(probabilidadFallo(50));
                        armadura.getPropulsor2().setDanado(probabilidadFallo(50));
                    } else {
                        if (armadura.getPropulsor1().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el propulsor 1 esta danado.");
                        } else if (armadura.getPropulsor2().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el propulsor 2 esta danado.");
                        }
                    }
                    break;
                case 3:
                    if (armadura.getPropulsor1().getDanado() == false && armadura.getPropulsor2().getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.propulsar(armadura.getPropulsor1(), tiempo);
                        armadura.getPropulsor1().setDanado(probabilidadFallo(50));
                        armadura.getPropulsor2().setDanado(probabilidadFallo(50));
                    } else {
                        if (armadura.getPropulsor1().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el propulsor 1 esta danado.");
                        } else if (armadura.getPropulsor2().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el propulsor 2 esta danado.");
                        }
                    }
                    break;
                case 4:
                    if (armadura.getPropulsor1().getDanado() == false && armadura.getPropulsor2().getDanado() == false && armadura.getRepulsor1().getDanado() == false && armadura.getRepulsor2().getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.volar(armadura.getPropulsor1(), armadura.getRepulsor1(), tiempo);
                        armadura.getPropulsor1().setDanado(probabilidadFallo(50));
                        armadura.getPropulsor2().setDanado(probabilidadFallo(50));
                        armadura.getRepulsor1().setDanado(probabilidadFallo(50));
                        armadura.getRepulsor2().setDanado(probabilidadFallo(50));
                    } else {
                        if (armadura.getPropulsor1().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el propulsor 1 esta danado.");
                        } else if (armadura.getPropulsor2().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el propulsor 2 esta danado.");
                        } else if (armadura.getRepulsor1().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el repulsor 1 esta danado.");
                        } else if (armadura.getRepulsor2().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el repulsor 2 esta danado.");
                        }
                    }
                    break;
                case 5:
                    if (armadura.getRepulsor1().getDanado() == false && armadura.getRepulsor2().getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.disparar(armadura.getRepulsor1(), tiempo);
                        armadura.getRepulsor1().setDanado(probabilidadFallo(50));
                        armadura.getRepulsor2().setDanado(probabilidadFallo(50));
                    } else {
                        if (armadura.getRepulsor1().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el repulsor 1 esta danado.");
                        } else if (armadura.getRepulsor2().getDanado() == true) {
                            System.out.println("La accion no se puede efectuar, el repulsor 2 esta danado.");
                        }
                    }
                    break;
                case 6:
                    if (armadura.getConsola().getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.escribir(armadura.getConsola(), tiempo);
                        armadura.getConsola().setDanado(probabilidadFallo(50));
                    } else {
                        System.out.println("La accion no se puede efectuar, la consola esta danada.");
                    }
                    break;
                case 7:
                    if (armadura.getSintetizador().getDanado() == false) {
                        System.out.print("Tiempo (minutos): ");
                        tiempo = Integer.parseInt(br.readLine());
                        energia_consumida += acciones.hablar(armadura.getSintetizador(), tiempo);
                        armadura.getSintetizador().setDanado(probabilidadFallo(50));
                    } else {
                        System.out.println("La accion no se puede efectuar, el sintetizador esta danado.");
                    }
                    break;
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

        // Revisar dispositivos.
        revisandoDispositivos(armadura);

        // RADAR:
        Objeto[][][] radar = new Objeto[15000][15000][15000];
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
            Objeto aux = new Objeto(identificaciones.get((int) (Math.random() * 6)), (int) (Math.random() * 15000), (int) (Math.random() * 15000), (int) (Math.random() * 15000), hostiles.get((int) (Math.random() * 2)), null, (int) (Math.random() * 1000));
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
            if (aux.getHostil() == true && aux.getDistancia() < 5000) {
                do {
                    if (armadura.getRepulsor1().getDanado() == false && armadura.getGenerador().getCarga_actual() > 0) {
                        energia_consumida += acciones.disparar(armadura.getRepulsor1(), 1);
                        if (aux.getDistancia() < 1000) {
                            potencia = 500;
                        } else if (aux.getDistancia() > 1000) {
                            potencia = 200;
                        }
                        aux.setResistencia(aux.getResistencia() - potencia);
                    } else if (armadura.getRepulsor1().getDanado() == true) {
                        System.out.println("El repulsor 1 esta danado o destruido. No puede atacar a " + aux.getIdentificacion() + " enemigo.");
                        break;
                    } else if (armadura.getGenerador().getCarga_actual() <= 0) {
                        System.out.println("Energia insuficiente. No puede atacar a " + aux.getIdentificacion() + " enemigo.");
                        break;
                    }
                } while (aux.getResistencia() <= 0);
                do {
                    if (armadura.getRepulsor2().getDanado() == false && armadura.getGenerador().getCarga_actual() > 0) {
                        energia_consumida += acciones.disparar(armadura.getRepulsor1(), 1);
                        if (aux.getDistancia() < 1000) {
                            potencia = 500;
                        } else if (aux.getDistancia() > 1000) {
                            potencia = 200;
                        }
                        aux.setResistencia(aux.getResistencia() - potencia);
                    } else if (armadura.getRepulsor2().getDanado() == true) {
                        System.out.println("El repulsor 2 esta danado o destruido. No puede atacar a " + aux.getIdentificacion() + " enemigo.");
                        break;
                    } else if (armadura.getGenerador().getCarga_actual() <= 0) {
                        System.out.println("Energia insuficiente. No puede atacar a " + aux.getIdentificacion() + " enemigo.");
                        break;
                    }
                } while (aux.getResistencia() <= 0);

                // Le resto la energia consumida por los disparos.
                armadura.getGenerador().setCarga_actual(armadura.getGenerador().getCarga_actual() - energia_consumida);
                if (aux.getResistencia() <= 0) {
                    System.out.println(aux.getIdentificacion() + " enemigo fue destruido con exito.");
                }
            }
        }

        // Acciones evasivas.
        Double carga_minima = (10 * armadura.getGenerador().getCarga_maxima()) / 10;
        if (armadura.getGenerador().getCarga_actual() <= carga_minima) {
            for (Objeto aux : objetos) {
                while (aux.getHostil() == true && aux.getDistancia() < 10000) {
                    int x = aux.getX1(), y = aux.getY1(), z = aux.getZ1();
                    armadura.getPosicion()[0] = x + 10000;
                    armadura.getPosicion()[1] = y + 10000;
                    armadura.getPosicion()[2] = z + 10000;
                }
                if (aux.getHostil() == true && aux.getDistancia() > 10000) {
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

    public void revisandoDispositivos(Armadura a) {
        Double random;
        // En general es el 40% de las veces que se puede reparar un dispositivo.
        // Para esos intentos hay un 30% de posibilidades de que el dispositivo quede destruido.
        if (a.getPropulsor1().getDanado() == true) {
            do {
                random = (Math.random() * 100);
                if (random <= 40) {
                    a.getPropulsor1().setDanado(false);
                } else {
                    random = (Math.random() * 100);
                    if (random <= 30) {
                        System.out.println("El propulsor 1 fue destruido.");
                        break;
                    }
                }
            } while (a.getPropulsor1().getDanado() == true);
        }

        if (a.getPropulsor2().getDanado() == true) {
            do {
                random = (Math.random() * 100);
                if (random <= 40) {
                    a.getPropulsor2().setDanado(false);
                } else {
                    random = (Math.random() * 100);
                    if (random <= 30) {
                        System.out.println("El propulsor 2 fue destruido.");
                        break;
                    }
                }
            } while (a.getPropulsor2().getDanado() == true);
        }

        if (a.getRepulsor1().getDanado() == true) {
            do {
                random = (Math.random() * 100);
                if (random <= 40) {
                    a.getRepulsor1().setDanado(false);
                } else {
                    random = (Math.random() * 100);
                    if (random <= 30) {
                        System.out.println("El repulsor 1 fue destruido.");
                        break;
                    }
                }
            } while (a.getRepulsor1().getDanado() == true);
        }

        if (a.getRepulsor2().getDanado() == true) {
            do {
                random = (Math.random() * 100);
                if (random <= 40) {
                    a.getRepulsor2().setDanado(false);
                } else {
                    random = (Math.random() * 100);
                    if (random <= 30) {
                        System.out.println("El repulsor 2 fue destruido.");
                        break;
                    }
                }
            } while (a.getRepulsor2().getDanado() == true);
        }

        if (a.getSintetizador().getDanado() == true) {
            do {
                random = (Math.random() * 100);
                if (random <= 40) {
                    a.getSintetizador().setDanado(false);
                } else {
                    random = (Math.random() * 100);
                    if (random <= 30) {
                        System.out.println("El sintetizador fue destruido.");
                        break;
                    }
                }
            } while (a.getSintetizador().getDanado() == true);
        }

        if (a.getConsola().getDanado() == true) {
            do {
                random = (Math.random() * 100);
                if (random <= 40) {
                    a.getConsola().setDanado(false);
                } else {
                    random = (Math.random() * 100);
                    if (random <= 30) {
                        System.out.println("La consola fue destruida.");
                        break;
                    }
                }
            } while (a.getConsola().getDanado() == true);
        }
    }

}
