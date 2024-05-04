
""" 
arroba=0
punto=0
miemail=input("introduce direccion email")
for i in  miemail:
    if (i=="@"):
        arroba+=1
    if (i=="."):
        punto+=1
            
    
if (arroba==1 and punto==1):
    print("correo correcto")
else :
    print ("correo incorrecto") 
 
  """      
#for i in range(5,50,3):
 #    print(f"hola {i}")
valido=False
email=input("introduce tu correo")
for   i in range(len(email)):
    if (email[i]=="@"):
        valido=True

if valido:
    print("correcto")
else:
    print("incorrecto")