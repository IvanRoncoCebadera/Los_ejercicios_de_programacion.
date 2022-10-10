fun main(){
    var numero = 0
    var resultado = 0
    println("Introduzca un valor y hare la suma de todos los numeros hasta ese:")
    numero = readln().toInt()
    resultado = generarResultadoSuma(numero)
    println("El resultado de la suma de los $numero primeros números es: $resultado")
}
fun generarResultadoSuma(numMax: Int): Int{
    var res = 0
    for (i in 0..numMax){
        res = res + i
    }
    return res
}