fun main(){
    var horas = 0
    var minutos = 0
    var segundos = 0
    horas = generarHoras("Introduzaca una hora:")
    minutos = generarMinutos("Introduzca un minuto:")
    segundos = generarSegundos("Introduzca un segundo:")
    println("La hora es: $horas:$minutos:$segundos")
    println("${calcularHora(horas, minutos, segundos)}")
}
fun generarHoras(mensaje: String): Int{
    println(mensaje)
    var hora = 0
    do{
        hora = readln().toInt()
        if(hora < 0||hora > 24){
            println("La hora introducida no es correcta, vuelve a introducirla:")
        }
    }while(hora < 0||hora > 24)
    return hora
}
fun generarMinutos(mensaje: String): Int{
    println(mensaje)
    var minuto = 0
    do{
        minuto = readln().toInt()
        if(minuto < 0||minuto > 60){
            println("El minuto introducido no es correcto, vuelve a introducirla:")
        }
    }while(minuto < 0||minuto > 60)
    return minuto
}
fun generarSegundos(mensaje: String): Int{
    println(mensaje)
    var segundo = 0
    do{
        segundo = readln().toInt()
        if(segundo < 0||segundo > 60){
            println("El segundo introducido no es correcto, vuelve a introducirla:")
        }
    }while(segundo < 0||segundo > 60)
    return segundo
}
fun calcularHora(horas: Int, minutos: Int, segundos: Int){
    var hora = horas
    var minuto = minutos
    var segundo = segundos
    var intentos = 0
    do{
        Thread.sleep(1000)
        intentos = intentos + 1
        segundo = segundo + 1
        if(segundo >= 60){
            segundo = segundo - 60
            minuto = minuto + 1
        }
        if(minuto >= 60){
            minuto = minuto - 60
            hora = hora + 1
        }
        if(hora >= 24){
            hora = hora - 24
        }
        println("La hora es: $hora:$minuto:$segundo")
    }while(intentos <= 10)
}