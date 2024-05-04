#yield para  generadores
"""
def generaPares(limite):
    num=1
    milista =[]
    while num<limite:
        milista.append(num*2)
        num=num+1
    return milista    

lista=generaPares(10)
print(lista)
"""
"""
def generaPares(limite):
    num=1
    
    while num<limite:
        yield num*2
        num=num+1
       
devuelvepares=generaPares(10)

#for i in devuelvepares:
 #   print(i)

print(next(devuelvepares))
print("aqui podira ir mas codigos....")
print(next(devuelvepares))
print("aqui podira ir mas codigos....")
print(next(devuelvepares))
"""
"""
def devuelve__ciudades(*ciudades): #alamacenar un numero de elementos como tupla
    for elemento in ciudades:
        yield elemento
ciudades_devueltas=devuelve__ciudades("breinner",5,"guerrero")
print(next(ciudades_devueltas))

print("mas codigo")

print(next(ciudades_devueltas))
"""
def devuelve__ciudades(*ciudades): #alamacenar un numero de elementos como tupla
    for elemento in ciudades:
      # for subelemento in elemento:
            yield from  elemento 
            
ciudades_devueltas=devuelve__ciudades(["breinner","benitez"],(5,6),"guerrero")
print(next(ciudades_devueltas))

print("mas codigo")

print(next(ciudades_devueltas))
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))



