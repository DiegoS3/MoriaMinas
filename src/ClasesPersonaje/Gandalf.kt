package ClasesPersonaje

class Gandalf(var vara : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo) {

    private fun recargarVara(energia: Int){

        vara += energia

        if (vara > Constantes.MAXVARAGANDALF) vara = Constantes.MAXVARAGANDALF

    }

    private fun poderVara() : Int{

        return vara

    }

}