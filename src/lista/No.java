package lista;

public class No{
    private Object elemento;
    private No anterior;
    private No proximo;

    public Object getElement(){
        return elemento;
    }

    public void setElement(Object elemento){
        this.elemento = elemento;
    }

    public No getAnterior(){
        return anterior;
    }

    public void setAnterior(No anterior){
        this.anterior = anterior;
    }

    public No getProximo(){
        return proximo;
    }

    public void setProximo(No proximo){
        this.proximo = proximo;
    }
}
