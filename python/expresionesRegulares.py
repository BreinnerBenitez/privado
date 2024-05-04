import re
"""
cadena="vamos a ser buenos desarrolladores"
cadena2="python es python hermano"
#print(re.search("desarrolladores",cadena))

textobuscar="aprendefgdgdgfs"
if re.search(textobuscar,cadena) is not None:
    print("encontre el texto")
else:
    print("no he encontrado el texto")
    
textobuscar="buenos"
textobuscar2="python"
textoencontrado=re.search(textobuscar,cadena)
print(textoencontrado.start())#donde inicia lo buscado
print(textoencontrado.end()) #donde termina
print(textoencontrado.span()) #donde inicia y comienza 
print(len(re.findall(textobuscar2,cadena2)))
"""
"""
lista_nombres=["ana Gomez","maria martin","sandra lopez","santiago martin","sandra fernandez"]

for i in lista_nombres:
    if re.findall("martin$",i):
        print(i)
 """
 
nombre1="breinner benitez"
nombre2="ana holguin"
nombre="alberto benitez"

if re.search("breinner",nombre1,re.IGNORECASE):
    print("hemos encontra el nombre")
else:
    print("no lo hemos encontrado")       

