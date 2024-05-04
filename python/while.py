import math
"""
i=1 

while(i <=10):
    print("ejecucion: "+str(i))
    i+=1
print("termino el programa")
"""
"""
edad=int(input("introde la edad: ")) 

while edad<0:
    print("has introducido la edad negativa, intentalo de buevo")
    edad=int(input("introde la edad: ")) 

print("edad positiva")
print("edad positiva gracias por participar: "+str(edad))
"""
'''
print("programa para hallar raiz cuadrada 2 intentos")
numero=int(input("ingrese numero porfavor: "))
intentos=0

while numero<0:
    print("ingreso numero negativo")
    if numero<0:
       intentos+=1
    
    if intentos==2:
        print("se acabaron las oportunidades")
        break;
    
    numero=int(input("ingrese numero porfavor: "))    
if intentos<2: 
    solucion=math.sqrt(numero)
    print("la raiz cuadrada del numero ingresado es  "+str(solucion)) 
''' 
"""
#ejercicio1

print("progroma que pide numeros infinitamente")
numero=0
anterior=0
    
while anterior<=numero:
      anterior=numero
      numero=int(input("introduzca numero: "))

print("introdujo un numero menor al anterior")
"""
#ejercicio 2
"""
print ("programa que pide numero y los sumas")
numero = int(input("digite numero positivo: "))
sumando=0
while numero>0:
     sumando+=numero
     numero = int(input("digite numero positivo: "))
if numero<0 and sumando==0:
    
    print("introdujo un numero negativo fin de programa ")
else:
    print("la suma de todos los numeros positivos es: "+str(sumando))
"""
"""
for i in "python":
    
    if i=="h":
        continue
    print("letra: "+i)
"""

email =input("introduzca tu email, por favor: ")
for i in email:
    
    if i=="@":
        arroba=True
        break;
    
else:
    
    arroba=False

print(arroba)



    