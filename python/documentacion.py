from modulos import funciones_matematicas

class areas:
    """esta clase nos ayuda con calcular area geometricas"""
    def aredeunrectangulo(base,altura):
        """ area de un rectangulo"""   
      
        return (f"base={base},altura ={altura} area="+str(base*altura))
    
print(areas.aredeunrectangulo(4,5))

print(areas.aredeunrectangulo.__doc__)

help(areas)
help(funciones_matematicas)
