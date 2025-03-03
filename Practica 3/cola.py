class Cola:
    def __init__(self, n):
        self.arreglo = [0] * n
        self.inicio = 0
        self.fin = -1
        self.n = n

    def insert(self, e):
        if not self.isFull():
            self.fin = (self.fin + 1) % self.n
            self.arreglo[self.fin] = e

    def remove(self):
        if not self.isEmpty():
            e = self.arreglo[self.inicio]
            self.inicio = (self.inicio + 1) % self.n
            return e

    def peek(self):
        if not self.isEmpty():
            return self.arreglo[self.inicio]

    def isEmpty(self):
        return self.inicio == (self.fin + 1) % self.n

    def isFull(self):
        return self.inicio == (self.fin + 2) % self.n

    def size(self):
        return (self.fin - self.inicio + 1 + self.n) % self.n


cola = Cola(5)
cola.insert(1)
cola.insert(2)
print(cola.remove()) 
print(cola.peek()) 
