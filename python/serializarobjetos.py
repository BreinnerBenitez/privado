import pickle

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
        
coche1=Vehiculos("mazda","mazda3")
coche2=Vehiculos("bmw","1")
coche3=Vehiculos("ferrari","2")
"""
coche=[coche2,coche2,coche3]
fichero=open("loscoches","wb")
pickle.dump(coche,fichero)
fichero.close()
del(fichero)
"""

coches=open("loscoches","rb")
lista=pickle.load(coches)

coches.close()

for i in lista:
    print(i.estado())



