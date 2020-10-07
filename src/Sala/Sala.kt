package Sala

import ClasesPersonaje.*
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

        while (((p as Elfo).carcaj > 0) and (enemigos > 0)){

            (p as Elfo).lanzarFlecha()
            flechasSuelo++
            enemigos--

        }

        if(enemigos < 1){

            victorias++

        }

        (p as Elfo).recargarCarcaj(flechasSuelo)

    }

    private fun habilidad(){

        var probAnillo = Metodos.porcentaje()

        if (probAnillo <= 50){

            (p as Hobbit).ponerseAnillo()

            if (superarPeligro() <= 90) {

                (p as Hobbit).quitarseAnillo()
                victorias++
            }
            else huir()

        }else{

            if (superarPeligro() <= 20) victorias++
            else huir()

        }
    }

    private fun magico(){

        (p as Mago).recargarVara(Metodos.generarNumAleatorio(Constantes.MINVARAGANDALF, Constantes.MAXVARAGANDALF))
        var poderMaligno = Metodos.generarNumAleatorio(Constantes.MINPELIGROSALA, Constantes.MAXPELIGROSALA)
        var poder = (p as Mago).poderVara()

        if (poder > poderMaligno) victorias++
        else if(poder == poderMaligno){

            if (superarPeligro() < 60) victorias++
            else huir()

        }else{

            if (superarPeligro() < 30) victorias++
            else huir()

        }

        (p as Mago).vara -= poderMaligno

    }

}