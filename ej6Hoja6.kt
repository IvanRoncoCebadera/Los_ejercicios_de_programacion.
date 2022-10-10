fun main(){
    var presionAtmosferica = "".toString()
    var humedadRelativa = "".toString()
    presionAtmosferica = generarPresion("Introduzca un valor de presión para el día de mañana, puede ser alta, media o baja.")
    humedadRelativa = generarHumedad("Introduzca un valor de humedad para el día de mañana, puede ser alta, media o baja.")
    println("La probabilidad de lluvia es ${generarProbLluvia(presionAtmosferica, humedadRelativa)}, la probabilidad de sol es ${generarProbSol(presionAtmosferica, humedadRelativa)} y la probabilidad frio es ${generarProbFrio(presionAtmosferica, humedadRelativa)}.")

}
fun generarPresion(mensaje: String): String{
    var presion = ""
    do {
        println(mensaje)
        presion = readln().toString()
        if(presion != "alta" && presion != "media" && presion != "baja"){
            println("El texto introducido no es valido, pruebe de nuevo con las opciones propuestas anteriormente.")
        }
    }while(presion != "alta" && presion != "media" && presion != "baja")
    return presion
}
fun generarHumedad(mensaje: String): String{
    var humedad = ""
    do {
        println(mensaje)
        humedad = readln().toString()
        if(humedad != "alta" && humedad != "media" && humedad != "baja"){
            println("El texto introducido no es valido, pruebe de nuevo con las opciones propuestas anteriormente.")
        }
    }while(humedad != "alta" && humedad != "media" && humedad != "baja")
    return humedad
}
fun generarProbLluvia(presion: String, humedad: String): String {
    var mensaje = ""
    if(presion == "baja" && humedad == "alta"){
        mensaje = "muy alta"
    }else{
        if(presion == "baja" && humedad == "media"){
            mensaje = "alta"
        }else{
            if(presion == "baja" && humedad == "baja"){
                mensaje = "media"
            }else{
                if(presion == "media" && humedad == "media"){
                    mensaje = "media"
                }else{
                    mensaje = "baja"
                }
            }
        }
    }
    return mensaje
}
fun generarProbSol(presion: String, humedad: String): String {
    var mensaje = ""
    if(presion == "baja" && humedad == "alta"){
        mensaje = "baja"
    }else{
        if(presion == "baja" && humedad == "media"){
            mensaje = "media"
        }else{
            if(presion == "baja" && humedad == "baja"){
                mensaje = "media"
            }else{
                if(presion == "media" && humedad == "media"){
                    mensaje = "media"
                }else{
                    mensaje = "alta"
                }
            }
        }
    }
    return mensaje
}
fun generarProbFrio(presion: String, humedad: String): String {
    var mensaje = ""
    if(presion == "baja" && humedad == "alta"){
        mensaje = "alta"
    }else{
        if(presion == "baja" && humedad == "media"){
            mensaje = "alta"
        }else{
            if(presion == "baja" && humedad == "baja"){
                mensaje = "alta"
            }else{
                if(presion == "media" && humedad == "media"){
                    mensaje = "media"
                }else{
                    mensaje = "baja"
                }
            }
        }
    }
    return mensaje
}