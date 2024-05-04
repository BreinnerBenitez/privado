from tkinter  import *

raiz = Tk()
raiz.title("ventana de prueba")
raiz.resizable(True,True)   # ancho y largo 
raiz.iconbitmap() 
raiz.geometry("650x650")
raiz.config(bg="red")
miframe=Frame()
miframe.pack() #me empaqueta el frame en la raiz
miframe.config(bg="blue")
miframe.config(width="650",height="350") 
raiz.mainloop()