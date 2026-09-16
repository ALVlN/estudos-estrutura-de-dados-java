import lista.*;
import pilha.*;
import fila.*;
import vetor.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.insertFirst(1);
        lista.insertLast(3);
        lista.mostrarEstado();

        No noUm = lista.first();
        lista.insertAfter(noUm, 2);
        lista.mostrarEstado();

        lista.remove(lista.last());
        lista.mostrarEstado();
        System.out.println(lista.search(2).getElement());
        lista.insertAfter(lista.search(1), 2004);
        lista.mostrarEstado();
    }
}