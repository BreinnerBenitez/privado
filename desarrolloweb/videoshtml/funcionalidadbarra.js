
var mivideo;
var reproducir;
var progreso;
var  barra;
var maximo=600;
function comenzar(){
   
   
    mivideo=document.getElementById("mivideo");

    reproducir=document.getElementById("reproducir");

     barra=document.getElementById("barra");

     progreso=document.getElementById("progreso");


     reproducir.addEventListener("click",clicleando,false);

    barra.addEventListener("click",adelantando,false);



}


function clicleando(){

if( (mivideo.paused==false) && (mivideo.ended==false)){

        mivideo.pause();
        reproducir.innerHTML="play";

} else{

        mivideo.play();
        reproducir.innerHTML="pasue";

        bucle=setInterval(corriendo,30);
}

}



function corriendo(){

if(mivideo.ended==false){

    var total=parseInt(mivideo.currentTime*maximo/mivideo.duration);
    progreso.style.width=total+"px";


}


}

function adelantando(event){


if( (mivideo.paused==false) && (mivideo.ended==false)){

     var ratonx=event.pageX-barra.offsetLeft;

     var nuevoTiempo=ratonx*mivideo.duration/maximo;

     mivideo.currentTime=nuevoTiempo;

     progreso.style.width=ratonx+"px"

}

}


window.addEventListener("load",comenzar,false);