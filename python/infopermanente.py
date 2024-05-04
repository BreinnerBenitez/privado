import pickle

class Persona:
    def __init__(self,nombre,genero,edad):
        self.nombre=nombre
        self.genero=genero
        self.edad=edad
        
        print("se ha creado una persona nueva con el nombre de ",self.nombre)
        
    def __str__(self):
        return "{}{}{}".format(self.nombre,self.genero,self.edad)
    
class ListaPersonas:
    personas=[]
    
    def __init__(self):
       
        try:
            listadepersonas=open("ficheroExterno","ab+")
            listadepersonas.seek(0)
            self.personas=pickle.load(listadepersonas)
            print("se cargaron {} personas del fichero externo".format(len(self.personas)))
        except:
            print("el fichero esta vacio")
        finally:
            listadepersonas.close()
            del(listadepersonas)
            
    def agregarPersonas(self,p):
        self.personas.append(p)
        self.guardarPersonasFicheroExterno()
    def mostarPersonas(self):
        for i in self.personas:
            print (i)
    def guardarPersonasFicheroExterno(self):
        listapersonas=open("ficheroExterno","wb")
        pickle.dump(self.personas,listapersonas)
        listapersonas.close()
        del(listapersonas)
    def mostrarinfofichero (self):
        
        print("la informacion del fichero externo es la siguiente")
        
        for i in self.personas:
            print(i)
            
                 

milista=ListaPersonas()

p=Persona(" ana "," femenino ",25)
milista.agregarPersonas(p)
milista.mostarPersonas()
"""
j=Persona(" jhon "," maculino ",25)
milista.agregarPersonas(j)
a=Persona(" ana "," femenino ",25)
milista.agregarPersonas(a)

milista.mostarPersonas()
"""
