package biropruebas;

import java.util.*;

public class Grafos {
	
    public static void main(String[] grafos) {
        Map<Integer, List<Integer>> grafo = new HashMap<>(); // CREAMOS UNA INSTANCIA DE HASHMAP QUE RECIBE UN ENTERO (NUM DE NODO) Y UNA LISTA DE ENTEROS (VECINOS)
        grafo.put(1, Arrays.asList(2, 3, 4)); // CON EL METODO PUT INGRESAMOS LOS VALORES DEL NUMERO DE NODO Y LOS VECINOS QUE ESTE TIENE
        grafo.put(2, Arrays.asList(1, 3, 4));
        grafo.put(3, Arrays.asList(1, 2, 4));
        grafo.put(4, Arrays.asList(1, 2, 3, 5));
        grafo.put(5, Arrays.asList(4));
        grafo.put(6, Arrays.asList(1,2,3,4));

        int maximoGrafoNodo = encontrarNodoMayor(grafo);
        System.out.println("Nodo con mayor número de vecinos: " + maximoGrafoNodo+"\n\n"); //IMPRIMIMOS EL NUMERO DEL NODO QUE TUVO LA MAYOR CANTIDAD DE VECINOS
        System.out.println("Representación gráfica del grafo:");
        imprimeGrafo(grafo); // LLAMAMOS AL METODO QUE IMPRIME EL GRAFO
    }

    public static int encontrarNodoMayor(Map<Integer, List<Integer>> grafo) { // METODO ESTÁTICO PARA SER LLAMADO DESDE EL MAIN DIRECTAMENTE RETORNA UN INT (NODO MAYOR) Y RECIBE EL GRAFO
        int maximo = 0;
        List<Integer> maxgradoNodo = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entrada : grafo.entrySet()) { //RECORREMOS PARA OBTENER LA CORRIDA DE ENTRY DE LA CLASE HASHMAP QUE CONTIENE LOS VALORES Y CLAVES (RECORRIDO DE MAP)
            int gradoNodo = entrada.getValue().size();
            if (gradoNodo > maximo) { //COMPARAMOS CON EL ACTUAL MAXIMO Y EN CASO DE SER MAYOR PASA A SER EL NUEVO MAXIMO
                maximo = gradoNodo;
                maxgradoNodo.clear();
                maxgradoNodo.add(entrada.getKey());
            } else if (gradoNodo == maximo) {
                maxgradoNodo.add(entrada.getKey());
            }
        }

        int rnd = new Random().nextInt(maxgradoNodo.size()); // EN CASO DE QUE HAYAN N CANTIDAD DE NODOS CON LA MISMA CANTIDAD DE VECINOS,
        //GENERAMOS UN NUMERO PSEUDOALEATORIO QUE NOS PERMITA IMPRIMIR UNO DE ELLOS, TAL COMO LO PIDE LA INSTRUCCIÓN
        
        return maxgradoNodo.get(rnd); // METODO GET DE MAXGRADONODO QUE NOS RETORNARÁ ALGUNO DE LOS RESULTADOS
    }

    public static void imprimeGrafo(Map<Integer, List<Integer>> grafo) { // METODO PARA IMPRIMIR EN CONSOLA EL GRAFO
        for (Map.Entry<Integer, List<Integer>> entrada : grafo.entrySet()) {
            int nodo = entrada.getKey();
            List<Integer> vecinos = entrada.getValue();

            System.out.print("Nodo " + nodo + "\t->\t"); // IMPRIMIR LA PALABRA NODO + EL NUMERO DEL NODO Y LA FLECHA QUE HACE LA REPRESENTACION

            for (int vecinoact : vecinos) { // RECORREMOS LOS VECINOS Y LE PONEMOS UN TABULADOR DESPUES DE CADA UNO PARA ESTILIZARLO
                System.out.print(vecinoact + "\t");
            }

            System.out.println(); //IMPRIMIMOS UN SALTO DE LINEA FUERA DEL CICLO
        }
    }
}
