
def suma(num1, num2):
	return num1+num2

def resta(num1, num2):
	return num1-num2

def multiplica(num1, num2):
	return num1*num2


def divide(num1, num2):        
    try:    
        return num1 / num2
    except ZeroDivisionError:
        print("No se puede dividir entre cero")    
        return "Operación errónea"
   # finally:
        print("esperando")
while True:
    try:
    
        op1=(int(input("Introduce el primer numero: ")))
        op2=(int(input("Introduce el segundo numero:")))
        break;
    except ValueError:
        print("no son correctos los valores introducidos")
        
operacion=input("Introduce la operaciun a realizar (suma,resta,multiplica,divide): ")

if operacion=="suma":
	print(suma(op1,op2))

elif operacion=="resta":
	print(resta(op1,op2))

elif operacion=="multiplica":
	print(multiplica(op1,op2))

elif operacion=="divide":
	print(divide(op1,op2))

else:
	print ("Operaciun no contemplada")


print("Operacion ejecutada. Continuacion de ejecicio  del programa ")

