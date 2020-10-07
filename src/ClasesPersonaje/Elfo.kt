package ClasesPersonaje

import Utiles.Constantes
import Utiles.Escritor

class Elfo (var carcaj : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo){

    fun lanzarFlecha(){

        if(carcaj > 0) carcaj--

    }

    fun recargarCarcaj(flechas : Int){

        carcaj += flechas

        if (carcaj > Constantes.MAXFLECHASLEGOLAS) carcaj = Constantes.MAXFLECHASLEGOLAS

        Escritor.escribirFichero("$nombre recarga el carcaj con $flechas flechas, quedando con un total de " +
                "$carcaj flechas en el carcaj\n")

    }

}