fun main(){
    var num1 = 0
    var num2 = 0
    do{
        println("Introduzca los valores de los numeros sobre los que calcularemos el combinatorio, el primer numero debera ser el mayor.")
        num1 = generarNume("Ahora introduza el primer valor:")
        num2 = generarNume("Ahora introduza el segundo valor:")
    }while(num1 < num2)
    println("El combinatoria de $num1 y $num2, es ${generarCombinatorio(num1, num2)}")
}
private fun factorizar(num: Int):Int {
    if(num > 0) {
        var res = num * factorizar(num - 1)
        return res
    } else{
        return 1
    }
}
fun generarNume(mensaje: String): Int{
    println(mensaje)
    var numero = 0
    do{
        numero = readln().toInt()
    }while(numero < 0)
    return numero
}
fun generarCombinatorio(num1: Int, num2: Int): Double{
    var res = 0.0
    res = (factorizar(num1)/(factorizar(num2)*factorizar(num1-num2))).toDouble()
    return res
}