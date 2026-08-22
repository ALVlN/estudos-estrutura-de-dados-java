import pilha.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pilha minhaPilha = new PilhaListaEncadeada();

        minhaPilha.push("Primero Item");
        minhaPilha.push("Segundo Item");
        minhaPilha.push("Terceiro Item");

        System.out.println("O " + minhaPilha.pop() + " foi removido da pilha");
        System.out.println("O " + minhaPilha.pop() + " foi removido da pilha");

        System.out.println("O item no topo da pilha é o: " + minhaPilha.top());
        System.out.println("A minha pilha está com o tamanho de " + minhaPilha.size());
        minhaPilha.isEmpty();

    }
}