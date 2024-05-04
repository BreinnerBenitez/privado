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

def calculo_comision(empleado):
    empleado.salario=empleado.salario*1.03
    return empleado

listaEmpleadosComision=map(calculo_comision,listaEmpleado)
for i in listaEmpleadosComision:
    print(i)