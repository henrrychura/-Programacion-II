import tkinter as tk
from tkinter import ttk
from abc import ABC, abstractmethod


class Boleto(ABC):
    def __init__(self, numero):
        self.numero = numero

    @abstractmethod
    def get_precio(self):
        pass

    def __str__(self):
        return f"Número: {self.numero}, Precio: {self.get_precio():.2f}"


class Palco(Boleto):
    def __init__(self, numero):
        super().__init__(numero)

    def get_precio(self):
        return 100.00

class Platea(Boleto):
    def __init__(self, numero, dias_anticipacion):
        super().__init__(numero)
        self.dias_anticipacion = dias_anticipacion

    def get_precio(self):
        return 50.00 if self.dias_anticipacion >= 10 else 60.00

class Galeria(Boleto):
    def __init__(self, numero, dias_anticipacion):
        super().__init__(numero)
        self.dias_anticipacion = dias_anticipacion

    def get_precio(self):
        return 25.00 if self.dias_anticipacion >= 10 else 30.00


def vender_boleto():
    numero = int(entrada_numero.get())
    tipo = tipo_boleto.get()
    dias = entrada_dias.get()
    dias_anticipacion = int(dias) if dias else 0

    if tipo == "Palco":
        boleto = Palco(numero)
    elif tipo == "Platea":
        boleto = Platea(numero, dias_anticipacion)
    elif tipo == "Galería":
        boleto = Galeria(numero, dias_anticipacion)
    else:
        etiqueta_info.config(text="Por favor, selecciona un tipo válido.")
        return

    etiqueta_info.config(text=str(boleto))


def salir():
    ventana.destroy()


ventana = tk.Tk()
ventana.title("Teatro Municipal - Venta de Boletos")


tk.Label(ventana, text="Número de Boleto:").grid(row=0, column=0, padx=10, pady=5)
entrada_numero = tk.Entry(ventana)
entrada_numero.grid(row=0, column=1, padx=10, pady=5)

tk.Label(ventana, text="Cantidad de Días para el Evento:").grid(row=1, column=0, padx=10, pady=5)
entrada_dias = tk.Entry(ventana)
entrada_dias.grid(row=1, column=1, padx=10, pady=5)

tk.Label(ventana, text="Tipo de Boleto:").grid(row=2, column=0, padx=10, pady=5)
tipo_boleto = ttk.Combobox(ventana, values=["Palco", "Platea", "Galería"])
tipo_boleto.set("Selecciona un tipo")
tipo_boleto.grid(row=2, column=1, padx=10, pady=5)


boton_vender = tk.Button(ventana, text="Vender", command=vender_boleto)
boton_vender.grid(row=3, column=0, padx=10, pady=10)

boton_salir = tk.Button(ventana, text="Salir", command=salir)
boton_salir.grid(row=3, column=1, padx=10, pady=10)


etiqueta_info = tk.Label(ventana, text="Información del boleto aparecerá aquí.")
etiqueta_info.grid(row=4, column=0, columnspan=2, padx=10, pady=10)

ventana.mainloop()
