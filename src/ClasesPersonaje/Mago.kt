package ClasesPersonaje

import Utiles.Constantes
import Utiles.Escritor

class Mago(var vara : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo) {

     fun recargarVara(energia: Int){

        vara += energia

        if (vara > Constantes.CARGAMAXVARAGANDALF ) vara = Constantes.CARGAMAXVARAGANDALF

         Escritor.escribirFichero("$nombre recarga la vara con $energia puntos de energía, quedando con un total de " +
                 "$vara puntos de energía en su vara\n")

    }

    fun poderVara() : Int{

        return vara

    }

}