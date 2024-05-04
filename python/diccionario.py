midiccionario ={"alemania":"berlin","francia":"paris","reino unido":"londres","colombia":"bogota"}
midiccionario["italia"]="lisboa"
print(midiccionario)
midiccionario["italia"]="roma"
print(midiccionario)
del midiccionario["reino unido"]
print(midiccionario)
#diccionario 2

mituplae=("espana","francia","reino unido")
diccionario2={mituplae[0]:"madrid",mituplae[1]:"paris",mituplae[2]:"lonedres"}
print(diccionario2)
print(diccionario2[mituplae[1]])
# diccionario y clave:tuplas
midiccionario3={23:"jordan","nombre":"michael","equipo":"Chicago","anillos":[1991,1992,1993,1996,1997,1998]}
print(midiccionario3["anillos"])
# diccionario dentro de otro diccionario
midiccionario3={23:"jordan","nombre":"michael","equipo":"Chicago","anillos":{"temporadas":[1991,1992,1993,1996,1997,1998 ]}}
print(midiccionario3["anillos"])
print(midiccionario3.keys()) #me da las claves
print(midiccionario3.values()) #me da los valores
print(len(midiccionario3)) #me da la longitud del diccionario