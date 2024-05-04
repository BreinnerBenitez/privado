# Tuplas listas inmutables, permite extrar porciones

mituplas=("j","h","o")
milista=list(mituplas) #convierte una tupla en lista
mitupla2=tuple(milista) #convierte una lista en tuple
print(mitupla2[:])
print("j" in mitupla2) 
print (mitupla2.count("j")) #cuenta cuantas j en la tupla
print(len(mitupla2)) #metodo len, cuantos elementos hay en la tupla
print (mitupla2.index("h")) # devuelve el inidice de la primera aparicion

for i in mitupla2:
    print(i)