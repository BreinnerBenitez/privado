import sqlite3

miconexion=sqlite3.connect("conexionbasedatos/basededatos")
micursor=miconexion.cursor()

#micursor.execute("CREATE TABLE PRODUCTOS(NOMBRE VARCAHR(50),PREICO INTEGER(10),SECCION VARCHAR(50))")
#micursor.execute("INSERT INTO PRODUCTOS VALUES(' JHON ',5000,'JUGUETERIA')")
"""
variosProdcutos=[("camiseta",10,"deportes"),
                 ("jarron",90,"ceramica"), 
                 ("juguete",20,"jugueteria")
                 
            ]

micursor.executemany("INSERT INTO PRODUCTOS VALUES(?,?,?)",variosProdcutos)
"""
milista=micursor.execute("select * from PRODUCTOS")

for i in milista:
    print("nombre: ",i[0],"articulo:",i[2])
    
miconexion.commit()




miconexion.close() 
