fun main(){
    var turno = "".toString()
    var resultado = ""
    turno = leerTurno("""Por favor, introduzca si es el turno "humano" o si es el turno "ordenador", en caso de querer terminar el programa pulse "q".""")
    resultado = "${premios(turno)}"
}
fun premios(turnos: String){
    var turno = turnos
    var dado1 = 0
    var dado2 = 0
    var dado3 = 0
    var premio = 0
    var premio2 = 0
    var intentos = 0
    do {
        if(turno != "q") {
            if (turno == "humano") {
                dado1 = generarNumeros(1, 6)
                dado2 = generarNumeros(1, 6)
                dado3 = generarNumeros(1, 6)
                println("los resultados de sus tiradas son: $dado1, $dado2 y $dado3")
                turno = "ordenador"
                premio = generarPremio(dado1, dado2, dado3, premio)
                println("Su premios es: $premio")
            } else {
                if (turno == "ordenador") {
                    dado1 = generarNumeros(1, 6)
                    dado2 = generarNumeros(1, 6)
                    dado3 = generarNumeros(1, 6)
                    println("Mis resultados son: $dado1, $dado2 y $dado3")
                    turno = "humano"
                    premio2 = generarPremio(dado1, dado2, dado3, premio)
                    println("Mi premios es: $premio2")
                }
            }
        }else{
            println("Cerrando programa...")
        }
        intentos = intentos + 1
    }while(intentos <= 1)
    if(premio > premio2) {
        println("El ganador es nada más y nada menos que el jugador.")
    }else{
        if(premio < premio2) {
            println("El ganador es nada más y nada menos que el ordenador.")
        }else{
            println("Es un empate.")
        }
    }
}
fun leerTurno(mensaje: String): String{
    var turno = "".toString()
    do {
        println(mensaje)
        turno = readln().toString()
        if(turno != "humano" && turno != "ordenador" && turno != "q"){
            println("El texto introducido no es valido, pruebe de nuevo con las opciones propuestas anteriormente.")
        }
    }while(turno != "humano" && turno != "ordenador" && turno != "q")
    return turno
}
fun generarNumeros(numMin: Int, numMax: Int): Int{
    return ((numMin .. numMax).random())
}
fun generarPremio(dado1: Int, dado2: Int, dado3: Int, premio: Int): Int{
    var premios = premio
    if(dado1 == dado2 && dado1 == dado3){
        if(dado1 == 6){
            premios = 50
        }else{
            premios = 20
        }
    }else{
        if((dado1==dado2 || dado1==dado3) || (dado2==dado1 || dado2==dado3) || (dado3==dado1 || dado3==dado2)){
            premios = 10
        }else{
            premios = 0
        }
    }
    return premios
}