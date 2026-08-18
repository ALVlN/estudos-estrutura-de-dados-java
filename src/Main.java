import pilha.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha minhaPilha = new PilhaArray(5,0);
        minhaPilha.push("(Primeiro Elemento)");
        minhaPilha.push("(Segundo Elemento)");

        System.out.println("Removendo o item: " + minhaPilha.pop() + " do topo");
        System.out.println("O item no topo da pilha é: " + minhaPilha.top());

        System.out.println("O tamanho atual da pilha é:" + minhaPilha.size());

    }
}