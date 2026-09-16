package lista;

public class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;
    private int size;

    public ListaDuplamenteEncadeada(){
        this.size = 0;
        this.inicio = new No();
        this.fim = new No();
        this.inicio.setProximo(this.fim);
        this.fim.setAnterior(this.inicio);
    }

    //Métodos Genéricos:
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //Métodos de fila:
    public boolean isFirst(No n){
        return n != null && n.getAnterior() == inicio;
    }

    public boolean isLast(No n){
        return n != null && n.getProximo() == fim;
    }

    //Métodos para acessar:
    public No first(){
        if(isEmpty()) return null;
        return inicio.getProximo();
    }

    public No last(){
        if(isEmpty()) return null;
        return fim.getAnterior();
    }

    public No before(No p){
        if(isFirst(p)) return null;
        return p.getAnterior();
    }

    public No after(No p){
        if(isLast(p)) return null;
        return p.getProximo();
    }

    public No search(Object o) throws RuntimeException{

        No atual = inicio.getProximo();
        while(atual != fim){
            if(atual.getElement() == o){
                return atual;
            }
            atual = atual.getProximo();
        }
        throw new RuntimeException("Elemento não encontrado");
    }


    //Métodos para atualizar:
    public Object replaceElement(No n, Object o){
        Object elementoAntigo = n.getElement();
        n.setElement(o);
        return elementoAntigo;
    }

    public void swapElements(No n, No q){
        Object temp = n.getElement();
        n.setElement(q.getElement());
        q.setElement(temp);
    }

    public No insertAfter(No p, Object o){
        No q = new No();
        q.setElement(o);
        q.setAnterior(p);
        q.setProximo(p.getProximo());
        (p.getProximo()).setAnterior(q);
        p.setProximo(q);

        size++;
        return q;
    }

    public No insertBefore(No n, Object o){
        return insertAfter(n.getAnterior(), o);
    }

    public No insertFirst(Object o){
        return insertAfter(inicio, o);
    }

    public No insertLast(Object o){
        return insertAfter(fim.getAnterior(), o);
    }

    public Object remove(No p){
        Object elementoRemovido = p.getElement();

        (p.getAnterior()).setProximo(p.getProximo());
        (p.getProximo()).setAnterior(p.getAnterior());
        p.setAnterior(null);
        p.setProximo(null);

        size--;
        return elementoRemovido;
    }

    public void mostrarEstado() {
        System.out.println("\n=== Estado Atual da Lista Duplamente Encadeada ===");
        System.out.println("Tamanho: " + size);

        No atual = inicio.getProximo();

        while (atual != fim) {
            System.out.print(atual.getElement() + " <-> ");
            atual = atual.getProximo();
        }
        System.out.println("\n");
    }
}
