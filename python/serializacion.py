import pickle
"""
lista_nombre=["pedro","juan","breinner"]
fichero_binario=open("lista_nombre","wb")
pickle.dump(lista_nombre,fichero_binario)
fichero_binario.close()
"""
fichero=open("lista_nombre","rb")
lista=pickle.load(fichero)
print(lista)