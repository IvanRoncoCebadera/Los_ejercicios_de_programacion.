fun main(){
    var diaActual = 0
    var mesActual = 0
    var añoActual = 0
    var diaNacimiento = 0
    var mesNacimiento = 0
    var añoNacimiento = 0

    añoActual = generarAño("Introdúceme el año actual:")
    añoNacimiento = generarAño("Introdúceme el año en el que naciste:")
    mesActual = generarMes("Introduceme el mes(en número) actual:")
    mesNacimiento = generarMes("Introduceme el mes(en número) en el que naciste:")
    diaActual = generarDia("Introduce el dia actual:")
    diaNacimiento = generarDia("Introduce el dia en el que naciste:")
    var resultado = añoActual - añoNacimiento
    if(mesActual == mesNacimiento){
        if(diaActual < diaNacimiento){
            resultado = resultado - 1
        }
    }else{
        if(mesActual < mesNacimiento){
            resultado = resultado - 1
        }
    }
    println("Usted tiene $resultado años.")
}
fun generarAño(mensaje: String): Int{
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
fun generarMes(mensaje: String): Int{
    var res = 0
    do {
        var acierto = false
        println(mensaje)
        res = readln().toInt()
        if(res > 0 && res < 12){
            acierto = true
        } else{
            println("El número no puede ser negativo o ser superior a 12, intentelo de nuevo.")
        }
    }while(!acierto)
    return res
}
fun generarDia(mensaje: String): Int{
    var res = 0
    do {
        var acierto = false
        println(mensaje)
        res = readln().toInt()
        if(res > 0 && res < 30) {
            acierto = true
        } else {
            println("El número no puede ser negativo o ser superior a 30, intentelo de nuevo.")
        }
    }while(!acierto)
    return res
}

