fun main(){
    var numero = 0
    var digito = 0
    numero = generarNumeross("Introduzac un numero de hasta 5 digitos:")
    digito = calcularNumeroDigitos(numero)
    if(digito == 1){
        println(unDigito(numero))
    }else{
        if(digito == 2){
            println(dosDigitos(numero))
        }else{
            if(digito == 3){
                println(tresDigitos(numero))
            }else{
                if(digito == 4){
                    println(cuatroDigitos(numero))
                }else{
                    println(cincoDigitos(numero))
                }
            }
        }
    }

}
fun calcularNumeroDigitos(num: Int): Int{
    var numero = num
    var digitos = 0
    while( numero >= 1){
        numero = numero / 10
        digitos = digitos+ 1
    }
    return digitos
}
fun generarNumeross(mensaje: String): Int{
    println(mensaje)
    var digitos = 0
    var numero = 0
    do{
        numero = readln().toInt()
        digitos = calcularNumeroDigitos(numero)
        if(digitos > 5){
            println("El numero introducido tiene más de 5 dígtos, vuelva a introducirlo:")
        }
    }while(digitos > 5)
    return numero

}
fun unDigito(numeros: Int): String{
    var numero = numeros
    var digitos = calcularNumeroDigitos(numero)
    var devolver = ""

    if(digitos == 1) {
        if (numero == 1) {
            devolver = "uno"
        }
        if (numero == 2) {
            devolver = "dos"
        }
        if (numero == 3) {
            devolver = "tres"
        }
        if (numero == 4) {
            devolver = "cuatro"
        }
        if (numero == 5) {
            devolver = "cinco"
        }
        if (numero == 6) {
            devolver = "seis"
        }
        if (numero == 7) {
            devolver = "siete"
        }
        if (numero == 8) {
            devolver = "ocho"
        }
        if (numero == 9) {
            devolver = "nueve"
        }
    }
    return "Su numero escrito es: $devolver."
}
fun dosDigitos(numeros : Int): String{
    var numero = numeros
    var devolver = ""
    if (numero >= 10 && numero < 20) {
        if (numero == 11) {
            devolver = "once"
        }
        if (numero == 12) {
            devolver = "doce"
        }
        if (numero == 13) {
            devolver = "trece"
        }
        if (numero == 14) {
            devolver = "catorce"
        }
        if (numero == 15) {
            devolver = "quince"
        }
        if (numero == 16) {
            devolver = "dieciseis"
        }
        if (numero == 17) {
            devolver = "diecisiete"
        }
        if (numero == 18) {
            devolver = "dieciocho"
        }
        if (numero == 19) {
            devolver = "diecinueve"
        }
    }
    return devolver
}
fun tresDigitos(numers: Int): String{
    var numero = numers
    var devolver = ""
    if (numero >= 100 && numero < 200) {
        devolver = "ciento ${dosDigitos((numero - 100))}"
    }
    return devolver
}
fun cuatroDigitos(numers: Int): String{
    var numero = numers
    var devolver = ""
    if (numero >= 1000 && numero < 2000) {
        devolver = "mil ${tresDigitos((numero - 1000))} "
    }
    return devolver
}
fun cincoDigitos(numers: Int): String{
    var numero = numers
    var devolver = ""
    if (numero >= 10000 && numero < 20000) {
        devolver = "${dosDigitos((numero / 1000 ).toInt())} ${cuatroDigitos((numero - 10000))} "
    }
    return devolver
}