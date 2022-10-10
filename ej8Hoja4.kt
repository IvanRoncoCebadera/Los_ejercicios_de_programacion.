fun main(){
    var dias = 0
    var mes = 0
    var año = 0
    println("Introduzca un mes y un año (en numeros) y te dire cuantos dias tiene.")
    mes = readln().toInt()
    año = readln().toInt()
    dias = generarDias(mes, año)
    println("El mes $mes del año $año, tiene $dias dias.")
}
fun generarDias(mes: Int, año: Int): Int{
    var dias = 0
    if(año % 4 == 0 && año % 100 != 0 || año % 400 == 0){
        if(mes == 2){
            dias = 29
        }else{
            if(mes == 4 ||mes == 6 ||mes == 9 ||mes == 11){
                dias = 30
            }else{
                dias = 31
            }
        }
    }else{
        if(mes == 2){
            dias = 28
        }else{
            if(mes == 4 ||mes == 6 ||mes == 9 ||mes == 11){
                dias = 30
            }else{
                dias = 31
            }
        }
    }
    return dias
}