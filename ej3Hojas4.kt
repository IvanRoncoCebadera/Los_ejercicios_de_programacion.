fun main(){
    var resultado = 0
    val numMaximo = 1000
    resultado = sumaNumerosPares(numMaximo)
    println("$resultado")
}
fun sumaNumerosPares(numMax: Int): Int{
    var resultado = 0
    for(i in 0..numMax step 2){
        resultado = resultado + i
    }
    return resultado
}