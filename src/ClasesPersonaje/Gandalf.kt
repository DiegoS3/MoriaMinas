package ClasesPersonaje

class Gandalf(var vara : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo) {

    fun recargarVara(energia: Int){


    }

    fun poderVara() : Int{

        return this.vara

    }

}