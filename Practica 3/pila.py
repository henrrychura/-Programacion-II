class Pila:
    def __init__(self, n):
        self.arreglo = [0] * n
        self.top = -1
        self.n = n

    def push(self, e):
        if not self.isFull():
            self.top += 1
            self.arreglo[self.top] = e

    def pop(self):
        if not self.isEmpty():
            e = self.arreglo[self.top]
            self.top -= 1
            return e

    def peek(self):
        if not self.isEmpty():
            return self.arreglo[self.top]

    def isEmpty(self):
        return self.top == -1

    def isFull(self):
        return self.top == self.n - 1

# Ejemplo de uso
pila = Pila(5)
pila.push(1)
pila.push(2)
print(pila.pop()) # Output: 2
print(pila.peek()) # Output: 1
