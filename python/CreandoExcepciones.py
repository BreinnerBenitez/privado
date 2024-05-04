
import math
 
def calcularaiz(num1):
    if num1<0:
        raise ValueError ("El numero no pude ser negativo")

    else:
        rcuadrada=math.sqrt(num1)
        return  rcuadrada
    
op1=int(input("introduce un numero entero: "))
try:
    print(calcularaiz(op1))
     
except ValueError as numnegativo:
    print(numnegativo)
    
print("programa sigue")
"""
def calculaedad(edad):
        if edad<0:
             raise TypeError("no se permiten edades negativas") # errores personalizados
        if edad<20:
            return "eres muy joven"
        elif edad<40:
            return "eres adulto "
        elif edad<60:
             return "eres adulto mayor "

        
print(calculaedad(-18))
print("sigue programa")
"""