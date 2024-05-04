"""def numero_par(num):
    if num % 2 ==0:
        return True
    
numero=[1,2,3,4,5,6,50]

print(list(filter(lambda numeropar:numeropar %2==0,numero)))

"""
class Empleado:
    def __init__(self,nombre,cargo,salario):
        
        self.nombre=nombre
        self.cargo=cargo
        self.salario=salario
    def __str__(self):
        return "{} que trabaja como {} tiene un salario de {}$".format(self.nombre,self.cargo,self.salario)
listaEmpleado=[
    
    Empleado("jhon","director",5000),
    Empleado("breinner","director",1000),
    Empleado("benitez","director",2000),
    Empleado("Guerrero","director",2000)
       
]
salarios_altos=filter(lambda Empleado:Empleado.salario>3000,listaEmpleado)

for i in salarios_altos:
    print(i)