package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Directorio {
    private TreeMap<Long, Cliente> contactos;

    public Directorio(TreeMap<Long, Cliente> contactos) {
        this.contactos = contactos;
    }
    
    //a) agregar contacto
    public boolean agregarContacto(Long telefono, Cliente cliente){
        boolean agregado = false; //si se agrega correctamente recibimos el true
        if (!contactos.containsKey(telefono)){
            contactos.put(telefono, cliente);
            agregado = true;
        }
        return agregado;
    }
    
    //b) buscar contacto por telefono
    public Cliente buscarContactoConTelefono(Long telefono){
        return contactos.get(telefono);
    }
    
    //c) buscar telefonos por apellido
    public Set<Long> buscarTelefonoPorApellido(String apellido){
        Set<Long> telefonos = new TreeSet<>();
        for (Map.Entry<Long, Cliente> entry : contactos.entrySet()){
            if (entry.getValue().getApellido().equalsIgnoreCase(apellido)){
                telefonos.add(entry.getKey());
            }
        }
        return telefonos;
    }
    
    //d) buscar contactos por ciudad
    public ArrayList<Cliente> buscarContactosPorCiudad(String ciudad){
        ArrayList<Cliente> lista = new ArrayList<>();
        for (Cliente cliente : contactos.values()){
            if (cliente.getCiudad().equalsIgnoreCase(ciudad)){
                lista.add(cliente);
            }
        }
        return lista;
    }
    
    //e) borrar contacto por telefono
    public boolean borrarContactoPorTelefono(Long telefono){
        boolean borrado = false; //como en el A) para saber si se borró correctamente recibimos un true del otro lado
        if (contactos.containsKey(telefono)){
            contactos.remove(telefono);
            borrado = true;
        }
        return borrado;
    }
}
