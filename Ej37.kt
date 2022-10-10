fun main() {
    var aleatorio = 0
    var numero = 0
    var intentos = 0
    var vecesIntentadas = 0
    val intMaximos = 5
    var mensaje = ""
    val Min = 1
    val Max = 100
    do {
        vecesIntentadas = 0
        intentos = 0
        aleatorio = generarNumero(Min, Max).toInt()
            do {
                do {
                    println("Introduce un número entre 1 y 100 para intentar adivinar el número generado aleatoriamente entre 1 y 100, tienes 5 intentos en total.")
                    numero = readln().toInt()
                    if (numero < 0 || numero > 100) {
                        println("Te dije que el número debía estar entre 1 y 100. Vuelva a escribirlo:")
                    }
                }while (numero < 0 || numero > 100)
                vecesIntentadas = vecesIntentadas + 1
                if (numero == aleatorio) {
                    intentos = 5
                    println("Felicidades has ganado, el número secreto era $aleatorio, el numero de intentos fue $vecesIntentadas.")
                } else {
                    intentos = intentos + 1
                    println("Has fallado, tu número de intentos es $vecesIntentadas.")
                    if(numero < aleatorio){
                        println("El número secreto está por encima del suyo.")
                    } else{
                        println("El número secreto está por debajo del suyo.")
                    }
                    if(intentos == intMaximos){
                        println("El número secreto era $aleatorio")
                    }
                }
            } while (intentos < intMaximos)
    }while(continuar("¿Desea continuar jugando?: (s/n)"))
}
fun generarNumero(numMin: Int, numMax: Int): Int{
        val numMin = 1
        val numMax = 100
        return (numMin .. numMax).random()
}
fun continuar(mensaje: String): Boolean {
        println(mensaje)
        val respuesta = readln()
        return respuesta == "s" || respuesta == "S"
}