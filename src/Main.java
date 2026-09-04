import pilha.*;
import fila.*;
import vetor.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VetorArray meuVetor = new VetorArray();

        meuVetor.insertAtRank(0,"A");
        meuVetor.insertAtRank(1, "C");
        meuVetor.insertAtRank(2, "B");

        meuVetor.mostrarEstado();

        meuVetor.replaceAtRank(1,"B");
        meuVetor.replaceAtRank(2,"C");

        meuVetor.mostrarEstado();

        meuVetor.removeAtRank(1);

        meuVetor.mostrarEstado();


    }
}