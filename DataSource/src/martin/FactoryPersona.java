package martin;

import java.util.ArrayList;
import java.util.List;

public class FactoryPersona {
    public static List<Persona> createListPersonas()
    {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Pablo",37));
        listaPersonas.add(new Persona("Juan",18));
        return listaPersonas;
    }
}
