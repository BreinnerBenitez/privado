
"""
salario_presidente=int(input("introduce salario presidente: "))
print("salario presidente "+str(salario_presidente))

salario_director=int(input("introduce salario director: "))
print("salario director "+str(salario_director))

salario_jefe_area=int(input("introduce salario jefe area: "))
print("salario Jefe Area "+str(salario_jefe_area))

salario_administrativo=int(input("introduce salario administrativo: "))
print("salario administrativo "+str(salario_administrativo))

if  salario_administrativo < salario_jefe_area < salario_director < salario_presidente:
    print("toda funciona correctamente")
else:
    print("algo falla en esta empresa")
"""
"""
print("programa de becas año 2024")
distancia_escuela=int(input("introduce distancia a la escuela en km"))
print(distancia_escuela)

numero_hermanos=int(input("introduce numero de hermanos"))
print(numero_hermanos)

salario_familiar=int(input("introduce salario anual bruto"))
print(salario_familiar)

if distancia_escuela>40 and numero_hermanos>2 or salario_familiar<=20000:
    
    print("tienes derecho a beca")
else:
    print("no tienes derecho a beca")
"""
print("asignaturas año 2024")
print("informatica grafica - prueba de software- usabilidad y accesibilidad")
opcion=input("escribe la asginatura escogida: ")

asignatura=opcion.lower()  #cadena de caracteres convertidas en minusculas y upper() en mayusculas
                        
if asignatura in ("informatica grafica","prueba de software", "usabilidad y accesibilidad"):
    
    print("asignatura elegida: "+asignatura)
else:
    print("no escogio asignatura correcta")