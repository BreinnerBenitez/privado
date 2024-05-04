import traceback
class coche():
    
    def __init__(self):
         
         self.__largoChasis=250
         self.__anchochasis=120
         self.__ruedas=4
         self.__enmarcha=False
    
    def arrancar(self,arrancamos):
        self.__enmarcha=arrancamos
        if self.__enmarcha:
            chequeo = self.__chequeo_interno()
            
        if  self.__enmarcha and chequeo:
            print("el coche esta en marcha")
        elif self.__enmarcha and chequeo ==False:
             print ("algo  mal en el chequeo no podemos arrancar")    
        else:
            print("el coche esta parado") 
            
        
        self.enmarcha=True
    
    def getruedas(self):
        return  self.__ruedas
    
    def getLargochasis(self):
        return self.__largoChasis
    def  setruedas(self,ruedas):
        self.__ruedas=ruedas
    
    def estado(self):
        print("El coche tiene",self.__ruedas,"ruedas un ancho de ",self.__anchochasis,"y un largo de ",self.__largoChasis)
    def __chequeo_interno(self):
        print ("realizando chequeo interno")
        self.gasolina="ok"
        self.aceite="mal"
        self.puertas="cerradas"
        if self.gasolina=="ok" and self.aceite=="ok" and self.puertas=="cerradas":
            return True
        else:
            return False
micoche=coche()
micoche.arrancar(True)    
print(f"el largo del coche es {micoche.getLargochasis()} ")
print("las ruedas son ",micoche.getruedas()," si señor")
print(micoche.estado())
print("-------------cuantinuacion de siguente objeto-----------------")
micoche2=coche()
micoche2.arrancar(False)
print(f"el largo del coche es {micoche2.getLargochasis()} ")
print("las ruedas son ",micoche2.getruedas()," si señor")


micoche2.setruedas(2)
micoche2.estado()
