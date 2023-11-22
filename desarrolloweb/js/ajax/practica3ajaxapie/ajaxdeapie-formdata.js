function comenzar(){

datos=document.getElementById("zonadatos");
 
var boton=document.getElementById("boton");
 
boton.addEventListener("click",enviardatos,false);


}

function enviardatos(){


    var el_nombre =document.getElementById("elnombre").value;
    var el_apellido =document.getElementById("elapellido").value;


    var datos =new FormData();

    datos.append("nombre",el_nombre);

    datos.append("apellido",el_apellido);

    var url="procesar.php";


    var solicitud= new XMLHttpRequest();
    
    solicitud.addEventListener("load",mostrar,false);
    solicitud.open("POST",url,true);
     solicitud.send(datos);


}



function mostrar(e){

datos.innerHTML= e.target.responseText;



}



window.addEventListener("load",comenzar,false);