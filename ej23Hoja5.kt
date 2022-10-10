fun main(){
    var numero = 0
    var numero2 = 0
    var res = 0.0
    var res2 = 0.0
    numero = generarNumeros("Introuduce un primer numero:")
    numero2 = generarNumeros("Introuduce un segundo numero:")
    res = sumaDigitos(numero)
    res2 = sumaDigitos(numero2)
    println("$res es el resultado de la suma de los digitos de $numero y $res2 es el resultado de la suma de los digitos de $numero2" )
    if(res > res2){
        println("La suma de los digitos de $numero es mayor que la de $numero2.")
    }else{
        println("La suma de los digitos de $numero2 es mayor que la de $numero.")
    }
}
fun generarNumeros(mensaje: String): Int{
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
fun sumaDigitos(num: Int): Double {
    var numero = num
    var res = 0
    do{
        res = res + (numero % 10)
        numero = numero / 10
    }while(numero != 0)
    return res.toDouble()
}