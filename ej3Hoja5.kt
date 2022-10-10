fun main(){
    var numero = 0
    println("Introduceme un valor para el numero:")
    numero = readln().toInt()
    println("El numero introducido es ${numeroPositivoNegativo(numero)}")
}
fun numeroPositivoNegativo(num: Int): String{
    var respuesta = ""
    if(num >= 0){
        respuesta = "positivo"
    }else{
        respuesta = "negativo"
    }
    return "$respuesta"
}