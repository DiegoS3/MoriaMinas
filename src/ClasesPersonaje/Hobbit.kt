package ClasesPersonaje

class Hobbit (var anillo : Boolean, nombre : String, vivo : Boolean) : Personaje(nombre, vivo){

    fun ponerseAnillo(){

        this.anillo = true;

    }

    fun quitarseAnillo(){

        this.anillo = false;

    }

}