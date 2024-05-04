from tkinter import *
from tkinter import messagebox
import sqlite3
# funciones

def conexionbasedatos():
    try:
       miconexion =sqlite3.connect("Usuario")
       micursor=miconexion.cursor()
       micursor.execute('''
                 CREATE TABLE DATOSUSUARIOS(
                  ID INTEGER PRIMARY KEY AUTOINCREMENT,
                  NOMBRE_USUARIO VARCHAR (50),
                  PASSWORD VARCHAR(50),
                  APELLIDO VARCHAR(50),
                  DIRECCION VARCHAR(50),
                  COMENTARIOS  VARCHAR(100) 
                 )    
                     ''')
    
       messagebox.showinfo("BBDD","BBDD creada con exito")
    except:
        messagebox.showinfo("Atencion!!!", "la base de datos ya existe")
        
def salirapp():
      valor=messagebox.askquestion("pregunta","deseas salir de la aplicacion")
      if valor=="yes":
        root.destroy()   
def borrarcampos():
    miid.set("")
    minombre.set("")
    miapellido.set("")
    mipass.set("")
    midireccion.set("")
    textocomentario.delete(1.0,END)
    
def crear():
    miconexion=sqlite3.connect("Usuario")
    micursor=miconexion.cursor()
    #micursor.execute("INSERT INTO DATOSUSUARIOS VALUES(NULL,'"+minombre.get() +
    #"','"+mipass.get()+"' ,'"+miapellido.get()+"','"+midireccion.get()+"','"+textocomentario.get("1.0",END)+"')")
    datos=(minombre.get(),mipass.get(),miapellido.get(),midireccion.get(),textocomentario.get("1.0",END))
    micursor.execute("INSERT INTO DATOSUSUARIOS VALUES(NULL,?,?,?,?,?)",datos)
    miconexion.commit()
    messagebox.showinfo("Ingresro","registro ingresado con exito")
    
def leer():
    
      miconexion=sqlite3.connect("Usuario")
      micursor=miconexion.cursor()
      micursor.execute("SELECT * FROM DATOSUSUARIOS WHERE ID="+miid.get())
      elusuario=micursor.fetchall()
      
      for usuario in elusuario:
          miid.set(usuario[0])
          minombre.set(usuario[1])  
          mipass.set(usuario[2])
          miapellido.set(usuario[3])
          midireccion.set(usuario[4])
          textocomentario.insert(1.0,usuario[5])
      
      miconexion.commit()
     
def actulizar():
    miconexion=sqlite3.connect("Usuario")
    micursor=miconexion.cursor()
    #micursor.execute("UPDATE DATOSUSUARIOS SET NOMBRE_USUARIO='"+minombre.get()+"',PASSWORD='"+mipass.get()+"',APELLIDO='"
     #                ""+miapellido.get()+"',DIRECCION='"+midireccion.get()+"',COMENTARIOS='"+textocomentario.get("1.0",END)+"' WHERE ID="+miid.get())
     
    datos=(minombre.get(),mipass.get(),miapellido.get(),midireccion.get(),textocomentario.get("1.0",END))
    micursor.execute("UPDATE DATOSUSUARIOS SET NOMBRE_USUARIO=?,PASSWORD=?,APELLIDO=?,DIRECCION=?,COMENTARIOS=? "+
                     "WHERE ID="+miid.get(),datos)
    
    miconexion.commit()
    messagebox.showinfo("Ingresro","registro actualizado con exito")

def eliminar():
     miconexion=sqlite3.connect("Usuario")
     micursor=miconexion.cursor()
     micursor.execute("DELETE FROM DATOSUSUARIOS WHERE ID="+miid.get())
     miconexion.commit()
     messagebox.showinfo("BBDD","Registro borrado con exito")
     
def licencia():
    messagebox.showinfo("Licecnia","licencia GNU Benitez")
def acercade():
    messagebox.showinfo("acerca de ..","Gracias por probar la practica att: Breinner")
    
root=Tk()
#barra menu
barramenu=Menu(root)
root.config(menu=barramenu, width=300 ,height=300)
opcioenesmenuBBDD=Menu(barramenu,tearoff=0)
opcioenesmenuBBDD.add_command(label="Conectar" ,command=conexionbasedatos)
opcioenesmenuBBDD.add_command(label="Salir",command=salirapp)

opcioenesmenuBorrar=Menu(barramenu, tearoff=0)
opcioenesmenuBorrar.add_command(label="borrar campos", command=borrarcampos)

opcioenesmenuCRUD=Menu(barramenu, tearoff=0)
opcioenesmenuCRUD.add_command(label="crear",command=crear)
opcioenesmenuCRUD.add_command(label="Leer", command=leer)
opcioenesmenuCRUD.add_command(label="Actualizar", command=actulizar)
opcioenesmenuCRUD.add_command(label="Borrar",command=eliminar)



opcioenesmenuAYUDA=Menu(barramenu,tearoff=0)
opcioenesmenuAYUDA.add_command(label="Licencia",command=licencia)
opcioenesmenuAYUDA.add_command(label="acerca de",command=acercade)


barramenu.add_cascade(label="BBDD", menu=opcioenesmenuBBDD)
barramenu.add_cascade(label="BORRAR", menu=opcioenesmenuBorrar)
barramenu.add_cascade(label="CRUD", menu=opcioenesmenuCRUD)
barramenu.add_cascade(label="AYUDA", menu=opcioenesmenuAYUDA)

opcioenesmenuBBDD.add_cascade()


#=======COMIENZO DE CAMPOS=====
miframe=Frame(root)
miframe.pack()
#____ los label_____

idlabel=Label(miframe ,text="id")
idlabel.grid(row=0,column=0,sticky="e",padx=10,pady=10)


nombrelabel=Label(miframe ,text="nombre: ")
nombrelabel.grid(row=1,column=0,sticky="e",padx=10,pady=10)


passlabel=Label(miframe ,text="password: ")
passlabel.grid(row=2,column=0,sticky="e",padx=10,pady=10)

apellidolabel=Label(miframe ,text="apellido: ")
apellidolabel.grid(row=3,column=0,sticky="e",padx=10,pady=10)

direccionlabel=Label(miframe ,text="direccion: ")
direccionlabel.grid(row=4,column=0,sticky="e",padx=10,pady=10)

idlabel=Label(miframe ,text="comentarios: ")
idlabel.grid(row=5,column=0,sticky="e",padx=10,pady=10)



#los cuadro de texto
miid=StringVar()
minombre=StringVar()
miapellido=StringVar()
mipass=StringVar()
midireccion=StringVar()

cuadroID=Entry(miframe,textvariable=miid)
cuadroID.grid(row=0,column=1,padx=10,pady=10)
cuadroNombre=Entry(miframe,textvariable=minombre)
cuadroNombre.grid(row=1,column=1,padx=10,pady=10)
cuadropass=Entry(miframe,textvariable=mipass)
cuadropass.grid(row=2,column=1,padx=10,pady=10)
cuadropass.config(show="?")
cuadroapellido=Entry(miframe,textvariable=miapellido)
cuadroapellido.grid(row=3,column=1,padx=10,pady=10)

cuadrodireccion=Entry(miframe,textvariable=midireccion)
cuadrodireccion.grid(row=4,column=1,padx=10,pady=10)

textocomentario=Text(miframe, width=16, height=5)
textocomentario.grid(row=5,column=1,padx=10,pady=10)
scrollvert=Scrollbar(miframe,command=textocomentario.yview)
scrollvert.grid(row=5,column=2,sticky="nsew")
textocomentario.config(yscrollcommand=scrollvert.set)

#=============== los botones===============


miframe2 =Frame(root)
miframe2.pack()
botoncrear=Button(miframe2, text="Crear",command=crear)
botoncrear.grid(row=1,column=0, sticky="e",padx=10,pady=10,)
botonleer=Button(miframe2, text="leer",command=leer)
botonleer.grid(row=1,column=1, sticky="e",padx=10,pady=10)
botonactualizar=Button(miframe2, text="actualizar",command=actulizar)
botonactualizar.grid(row=1,column=2, sticky="e",padx=10,pady=10)
botonborrar=Button(miframe2, text="borrar",command=eliminar)
botonborrar.grid(row=1,column=3, sticky="e",padx=10,pady=10)




root.mainloop()

