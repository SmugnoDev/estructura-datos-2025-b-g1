package EgSeptimoGrafos;

import java.util.*;

class Ciudad {
    String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Ciudad ciudad = (Ciudad) obj;
        return Objects.equals(nombre, ciudad.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class Arista {
    Ciudad destino;
    int distancia;

    public Arista(Ciudad destino, int distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }
}

public class MapaCiudades {
    private Map<Ciudad, List<Arista>> grafo;

    public MapaCiudades() {
        this.grafo = new HashMap<>();
    }

    // AGREGAR CIUDAD
    public void agregarCiudad(String nombre) {
        Ciudad ciudad = new Ciudad(nombre);
        grafo.putIfAbsent(ciudad, new ArrayList<>());
        System.out.println("Ciudad agregada: " + nombre);
    }

    // AGREGAR CARRETERA
    public void agregarCarretera(String origen, String destino, int distancia) {
        Ciudad ciudadOrigen = new Ciudad(origen);
        Ciudad ciudadDestino = new Ciudad(destino);

        if (!grafo.containsKey(ciudadOrigen) || !grafo.containsKey(ciudadDestino)) {
            System.out.println("Error: Una o ambas ciudades no existen");
            return;
        }

        grafo.get(ciudadOrigen).add(new Arista(ciudadDestino, distancia));
        grafo.get(ciudadDestino).add(new Arista(ciudadOrigen, distancia)); // No dirigido
        System.out.println("Carretera agregada: " + origen + " ↔ " + destino + " (" + distancia + " km)");
    }

    // ALGORITMO DE DIJKSTRA
    public void rutaMasCorta(String origen, String destino) {
        Ciudad ciudadOrigen = new Ciudad(origen);
        Ciudad ciudadDestino = new Ciudad(destino);

        if (!grafo.containsKey(ciudadOrigen) || !grafo.containsKey(ciudadDestino)) {
            System.out.println("Error: Ciudad de origen o destino no existe");
            return;
        }

        // Estructuras para Dijkstra
        Map<Ciudad, Integer> distancias = new HashMap<>();
        Map<Ciudad, Ciudad> predecesores = new HashMap<>();
        PriorityQueue<Ciudad> colaPrioridad = new PriorityQueue<>(
                Comparator.comparingInt(distancias::get));

        // Inicializar distancias
        for (Ciudad ciudad : grafo.keySet()) {
            distancias.put(ciudad, Integer.MAX_VALUE);
        }
        distancias.put(ciudadOrigen, 0);
        colaPrioridad.add(ciudadOrigen);

        // Algoritmo de Dijkstra
        while (!colaPrioridad.isEmpty()) {
            Ciudad actual = colaPrioridad.poll();

            if (actual.equals(ciudadDestino)) {
                break; // Llegamos al destino
            }

            for (Arista arista : grafo.get(actual)) {
                int nuevaDistancia = distancias.get(actual) + arista.distancia;

                if (nuevaDistancia < distancias.get(arista.destino)) {
                    distancias.put(arista.destino, nuevaDistancia);
                    predecesores.put(arista.destino, actual);
                    colaPrioridad.add(arista.destino);
                }
            }
        }

        // Reconstruir y mostrar la ruta
        mostrarRuta(ciudadOrigen, ciudadDestino, distancias, predecesores);
    }

    private void mostrarRuta(Ciudad origen, Ciudad destino,
            Map<Ciudad, Integer> distancias,
            Map<Ciudad, Ciudad> predecesores) {

        if (distancias.get(destino) == Integer.MAX_VALUE) {
            System.out.println("No hay ruta de " + origen + " a " + destino);
            return;
        }

        // Reconstruir ruta
        List<Ciudad> ruta = new ArrayList<>();
        Ciudad actual = destino;

        while (actual != null) {
            ruta.add(actual);
            actual = predecesores.get(actual);
        }
        Collections.reverse(ruta);

        // Mostrar resultados
        System.out.println("\nRUTA MÁS CORTA:");
        System.out.println("De: " + origen + " → A: " + destino);
        System.out.println("Distancia total: " + distancias.get(destino) + " km");
        System.out.print("Ruta: ");

        for (int i = 0; i < ruta.size(); i++) {
            System.out.print(ruta.get(i));
            if (i < ruta.size() - 1) {
                System.out.print(" → ");
            }
        }
        System.out.println("\n");
    }

    // MOSTRAR MAPA COMPLETO
    public void mostrarMapa() {
        System.out.println("\nMAPA DE CARRETERAS:");
        System.out.println("=".repeat(40));

        for (Map.Entry<Ciudad, List<Arista>> entry : grafo.entrySet()) {
            System.out.print(entry.getKey() + " → ");
            for (Arista arista : entry.getValue()) {
                System.out.print(arista.destino + "(" + arista.distancia + "km) ");
            }
            System.out.println();
        }
    }
}