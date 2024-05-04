#ejercicio uno breinner 
"""""
print("primer ejercicio")
num1=int (input( "ingrese numero 1: "))
num2=int (input( "ingrese numero 2: "))

def DevuelveMax(numero1,numero2):
    if numero1>numero2:
        print("numero mayor: "+str(numero1))
    elif numero2>numero1:
        print("numero mayor: "+str(numero2))
    else:
        print("los numeros son iguales")
        
        
DevuelveMax(num1,num2)        

print("fin del programa")
"""

#ejericio 2
"""
nombre =input("ingrese nombre")
apellido=input("ingrese apellido")
Direccion=input("ingrese direccion")
telefono=input(" ingrese telefono")

lista_Datos=[nombre,apellido,Direccion,telefono]

print("los datos personales son:"+lista_Datos[0]+" "+lista_Datos[1]+" "+lista_Datos[3])
"""
#ejericio 3

numero1=int(input("ingresar primer numero "))
numero2=int(input("ingresar segundo numero "))
numero3=int(input("ingresar tercer  numero "))

media=(numero1+numero2+numero3)/3

print("la media es "+str(media))
