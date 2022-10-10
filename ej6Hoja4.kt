fun main(){
    var precio = 0.0
    var distancia = 0
    var dias = 0
    val diasMax = 7
    val distanciaMax = 800
    println("Introduzca un valor de kilometros ha recorrer: y también el numero de dias de estancia: ")
    distancia = readln().toInt()
    dias = readln().toInt()
    precio = generarResultado(distancia, dias, distanciaMax, diasMax)
    println("El precio del billete según los datos introducidos es: $precio euros.")
}
fun generarResultado(distancia: Int, dias: Int, distanciaMax: Int, diasMax: Int): Double{
    var res = 0.0
    if(distancia >= distanciaMax && dias >= diasMax){
        res = (2.5 * distancia) * 0.7
    }else{
        res = 2.5 * distancia
    }
    return res
}