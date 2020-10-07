package ClasesPersonaje

import Utiles.Constantes

class Legolas (var carcaj : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo){

    fun lanzarFlecha(){

        if(this.carcaj > 0){

            this.carcaj --

        }

    }

    fun recargarCarcaj(flechas : Int){

        this.carcaj += flechas

        if (this.carcaj > Constantes.MAXFLECHASLEGOLAS){

            this.carcaj = Constantes.MAXFLECHASLEGOLAS

        }

    }

}