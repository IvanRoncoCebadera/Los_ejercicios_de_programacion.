const val LUKE = -1
const val VACIA = 0
const val TAMAÑO = 7
const val TIEMPO_MAX = 20_000
const val TIEMPO_ESPERA  = 1_000
const val CHANCE_RECIBIR_TIRO_MODO_ATAQUE = 65
const val CHANCE_RECIBIR_TIRO_MODO_DEFENSA = 5

var totalNavesDestruidas = 0
var vidaEscudo = 10
var posicionLuke = IntArray(2)

fun main(){
    println("Hace mucho tiempo, en un galaxia muy muy lejana...")
    println("Blablabla, texto texto texto")
    println("STAR TREK, o algo, no se, nunca me vi el manga...")
    var zonaCombate: Array<IntArray> = Array(TAMAÑO) { IntArray(TAMAÑO) }
    jugarStarWars(zonaCombate)
}

private fun jugarStarWars(espacio: Array<IntArray>) {
    var tiempo = 0
    var zonaCombate = espacio
    var navesEnemigas: Int =
        preguntarNumeroEnemigos("Cuantas naves enemigas se han localizado (como mínimo 10 y como máximo 25):")
    posicionLuke = posicionarLuke(zonaCombate)
    var reposicionLuke = IntArray(2)
    zonaCombate = colocacionNavesEnemigas(zonaCombate, navesEnemigas)
    zonaCombate = colocacionLuke(zonaCombate, posicionLuke)
    println("Actualmente, nos encontramos en la siguiente situación:")
    println(imprimirEspacio(zonaCombate))
    do {
        var opcion = menuOpciones()
        when(opcion) {
            1 -> zonaCombate = opcionAtacar(zonaCombate)
            2 -> zonaCombate = opcionDefender(zonaCombate)
        }
        tiempo = esperar(tiempo)
        println(imprimirEspacio(zonaCombate))
    } while (tiempo <= TIEMPO_MAX && vidaEscudo != 0)
    println("Luke terminó destruyendo $totalNavesDestruidas naves enemigas en total.")
    if (vidaEscudo <= 0) {
        println("Luke a muerto, F")
    } else {
        println("Lo has conseguido, has consequido aguantar lo suficiente como para escapar.")
        if (totalNavesDestruidas == 0) {
            println("sin embargo, debo decir que es un poco decepcionante que que no hayas conseguido ni una kill, que malo XD.")
        }
    }
}

fun opcionAtacar(espacio: Array<IntArray>): Array<IntArray>{
    var zonaCombate = copiar(espacio)
    var reposicionLuke = IntArray(2)
    zonaCombate = procedimientoAtaque("Has elegido el modo de ataque, procedemos a analizar la situación que nos rodea, y a disparar a todos los enemigos posibles.", zonaCombate)
    vidaEscudo = recalcularVidaEscudos(vidaEscudo, CHANCE_RECIBIR_TIRO_MODO_ATAQUE)
    reposicionLuke = posicionarLuke(zonaCombate)
    zonaCombate = desplazarsePorElEspacio(zonaCombate, reposicionLuke)
    posicionLuke = reposicionLuke
    println("Ahora Luke se recoloca.")
    return zonaCombate
}

fun opcionDefender(espacio: Array<IntArray>): Array<IntArray>{
    var zonaCombate = copiar(espacio)
    var reposicionLuke = IntArray(2)
    procedimientoDefensa("Has elegido el modo defensivo.", zonaCombate)
    vidaEscudo = recalcularVidaEscudos(vidaEscudo, CHANCE_RECIBIR_TIRO_MODO_DEFENSA)
    reposicionLuke = posicionarLuke(zonaCombate)
    zonaCombate = desplazarsePorElEspacio(zonaCombate, reposicionLuke)
    posicionLuke = reposicionLuke
    println("Luke procede a recolocarse.")
    return zonaCombate
}

fun esperar(tiempo: Int): Int{
    var nuevoTiempo = tiempo
    Thread.sleep(1_000)
    nuevoTiempo += TIEMPO_ESPERA
    return nuevoTiempo
}

fun recalcularVidaEscudos(escudo: Int, chance: Int): Int{
    var vidaEscudo = escudo
    if(recibirTiro(chance)){
        vidaEscudo--
        println("Por mala suerte, hemos recibido un tiro, nos quedan $vidaEscudo puntos de vida.")
    }else{
        println("Hemos conseguido evitar todos los disparos del rival, nos quedan $vidaEscudo puntos de vida.")
    }
    return vidaEscudo
}

fun recibirTiro(chance: Int): Boolean{
    var probabilidad = (1..100).random()
    return if(probabilidad in (1..chance)){
        true
    }else{
        false
    }
}

fun desplazarsePorElEspacio(zonaPelea: Array<IntArray>, reposicion: IntArray): Array<IntArray>{
    var espacio = copiar(zonaPelea)
    espacio[posicionLuke[0]][posicionLuke[1]] = 0
    espacio[reposicion[0]][reposicion[1]] = -1
    return espacio
}

fun procedimientoAtaque(mensaje: String, zonaPelea: Array<IntArray>): Array<IntArray>{
    println(mensaje)
    var espacio = copiar(zonaPelea)
    var auxiliar = copiar(espacio)
    auxiliar = resultadosModoAtaque(auxiliar, espacio)
    return auxiliar
}

fun resultadosModoAtaque(auxiliar: Array<IntArray>, espacio: Array<IntArray>): Array<IntArray>{
    var zona = copiar(auxiliar)
    var contNavesReventadas = 0
    var fila = posicionLuke[0]
    var columna = posicionLuke[1]
    for(i in -1..1){
        for(j in -1..1){
            if(fila + i >= 0 && fila + i < TAMAÑO && columna + j >= 0 && columna + j < TAMAÑO){
                if(zona[fila + i][columna + j] in (1..5)){
                    contNavesReventadas++
                    zona[fila + i][columna + j] -= 1
                }
            }
        }
    }
    totalNavesDestruidas += contNavesReventadas
    println("Esta ronda de ataque, Luke eliminos a $contNavesReventadas naves.")
    println("Las naves quedan así:")
    println(imprimirEspacio(zona))
    return zona
}

fun procedimientoDefensa(mensaje: String, zonaPelea: Array<IntArray>){
    println(mensaje)
    println("En este modo, no se puede atacar a lo enemigos, pero nuestra probabilidad de recivir daño es casi nula.")
}

fun posicionarLuke(zonaPelea: Array<IntArray>): IntArray{
    var coordenadas = IntArray(2)
    do {
        coordenadas[0] = (0..6).random()
        coordenadas[1] = (0..6).random()
    }while(zonaPelea[coordenadas[0]][coordenadas[1]] != VACIA)
    return coordenadas
}

fun colocacionLuke(zonaPelea: Array<IntArray>, posicion: IntArray): Array<IntArray>{
    var espacio = copiar(zonaPelea)
    var fila = posicion[0]
    var columna = posicion[1]
    espacio[fila][columna] = LUKE
    return espacio
}

fun imprimirEspacio(espacio: Array<IntArray>){
    var mensaje = ""
    for(fila in espacio.indices){
        for(columna in espacio[fila].indices) {
            mensaje = "$mensaje ${espacio[fila][columna]}"
        }
        println(mensaje)
        mensaje = ""
    }
}

fun colocacionNavesEnemigas(zonaPelea: Array<IntArray>, enemigos: Int): Array<IntArray>{
    var espacio = copiar(zonaPelea)
    var fila = 0
    var columna = 0
    var naves = enemigos
    var casillas = enemigos/3
    do{
        do {
            fila = (0..6).random()
            columna = (0..6).random()
        }while(espacio[fila][columna] != VACIA)
        var numeroNaves = (2..5).random()
        if(naves >= 5) {
            espacio[fila][columna] = numeroNaves
            naves -= numeroNaves
        }else{
            espacio[fila][columna] = naves
            naves = 0
        }
    }while(naves != 0)
    return espacio
}

fun copiar(auxiliar: Array<IntArray>): Array<IntArray>{
    var espacio = Array(TAMAÑO){IntArray(TAMAÑO)}
    for(fila in auxiliar.indices){
        for(columna in auxiliar[fila].indices) {
            espacio[fila][columna] = auxiliar[fila][columna]
        }
    }
    return espacio
}

fun preguntarNumeroEnemigos(mensaje: String): Int{
    println(mensaje)
    val regex = Regex("[1-2][0-9]")
    var naves = ""
    do {
        naves = readln()
        if(!regex.matches(naves) || naves.toInt() < 10 || naves.toInt() > 25){
            println("Esa no es una posible cantida de naves enemigas. Prueba a meterla de nuevo:")
        }
    }while(!regex.matches(naves) || naves.toInt() < 10 || naves.toInt() > 25)
    return naves.toInt()
}

private fun menuOpciones(): Int{
    val regex = Regex("[1-2]")
    var opcion = ""
    do {
        println("[1] Atacar")
        println("[2] Defender")
        opcion = readln()
        if(!regex.matches(opcion)){
            println("Esa opción no es válida. Prueba a meterla de nuevo:")
        }
    }while(!regex.matches(opcion))
    return opcion.toInt()
}