package pilha;

public class PilhaVP implements Pilha{
    private int capacidade;
    private Object[] a;
    private int topoVermelho;
    private int topoPreto;
    private int sizeVermelho;
    private int sizePreto;

    public PilhaVP(){
        this.capacidade = 1;
        topoVermelho = -1;
        topoPreto = capacidade;
        sizeVermelho = 0;
        sizePreto = 0;
        a = new Object[capacidade];
    }

    public void push(Object item){
        if(topoVermelho >= (capacidade -1) || topoVermelho >= (topoPreto-1)){
            int indiceTempA = (capacidade - 1);
            capacidade *= 2;
            int indiceTempB = (capacidade - 1);
            Object b[] = new Object[capacidade];

            for(int i = 0; i <=sizePreto; i++){
                b[indiceTempB-i] = a[indiceTempA-i];
            }
            for(int f=0; f<sizeVermelho; f++){
                b[f] = a[f];
            }
            a = b;

        }
        a[++topoVermelho] = item;
        sizeVermelho++;
        topoPreto = capacidade - sizePreto;
    }

    public void pushP(Object item){
        if(topoPreto <= 0 || topoPreto <= topoVermelho){
            int indiceTempA = (capacidade - 1);
            capacidade *= 2;
            int indiceTempB = (capacidade -1);
            Object b[] = new Object[capacidade];

            for(int i = 0; i<sizePreto; i++){
                b[indiceTempB-i] = a[indiceTempA-i];
            }
            for(int f=0; f<sizeVermelho; f++){
                b[f] = a[f];
            }
        }
        topoPreto = capacidade - sizePreto;
        a[--topoPreto] = item;
        sizePreto++;
    }

    public Object pop() throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        if((capacidade / 3) > (sizePreto + sizeVermelho)){
            int indiceTempA = (capacidade -1);
            capacidade /= 2;
            int indiceTempB = (capacidade -1);
            Object b[] = new Object[capacidade];

            for(int i = 0; i < sizePreto; i++){
                b[indiceTempB-i] = a[indiceTempA-i];
            }
            for(int f=0; f<sizeVermelho; f++){
                b[f] = a[f];
            }
        }
        Object itemRemovido = a[topoVermelho--];
        return itemRemovido;
    }

    public Object popP() throws PilhaVaziaExcecao{
        if(isEmptyP()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        if((capacidade / 3) > (sizePreto + sizeVermelho)){
            int indiceTempA = (capacidade -1);
            capacidade /= 2;
            int indiceTempB = (capacidade -1);
            Object b[] = new Object[capacidade];

            for(int i = 0; i < sizePreto; i++){
                b[indiceTempB-i] = a[indiceTempA-i];
            }
            for(int f=0; f<sizeVermelho; f++){
                b[f] = a[f];
            }
        }
        Object itemRemovido = a[topoPreto++];
        return itemRemovido;
    }

    public Object top() throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return a[topoVermelho];
    }

    public Object topP() throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return a[topoPreto];
    }

    public boolean isEmpty(){
        return topoVermelho == -1;
    }

    public boolean isEmptyP(){
        return topoPreto == capacidade;
    }

    public int size(){
        return sizeVermelho;
    }

    public int sizeP(){
        return  sizePreto;
    }
}