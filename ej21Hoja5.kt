fun main(){
    var decimal = 0
    var binario = 0
    println("Introduce un numero decimal y lo pasare a binario.")
    decimal = readln().toInt()
    println("El numero $decimal decimal, en binario es: ${generarBinario(decimal)}")
    println("Introduce un numero binario y lo pasare a decimal.")
    binario = readln().toInt()
    println("El numero $binario binario, en bdecimal es: ${generarDecimal(binario)}")
}
fun generarBinario(num: Int): String {
    var numero = num
    var cadena = ""
    while(numero >= 2){
        var resto = numero
        while (resto > 1) {
            resto = resto - 2
        }
        cadena = "$resto $cadena"
        numero = numero / 2
    }
    cadena = "$numero $cadena"
    return "$cadena"
}
fun generarDecimal(num: Int): Int{
    var numero = num.toDouble()
    var contador = 0
    var res = 0.0
    var resultado = 0.0
    do{
        numero = numero / 10
        var nume = numero.toInt()
        var calculo:Double = numero - nume
        calculo = calculo * 10
        res = calculo * exponente(2, contador)
        resultado = resultado + res
        contador = contador + 1
    }while(numero > 0.2)
    return resultado.toInt()
}
fun exponente(num: Int, cont: Int): Int{
    var res = 1
    for(i in 1 ..cont){
       res = res * num
    }
    return res
}