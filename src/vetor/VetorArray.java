package vetor;

public class VetorArray {
    private Object[] a;
    private int capacidade;
    private int size;

    public VetorArray(){
        this.capacidade = 10;
        this.a = new Object[capacidade];
        this.size = 0;
    }

    private void checkRank(int r, int limite) throws VetorExcecao{
        if(r < 0 || r > limite){
            throw new VetorExcecao("Índice (rank) inválido");
        }
    }

    public Object elementAtRank(int r) throws VetorExcecao{
        checkRank(r, size - 1);
        return a[r];
    }

    public Object replaceAtRank(int r, Object elemento) throws VetorExcecao{
        checkRank(r, size - 1);
        Object elementoAlterado = a[r];
        a[r] = elemento;
        return elementoAlterado;
    }

    public void insertAtRank(int r, Object elemento) throws VetorExcecao{
        checkRank(r, size);

        if(size == capacidade){
            capacidade += 2;
            Object[] b = new Object[capacidade];
            for(int i = 0; i<size; i++){
                b[i] = a[i];
            }
            a = b;
        }
        for(int i = (size - 1); i>= r; i--){
            a[i + 1] = a[i];
        }

        a[r] = elemento;
        size++;
    }

    public Object removeAtRank(int r)throws VetorExcecao{
        checkRank(r, size - 1);

        Object elementoRemovido = a[r];

        for(int i = r; i < size - 1; i++){
            a[i] = a[i + 1];
        }

        a[size - 1] = null;
        size--;
        return elementoRemovido;
    }

    public void mostrarEstado() {
        System.out.println("\n=== Estado Atual do Vetor (Array) ===");
        System.out.println("Tamanho atual: " + size + " | Capacidade total: " + capacidade);
        System.out.print("Vetor: [ ");

        for (int i = 0; i < capacidade; i++) {
            if (i < size) {
                System.out.print(a[i]);
            } else {
                System.out.print("-");
            }
            if (i < capacidade - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
}
