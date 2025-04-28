import tkinter as tk
from tkinter import ttk
from abc import ABC, abstractmethod
import random
import math


class Coloreado(ABC):
    @abstractmethod
    def comoColorear(self):
        pass


class Figura(ABC):
    def __init__(self, color):
        self.color = color

    def setColor(self, color):
        self.color = color

    def getColor(self):
        return self.color

    def __str__(self):
        return f"Color: {self.color}"

    @abstractmethod
    def area(self):
        pass

    @abstractmethod
    def perimetro(self):
        pass


class Cuadrado(Figura, Coloreado):
    def __init__(self, color, lado):
        super().__init__(color)
        self.lado = lado

    def area(self):
        return self.lado ** 2

    def perimetro(self):
        return 4 * self.lado

    def comoColorear(self):
        return "Colorear los cuatro lados"

# Clase Circulo
class Circulo(Figura):
    def __init__(self, color, radio):
        super().__init__(color)
        self.radio = radio

    def area(self):
        return math.pi * self.radio ** 2

    def perimetro(self):
        return 2 * math.pi * self.radio


def generar_figuras():
    figuras = []
    colores = ["Rojo", "Azul", "Verde", "Amarillo", "Morado"]

    for _ in range(5):  
        tipo = random.randint(1, 2)  
        color = random.choice(colores)

        if tipo == 1:
            lado = random.uniform(1.0, 10.0)
            figuras.append(Cuadrado(color, lado))
        elif tipo == 2:
            radio = random.uniform(1.0, 10.0)
            figuras.append(Circulo(color, radio))

    return figuras

def mostrar_figuras():
    figuras = generar_figuras()
    resultado.delete(1.0, tk.END)  

    for figura in figuras:
        resultado.insert(tk.END, f"{figura}\n")
        resultado.insert(tk.END, f"Área: {figura.area():.2f}\n")
        resultado.insert(tk.END, f"Perímetro: {figura.perimetro():.2f}\n")
        if isinstance(figura, Coloreado):
            resultado.insert(tk.END, f"Cómo colorear: {figura.comoColorear()}\n")
        resultado.insert(tk.END, "\n")


ventana = tk.Tk()
ventana.title("Objetos Coloreados - Figuras")


etiqueta = tk.Label(ventana, text="Haz clic en el botón para generar 5 figuras aleatorias")
etiqueta.pack(pady=10)


boton_generar = tk.Button(ventana, text="Generar Figuras", command=mostrar_figuras)
boton_generar.pack(pady=10)


resultado = tk.Text(ventana, height=15, width=50)
resultado.pack(pady=10)


boton_salir = tk.Button(ventana, text="Salir", command=ventana.destroy)
boton_salir.pack(pady=10)

ventana.mainloop()
