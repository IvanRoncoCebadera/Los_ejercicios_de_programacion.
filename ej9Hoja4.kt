fun main() {
    var numero = 0.0
    var num = 0.0
    println("Introduce un numero y te dare su raiz cuadrada.")
    numero = readln().toDouble()
    num = raiz(numero)
    println("La raiz de $numero es $num.")
}
fun raiz(num: Double): Double{
    var resultado = 0.0
    resultado = num
    var numero = 0.0
    var num = 0.0
    num = resultado
    while(resultado != numero){
        numero = resultado
        resultado = (num/resultado + resultado)/2
    }
    return resultado
}