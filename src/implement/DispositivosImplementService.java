package implement;

import entity.Dispositivo;
import java.util.ArrayList;
import java.util.List;

public class DispositivosImplementService {
    public static List<Dispositivo> verificarDispositivo(List<Dispositivo> dispositivos, String tipo){
        ArrayList<Dispositivo> disp_requeridos = new ArrayList();
        dispositivos.stream().filter((aux) -> (aux.getTipo().toString().equalsIgnoreCase(tipo))).forEachOrdered(disp_requeridos::add);
        return disp_requeridos;
    }
}
