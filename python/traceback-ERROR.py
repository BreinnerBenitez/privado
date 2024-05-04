import traceback
def divide():
    try:
 
        op1=float(input("introduce el primer numero"))
        op2=float(input("introduce el segunfo numero"))
        print("la division es:"+str(op1/op2))
        
    except:
        print("has cometido un error")
        traceback.print_exc() # pila de error 
    finally:
        print("probando el finally")

print("calculo finalizdo")
divide()
print("el promgrama sigue")
