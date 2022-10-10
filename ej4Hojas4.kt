fun main() {
    var numero = 0
    do {
        numero = readln().toInt()
    }while(comprovacion(numero))
}
fun comprovacion(num: Int): Boolean{
    var res = true
    if(num > 100){
        res = false
    }
    return res
}