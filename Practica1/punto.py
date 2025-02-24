import math

class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def coord_cartesianas(self):
        return self.x, self.y

    def coord_polares(self):
        radio = math.sqrt(self.x ** 2 + self.y ** 2)
        angulo = math.degrees(math.atan2(self.y, self.x))
        return radio, angulo

    def __str__(self):
        return "({:.2f},{:.2f})".format(self.x, self.y)

# Ejemplo de uso
p1 = Punto(0, 3)
print(p1)
x, y = p1.coord_cartesianas()
print(f'Coordenadas Cartesianas: {x}, {y}')
r, a = p1.coord_polares()
print(f'Coordenadas Polares: Radio = {r}, Ángulo = {a}')
