package Sala

import ClasesPersonaje.Gandalf
import ClasesPersonaje.Legolas
import ClasesPersonaje.Personaje
import Utiles.Constantes
import Utiles.Metodos

class Sala constructor(var numero: Int, var peligro : Peligro, var p : Personaje){

    companion object{

        var victorias = 0
        var derrotas = 0

    }

    init {

        when(peligro){

            Peligro.ACCION -> accion()

            Peligro.HABILIDAD -> habilidad()

            Peligro.MAGICO -> magico()

        }

    }

    private fun superarPeligro(): Int {return Metodos.porcentaje()}

    private fun huir(){

        derrotas++
        if (Metodos.porcentaje() > 80) p.vivo = false

    }

    private fun accion(){

        var flechasSuelo = 0
        var enemigos = Metodos.generarNumAleatorio(Constantes.MINENEMIGOS, Constantes.MAXENEMIGOS)

        while (((p as Legolas).carcaj > 0) and (enemigos > 0)){

            (p as Legolas).lanzarFlecha()
            flechasSuelo++
            enemigos--

        }

        if(enemigos < 1){

            victorias++

        }

        (p as Legolas).recargarCarcaj(flechasSuelo)

    }

    private fun habilidad(){

        var probAnillo = Metodos.porcentaje()

        if (probAnillo <= 50){

            (p as Frodo).ponerseAnillo()

            if (superarPeligro() <= 90) {

                (p as Frodo).quitarseAnillo()
                victorias++
            }
            else huir()

        }else{

            if (superarPeligro() <= 20) victorias++
            else huir()

        }
    }

    private fun magico(){

        (p as Gandalf).recargarVara(Metodos.generarNumAleatorio(Constantes.MINVARAGANDALF, Constantes.MAXVARAGANDALF))
        var poderMaligno = Metodos.generarNumAleatorio(Constantes.MINPELIGROSALA, Constantes.MAXPELIGROSALA)
        var poder = (p as Gandalf).poderVara()

        if (poder > poderMaligno) victorias++
        else if(poder == poderMaligno){

            if (superarPeligro() < 60) victorias++
            else huir()

        }else{

            if (superarPeligro() < 30) victorias++
            else huir()

        }

        (p as Gandalf).vara -= poderMaligno

    }

}