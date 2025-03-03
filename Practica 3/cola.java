public class Cola {
    private long[] arreglo;
    private int inicio;
    private int fin;
    private int n;

    public Cola(int n) {
        this.n = n;
        this.arreglo = new long[n];
        this.inicio = 0;
        this.fin = -1;
    }

    public void insert(long e) {
        if (!isFull()) {
            fin = (fin + 1) % n;
            arreglo[fin] = e;
        }
    }

    public long remove() {
        if (!isEmpty()) {
            long e = arreglo[inicio];
            inicio = (inicio + 1) % n;
            return e;
        }
        return -1; 
    }

    public long peek() {
        if (!isEmpty()) {
            return arreglo[inicio];
        }
        return -1; 
    }

    public boolean isEmpty() {
        return inicio == (fin + 1) % n;
    }

    public boolean isFull() {
        return inicio == (fin + 2) % n;
    }

    public int size() {
        return (fin - inicio + 1 + n) % n;
    }
}


public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola(5);
        cola.insert(1);
        cola.insert(2);
        System.out.println(cola.remove()); 
        System.out.println(cola.peek());  
    
}
