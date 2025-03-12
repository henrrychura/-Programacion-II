from multimethod import multimethod
import math

class FiguraGeometrica:

    @multimethod
    def area(self, radio: float):
        return math.pi * radio * radio

    @multimethod
    def area(self, base: float, altura: float):
        return base * altura

    @multimethod
    def area(self, base: float, altura: int):
        return 0.5 * base * altura

    @multimethod
    def area(self, base1: float, base2: float, altura: float):
        return 0.5 * (base1 + base2) * altura

    @multimethod
    def area(self, lado: int):
        return (3 * math.sqrt(3) / 2) * lado * lado


figura = FiguraGeometrica()
f1 = figura.area(5.0)
f2 = figura.area(2.0, 3.0)
f3 = figura.area(4.0, 6)
f4 = figura.area(4.0, 6.0, 8.0)
f5 = figura.area(7)

print("Circulo:", f1)  
print("Rectangulo:", f2) 
print("Triangulo:",f3) 
print("Trapecio:", f4)  
print("Hexagono:", f5)  