package ClasesPersonaje

class Frodo (var anillo : Boolean, nombre : String, vivo : Boolean) : Personaje(nombre, vivo){

    private fun ponerseAnillo(){

        this.anillo = true;

    }

    private fun quitarseAnillo(){

        this.anillo = false;

    }

}