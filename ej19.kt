fun main (){
    var numero = 0
    var numeroReferencia = 0

    for(i in 1..10){
        numero = generarNumero("Introduzca un número, un total de 10 veces:")
        if(numero > numeroReferencia){
            numeroReferencia = numero
        }
    }
    println("De los 10 número entregados, el mayor es $numeroReferencia.")
}
fun generarNumero(mensaje: String): Int{
    var res = 0
    do {
        var acierto = false
        println(mensaje)
        res = readln().toInt()
        if(res > 0){
            acierto = true
        } else{
            println("El número no puede ser negativo, intentelo de nuevo.")
        }
    }while(!acierto)
    return res
}