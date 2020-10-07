package Sala

import ClasesPersonaje.Personaje

class Sala (var numero: Int, var peligro : Peligro, var p : Personaje){

    companion object{

        var victorias = 0
        var derrotas = 0

    }

}