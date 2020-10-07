package ClasesPersonaje

class Gandalf(var vara : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo) {

    private fun recargarVara(energia: Int){

        vara += energia

        if (vara > Constantes.CARGAMAXVARAGANDALF ) vara = Constantes.CARGAMAXVARAGANDALF

    }

    private fun poderVara() : Int{

        return vara

    }

}