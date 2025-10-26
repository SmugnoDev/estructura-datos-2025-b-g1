package EgSeptimoGrafos;

public class DemoMapaCiudades {
    public static void main(String[] args) {
        MapaCiudades mapa = new MapaCiudades();

        System.out.println("SISTEMA DE RUTAS MÁS CORTAS - DIJKSTRA");
        System.out.println("=".repeat(50));

        // Agregar ciudades
        System.out.println("\nAGREGANDO CIUDADES:");
        mapa.agregarCiudad("CDMX");
        mapa.agregarCiudad("Puebla");
        mapa.agregarCiudad("Cuernavaca");
        mapa.agregarCiudad("Toluca");
        mapa.agregarCiudad("Querétaro");
        mapa.agregarCiudad("Pachuca");

        // Agregar carreteras con distancias
        System.out.println("\nAGREGANDO CARRETERAS:");
        mapa.agregarCarretera("CDMX", "Puebla", 130);
        mapa.agregarCarretera("CDMX", "Cuernavaca", 85);
        mapa.agregarCarretera("CDMX", "Toluca", 65);
        mapa.agregarCarretera("CDMX", "Pachuca", 90);
        mapa.agregarCarretera("Puebla", "Cuernavaca", 180);
        mapa.agregarCarretera("Toluca", "Querétaro", 200);
        mapa.agregarCarretera("Querétaro", "Pachuca", 150);
        mapa.agregarCarretera("Cuernavaca", "Toluca", 120);

        // Mostrar mapa completo
        mapa.mostrarMapa();

        // Calcular rutas más cortas
        System.out.println("\nCALCULANDO RUTAS MÁS CORTAS:");

        // Ruta directa
        mapa.rutaMasCorta("CDMX", "Puebla");

        // Ruta con escalas
        mapa.rutaMasCorta("Puebla", "Querétaro");

        // Otra ruta interesante
        mapa.rutaMasCorta("Cuernavaca", "Pachuca");

        // Ruta sin conexión directa
        mapa.rutaMasCorta("CDMX", "Querétaro");
    }
}