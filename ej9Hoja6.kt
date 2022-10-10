fun main(){
    var numero = 0
    println("Introduce un numero y te dare su letra o simbolo equivalente de ascii, solo puedes poner del 0 al 255:")
    numero = readln().toInt()
    println(numero.toChar())
    if(numero <= 30){
        println("Error esos numero tienen asociado valores no imprimibles.")
    }else{
        for(i in numero..255){
            println(i.toChar())
        }
    }
}