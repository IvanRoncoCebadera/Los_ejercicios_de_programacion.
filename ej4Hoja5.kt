fun main(){
    var numero = 0.0
    numero = generarNum("Introduzca un valor para el numero al cual cacularemos su raiza cuadrada, no puede ser negativo.")
    println("La raiza del numero introducudo es ${raiz(numero)}")
    /**
     *Para saber si un numero tiene decimales o no.
    var numer = 34.65
    var num = 0
    num = numer.toInt()
    var res = 0.0
    res = numer - num
    println(res)
     */
}
fun generarNum(mensaje: String): Double{
    println(mensaje)
    var numero = 0.0
    do{
        numero = readln().toDouble()
    }while(numero < 0)
    return numero
}
fun Raiz(num: Double): Double{
    var raiz = 0.0
    var temp = 0.0
    raiz = num
    while(raiz != temp){
        temp = raiz
        raiz = (num/raiz +raiz) / 2
    }
    return raiz
}
