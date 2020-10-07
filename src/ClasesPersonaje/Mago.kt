package ClasesPersonaje

import Utiles.Constantes

class Mago(var vara : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo) {

     fun recargarVara(energia: Int){

        vara += energia

        if (vara > Constantes.CARGAMAXVARAGANDALF ) vara = Constantes.CARGAMAXVARAGANDALF

    }

    fun poderVara() : Int{

        return vara

    }

}