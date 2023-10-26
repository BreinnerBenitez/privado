


function ejecuta(){

/*for(var i=0;i<3;i++){
   
    document.getElementsByTagName("p")[i].onclick=saludo;

} */

//

//document.getElementById("importante").onclick=saludo;

// 


/*for(var i=0;i<3;i++){
document.getElementsByClassName("importante")[i].onclick=saludo;
}*/


/*document.querySelector("#principal p").onclick=saludo;*/

var elementos= document.querySelectorAll("#principal p, .sisas");

for(var i=0;i<elementos.length;i++){ 

elementos[i].onclick=saludo;


}

}

function saludo(){
    alert("hola que hay de nuevo");
}

window.onload=ejecuta;



