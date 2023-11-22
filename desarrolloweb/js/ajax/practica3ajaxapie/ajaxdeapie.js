function comenzar(){

datos=document.getElementById("zonadatos");
 zonaprogreso=document.getElementById("zonaprogreso");
var boton=document.getElementById("boton");
 
boton.addEventListener("click",leer,false);


}

function leer(){

 var url="texto.txt";
 var url2="video.mp4";
 
 var solicitud= new XMLHttpRequest();

 solicitud.addEventListener("loadstart",comienza_barra,false);

 solicitud.addEventListener("progress",estadobarra,false);

 solicitud.addEventListener("load",mostrar,false);

 solicitud.open("GET",url,true);

 solicitud.send(null);



}

function comienza_barra(){

 datos.innerHTML="<progress value='0' max='100'> </progress>";

}


function estadobarra(e){


 var porcentaje=parseInt(e.loaded/e.total*100);

 var barraprogreso=datos.querySelector("progress");

 barraprogreso.value=porcentaje;

 zonaprogreso.innerHTML=porcentaje +"%";

}


function mostrar(e){

datos.innerHTML= e.target.responseText;



}



window.addEventListener("load",comenzar,false);