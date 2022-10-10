fun main() {
    var numero = 0
    do {
        println("Introduzca un número y calcularé su factorial, no puede ser un número negativo.")
        numero = readln().toInt()
    }while(numero < 0)
    println(factorizar(numero))
}
private fun factorizar(num: Int):Int {
    if(num > 0) {
        var res = num * factorizar(num - 1)
        return res
    } else{
        return 1
    }
}


