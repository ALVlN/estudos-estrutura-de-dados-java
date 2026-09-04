package fila;

public class FilaListaEncadeada {
    private Node inicioFila;
    private Node finalFila;
    private int size;

    public FilaListaEncadeada(){
        this.inicioFila = null;
        this.finalFila = null;
        this.size = 0;
    }

    public void enqueue(Object item){
        Node X = new Node(item);
        if(isEmpty()){
            inicioFila = X;
            finalFila = X;
        }
        else{
            finalFila.setNext(X);
            finalFila = X;
        }
        size++;
    }

    public Object dequeue() throws FilaVaziaExcecao{
        if(isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }

        Object itemRemovido = inicioFila.getValue();
        inicioFila = inicioFila.getNext();

        if(inicioFila == null){
            finalFila = null;
        }
        size--;
        return itemRemovido;
    }

    public Object first() throws FilaVaziaExcecao{
        if(isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return inicioFila.getValue();
    }

    public int getSize(){
        return size;
    }

    boolean isEmpty(){
        return inicioFila == null;
    }

    public void mostrarEstado() {
        System.out.println("\n=== Estado Atual da Fila ===");
        System.out.println("Tamanho: " + size);
        System.out.print("Estrutura: [ Início -> ");

        Node atual = inicioFila;

        while (atual != null) {
            System.out.print(atual.getValue() + " -> ");
            atual = atual.getNext();
        }
        System.out.println("null ]");
        System.out.println("============================\n");
    }
}
