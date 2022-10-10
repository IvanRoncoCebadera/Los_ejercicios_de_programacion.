fun main(){
    var numero = 0
    var numero2 = 0
    println("Introduce un valor y uno para dividir a primero, no puede ser más grande el primero.")
    numero = readln().toInt()
    numero2 = readln().toInt()
    println("El resto y el coeficiente son: ${generarDivision(numero, numero2)} respectivamente.")
}

fun generarDivision(num: Int, divisor:Int): String{
    var resto = num
    var coeficiente = 0
    do{
        resto = resto - divisor
        coeficiente = coeficiente + 1
    }while(resto >= divisor)
    return "$resto y $coeficiente"
}