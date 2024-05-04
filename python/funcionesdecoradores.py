def funciondecoradora(funcion_parametro):
    def funcionc(*agrs):
        #acciones adicionales
        print("vamos a realiar un calculo: ")

        funcion_parametro(*agrs)
        
        print("aciones que decoran ")
        
    return funcionc



@funciondecoradora
def suma(num1,num2):
    print(num1+num2)

def resta(num1,num2):
    print(num1-num2)
@funciondecoradora
def potencia(base,exponente):
    print(pow(base,exponente))
    
suma(10,20)
potencia(5,2)