fun main(){
    var horas = 0.0
    var precio = 0.0
    var resultado = 0.0
    var bruto = 0.0
    var descuento = ""
    println("Introduce el numero de horas trabajadas y despues el dinero que se paga por horas.")
    horas = readln().toDouble()
    precio = readln().toDouble()
    resultado = salario(horas, precio)
    bruto = salarioBruto(horas, precio)
    descuento = descuentosImpuestos(resultado)
    println("El salario que cobrara por $horas horas y a $precio euros la hora, teniedo en cuenta que a partir de las 40 horas se cobra 1.5 veces los euros por hora, es: $resultado")
    println("El salario bruto que cobrara por $horas horas y a $precio euros la hora, teniedo en cuenta que a partir de las 40 horas se cobra 1.5 veces los euros por hora, es: $bruto")
    println(descuento)
}
fun salario(horas: Double, precio: Double): Double{
    var hora = horas
    var precios = precio
    var res = 0.0
    if(horas < 40){
        res = hora * precio
    }else{
        hora = hora - 40
        res = (40 * precios) + (hora * precio * 1.5)
    }
    return res
}
fun salarioBruto(horas: Double, precio: Double): Double{
    var hora = horas
    var res = 0.0
    if(horas < 40){
        res = hora * precio
    }else{
        if(horas <= 45) {
            hora = hora - 40
            res = (40 * precio) + (hora * precio * 1.5)
        }else{
            var bruto = hora
            bruto = bruto - 45
            hora = hora - 40
            res = (40 * precio) + (hora * precio * 1.5) + (bruto * precio * 2)
        }
    }
    return res
}
fun descuentosImpuestos(salario: Double): String{
    var mensaje = ""
    var res = salario
    if(salario < 1000){
        mensaje = "Como gana menos de 1000 euros al mes, se le descontara el 10% de su salario."
        res = res * 0.9
    }else{
        mensaje = "Como gana mas de 1000 euros al mes, se le descontara el 15% de su salario."
        res = res * 0.85
    }
    return "$mensaje, el salario tras aplicar los impuestos es de $res euros."
}