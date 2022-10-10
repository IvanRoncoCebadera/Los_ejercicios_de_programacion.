fun main() {
    var euro = 0
    var centimo = 0
    var num2euro = 0
    var num1euro = 0
    var num50cent = 0
    var num20cent = 0
    var num10cent = 0
    var num5cent = 0
    var num2cent = 0
    var num1cent = 0

    euro = generarEuro("Ingresa los euros que desea recivir:")
    centimo = generarCentimo("Ingresa los céntimos que desea recivir:")
    println("Se va a realizar la conversión a monedas más lógica para los $euro,$centimo euros.")
    while(euro > 0) {
        if (euro >= 2) {
            euro = euro - 2
            num2euro = num2euro + 1
        } else {
            euro = euro - 1
            num2euro = num1euro + 1
        }
    }
    while(centimo > 0) {
        if (centimo >= 50) {
            num50cent++
            centimo = centimo - 50
        } else {
            if (centimo >= 20) {
                num20cent++
                centimo = centimo - 20
            } else {
                if (centimo >= 10) {
                    num10cent++
                    centimo = centimo - 10
                } else {
                    if (centimo >= 5) {
                        num5cent++
                        centimo = centimo - 5
                    } else {
                        if (centimo >= 2) {
                            num2cent++
                            centimo = centimo - 2
                        } else {
                            if (centimo >= 1) {
                                num1cent++
                                centimo = centimo - 1
                            }
                        }
                    }
                }
            }
        }
    }
    println("Las monedas se asignaran como: $num2euro monedas de 2 euros, $num1euro monedas de 1 euro, $num50cent,$num20cent,$num10cent,$num5cent,$num2cent,$num1cent.")
}
fun generarEuro(mensaje: String): Int{
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
fun generarCentimo(mensaje: String): Int{
    var res = 0
    do {
        var acierto = false
        println(mensaje)
        res = readln().toInt()
        if(res > 0 && res < 100){
            acierto = true
        } else{
            println("El número no puede ser negativo, ni tampoco mayor que 100, intentelo de nuevo.")
        }
    }while(!acierto)
    return res
}