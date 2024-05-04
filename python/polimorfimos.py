class Coche():
    
    def desplazamiento(self):
        print("me desplazo utilizando cuatro ruedas")
        
class Moto():
    def desplazamiento(self):
        print("me desplazo utilizando dos ruedas")
class Camion():
    def desplazamiento(self):
        print("Me desplazamiento utilizando seis ruedas")
        
def desplazamientoVehi(vehiculo):
    vehiculo.desplazamiento()
    
    
mivehiculo=Camion()
desplazamientoVehi(mivehiculo)