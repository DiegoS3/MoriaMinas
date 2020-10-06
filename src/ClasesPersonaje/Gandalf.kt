package ClasesPersonaje

class Gandalf(var vara : Int, nombre : String, vivo : Boolean) : Personaje(nombre, vivo) {

    private fun recargarVara(energia: Int){}

    private fun poderVara() : Int{

        return this.vara

    }

}