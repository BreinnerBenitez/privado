class Vehiculos():
    def __init__(self,marca,modelo):
        self.marca=marca
        self.modelo=modelo
        self.enmarcha=False
        self.acelera=False
        self.frena=False
    def arrancar(self):
        self.enmarcha=True
        
    def acelerar (self):
        self.acelera=True
    
    def frenar (self):
         self.frena=True
         
    def estado (self):
        print ("marca: ",self.marca,"\nmodelo: ",self.modelo,"\nenmarcha: ", self.enmarcha,
               "\nacelerando: ", self.acelera,"\nfrenando: ",self.frena)

class Moto(Vehiculos):
    hcaballito=""
    def __init__(self,marca,modelo,valor):
        super().__init__(marca,modelo)
        self.valor=valor
    
    def caballito(self):
        self.hcaballito="voy Haciendo el caballo"
    def estado (self):
        print ("marca: ",self.marca,"\nmodelo: ",self.modelo,"\nenmarcha: ", self.enmarcha,
             "\nacelerando: ", self.acelera,"\nfrenando: ",self.frena, "\n", self.hcaballito,"\nvalor:",self.valor)
        
class Furgoneta(Vehiculos):
    
    def carga(self,cargar):
        self.cargado=cargar
        if self.cargado:
            return "la furgoneta esta cargada"
        else :
            return "la furgoneta no esta cargada"
 
 
class VehiculosElectricos(Vehiculos):
    def __init__(self,marca,modelo):
        super().__init__(marca,modelo)
        self.autonomia=100
       
    def cargaenergia(self):
        self.cargando=True    
        
    
                  
mimoto= Moto("honda","CBR",200)
mimoto.caballito()
mimoto.estado()       
mifurgoneta=Furgoneta("chevrolet","kangot")
mifurgoneta.estado()
print(mifurgoneta.carga(True) ) 


class BiciElectrica(VehiculosElectricos):
    pass

mibici=BiciElectrica("honda","c100") 
print(isinstance(mibici,Vehiculos))
