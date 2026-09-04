package pilha;

public class PilhaRubroNegra implements Pilha{
    private int capacidade;
    private Object[] a;
    private int topoVermelho;
    private int topoPreto;
    private int sizeVermelho;
    private int sizePreto;

    public PilhaRubroNegra(){
        this.capacidade = 2;
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

            for(int i = 0; i <sizePreto; i++){
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
        if(topoPreto <= 0 || topoPreto <= topoVermelho + 1){
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
            a = b;
        }
        topoPreto = capacidade - sizePreto;
        a[--topoPreto] = item;
        sizePreto++;
    }

    public Object pop() throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        Object itemRemovido = a[topoVermelho--];
        sizeVermelho--;

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
            a = b;
            topoPreto = capacidade - sizePreto;
        }
        return itemRemovido;
    }

    public Object popP() throws PilhaVaziaExcecao{
        if(isEmptyP()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        Object itemRemovido = a[topoPreto++];
        sizePreto--;

        if((capacidade / 3) >= (sizePreto + sizeVermelho)){
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
            a = b;
            topoPreto = capacidade - sizePreto;
        }
        return itemRemovido;
    }

    public Object top() throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return a[topoVermelho];
    }

    public Object topP() throws PilhaVaziaExcecao{
        if(isEmptyP()){
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

    public void mostrarEstado() {
        System.out.println("\n=== Estado Atual da Pilha Rubro-Negra ===");
        System.out.println("Capacidade total: " + capacidade);
        System.out.println("Tamanho Vermelho: " + sizeVermelho + " | Tamanho Preto: " + sizePreto);

        System.out.print("Array: [ ");
        for (int i = 0; i < capacidade; i++) {
            if (i <= topoVermelho) {
                System.out.print(a[i] + " ");
            } else if (i >= topoPreto) {
                System.out.print(a[i] + " ");
            } else {
                System.out.print(" -  ");
            }
        }
        System.out.println("]");
    }
}