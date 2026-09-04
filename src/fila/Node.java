package fila;

public class Node {
    private Object valor;
    private Node next;

    public Node(Object valor){
        this.valor = valor;
        this.next = null;
    }

    public void setNext(Node N){
        this.next = N;
    }

    public Object getValue(){
        return this.valor;
    }

    public Node getNext(){
        return this.next;
    }
}
