fun main() {
    var numero = 0
    var numMin = 1
    var numMax = 5
    do {
        numero = readln().toInt()
    }while(comprovaciones(numero, numMin, numMax))
}
fun comprovaciones(num: Int, nuM: Int, nUM: Int): Boolean{
    var res = true
    if(num in(nuM..nUM)){
        res = false
    }
    return res
}