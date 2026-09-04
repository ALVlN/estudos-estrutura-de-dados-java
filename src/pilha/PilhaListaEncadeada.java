package pilha;
import pilha.Node;

public class PilhaListaEncadeada implements Pilha {
    private Node t;
    private int _size;

    public PilhaListaEncadeada(){
        this.t = null;
        this._size = 0;
    }

    public void push(Object item){
        Node N = new Node(item);
        N.setNext(t);
        t = N;
        _size++;
    }

    public Object pop() throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        Object itemRemovido = t.getValue();
        t = t.getNext();
        _size--;
        return itemRemovido;
    }

    public Object top() throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        return t.getValue();
    }

    public int size(){
        return _size;
    }

    public boolean isEmpty(){
        return t == null;
    }
}
