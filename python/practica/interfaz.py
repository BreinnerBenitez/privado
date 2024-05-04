from tkinter import *
from tkinter import messagebox
root=Tk()

barramenu=Menu(root)
def infoadicional():
     messagebox.showinfo("Procesador de breinner", "Procesador de Texto version 2024") #mensaje de texto

def avisolicencia():
    messagebox.showwarning("licencia","licencia GNU")
root.config(menu=barramenu ,width=300,height=300)

def salirapp():
    evento=messagebox.askquestion("salir","cerra la aplicaicon?")
    if evento =="yes":
        root.destroy()
        

archivoMenu=Menu(barramenu ,tearoff=0 )
archivoMenu.add_command(label="Nuevo")
archivoMenu.add_command(label="guardar")
archivoMenu.add_command(label="guardar como")
archivoMenu.add_separator()
archivoMenu.add_command(label="cerrar")
archivoMenu.add_command(label="salir",command=salirapp)


archivoedicion=Menu(barramenu,tearoff=0)
archivoedicion.add_command(label="copiar")
archivoedicion.add_command(label="pegar" )
archivoedicion.add_command(label="cortar")




archivoherramientas=Menu(barramenu)


archivoAyuda=Menu(barramenu)
archivoAyuda.add_command(label="version", command=infoadicional)
archivoAyuda.add_command(label="licencia", command=avisolicencia)


barramenu.add_cascade(label="Archivo", menu=archivoMenu)
barramenu.add_cascade(label="Edicion", menu=archivoedicion)
barramenu.add_cascade(label="Herramientas", menu=archivoherramientas)
barramenu.add_cascade(label="Ayuda", menu=archivoAyuda)

root.mainloop()