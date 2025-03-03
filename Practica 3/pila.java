public class Pila {
    private long[] arreglo;
    private int top;
    private int n;

    public Pila(int n) {
        this.n = n;
        this.arreglo = new long[n];
        this.top = -1;
    }

    public void push(long e) {
        if (!isFull()) {
            arreglo[++top] = e;
        }
    }

    public long pop() {
        if (!isEmpty()) {
            return arreglo[top--];
        }
        return -1; 
    }

    public long peek() {
        if (!isEmpty()) {
            return arreglo[top];
        }
        return -1; 
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == n - 1;
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila(5);
        pila.push(1);
        pila.push(2);
        System.out.println(pila.pop()); // Output: 2
        System.out.println(pila.peek()); // Output: 1
    }
}
