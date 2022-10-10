import kotlin.math.truncate

fun main(){
    var numero = generarnumero("Introduzca un número:")
    var digitosP = 0
    var digitosI = 0
    var digitos = calcularNumeroDigitos(numero.toFloat())
    println("El número $numero tiene $digitos.")

}
fun generarnumero(mensaje: String): Int{
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
fun calcularNumeroDigitos(num: Float): String {
    var numero = num
    var digitos = 0
    var digitosP = 0
    var digitosI = 0
    while( numero >= 1){
        numero = numero / 10
        digitos = digitos+ 1
        if(numero.toInt() % 2 == 0){
            digitosP++
        }else{
            digitosI++
        }
    }
    return ("$digitos digitos, $digitosP digitos pares y $digitosI digitos impares.")
}