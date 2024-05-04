from tkinter import *

root =Tk()

miframe=Frame(root, width=500,height=400)
miframe.pack()
minombrelabel=Label(miframe, text="nombre",fg="red")#.place(x=0,y=100)
minombrelabel.grid(row="0",column="0")

minombretexto=Entry(miframe, text="Mi cuadro de texto",fg="red")#.place(x=0,y=50)
minombretexto.grid(row="0",column="1")


miapellidolabel=Label(miframe, text="apellido",fg="red")#.place(x=0,y=100)
miapellidolabel.grid(row="2",column="0")

miapellidotexto=Entry(miframe, text="Mi cuadro de texto",fg="red")#.place(x=0,y=50)
miapellidotexto.grid(row="2",column="1")



miapellidolabel=Label(miframe, text="direccion",fg="red")#.place(x=0,y=100)
miapellidolabel.grid(row="3",column="0")

minombretexto=Entry(miframe, text="Mi cuadro de texto",fg="red")#.place(x=0,y=50)
minombretexto.grid(row="3",column="1")
root.mainloop() 