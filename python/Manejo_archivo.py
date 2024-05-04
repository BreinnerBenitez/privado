from io import open
"""
archivo_texto=open("archivo.txt","w")

frase="estupendo dia para estudiar python\n el lunes"

archivo_texto.write(frase)
archivo_texto.close()
"""
"""
archivo_text=open("archivo.txt","r")

leer = archivo_text.read() # o readlines para que me almacene en una lista

print(leer)

archivo_text.close()
"""
"""
archivo_text=open("archivo.txt","a")
archivo_text.write("\n otra linea hola mundo")
archivo_text.close
"""
#archivo_text=open("archivo.txt","r")

#print(archivo_text.read())
#archivo_text.seek(0) #posicion del cursor
#print(archivo_text.read(11))
#print(archivo_text.read())

archivo_text=open("archivo.txt","r+")


lista_texto=archivo_text.readlines()
lista_texto[2]= "gracias por todo Dios\n"
archivo_text.seek(0)
archivo_text.writelines(lista_texto)

archivo_text.close()