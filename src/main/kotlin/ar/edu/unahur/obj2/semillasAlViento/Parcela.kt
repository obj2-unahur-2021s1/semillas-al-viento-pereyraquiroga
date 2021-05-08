package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()
  var cantidadPlantas = 0 // REDUNDANCIA MINIMA : PORQUE LA CANTIDAD DE PLANTAS TE LO PUEDE DAR LA LISTA.

  fun superficie() = ancho * largo
  fun cantidadMaximaPlantas() =
    if (ancho > largo) ancho * largo / 5 else ancho * largo / 3 + largo // REDUNDANCIA PORQUE EN VEZ DE HACER ANCHO+LARGO
                                                                        // PODEMOS USAR EL METODO QUE DEVUELVE LA SUPERFICIE.

  fun plantar(planta: Planta) {
    if (cantidadPlantas == this.cantidadMaximaPlantas()) {
      println("Ya no hay lugar en esta parcela") // ROBUSTEZ: ARROJA PRINT PERO NO UN ERROR DE EXCEPCION.
    } else if (horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      println("No se puede plantar esto acá, se va a quemar")
    } else {
      plantas.add(planta)
      cantidadPlantas += 1 //SIMPLICIDAD kiss : NO PIDIO QUE SUME UNA PLANTA SOLO QUE LA AGREGUE SI HAY LUGAR.
                           // NO HACER COSAS QUE NO SE PIDIERON EN EL REQUERIMIENTO.
    }
  }
}

class Agricultora(val parcelas: MutableList<Parcela>) {  // MUTACIONES CONTROLADAS: DEBERIA SER INMUTABLE PORQUE DICE QUE
                                                         // NO SE PUEDEN VENDER NI COMPRAR.
  var ahorrosEnPesos = 20000 // SIMPLICIDAD YAGNI : AGREGA CODIGO INNECESARIO, NO TENEMOS QUE PENSAR EN REQUERIMIENTOS FUTUROS
                             // SI NO EN LO QUE PIDE AHORA.

  // Suponemos que una parcela vale 5000 pesos
  fun comprarParcela(parcela: Parcela) { // SIMPLICIDAD: NO ESTA EN EL ENUNCIADO.
    if (ahorrosEnPesos >= 5000) {
      parcelas.add(parcela)
      ahorrosEnPesos -= 5000
    }
  }

  fun parcelasSemilleras() = // (DES)ACOPLAMIENTO: EL CALCULO DEBE ESTAR EN PARCELAS NO EN PLANTAS.
    parcelas.filter {
      parcela -> parcela.plantas.all {// SIMPLICIDAD KISS : NO ES NECESARIO EL ALL YA QUE USANDO EL METODO DA SEMILLAS
                                        // SE SABE SI DA SEMILLAS O NO, HACER EL CODIGO LO MAS SIMPLE POSIBLE.
        planta -> planta.daSemillas()
      }
    }

  fun plantarEstrategicamente(planta: Planta) { // COHESION: HACE DOS COSAS SE PODRIA SEPARAR EN DOS METODOS.
    val laElegida = parcelas.maxBy { it.cantidadMaximaPlantas() - it.cantidadPlantas }!!  // MUTACIONES CONTROLADAS
    // SE PUEDE HACER UN METODO APARTE QUE HAGA ESA ACCION ANTES QUE USAR UNA VARIABLE
    laElegida.plantas.add(planta) // (DES)ACOPLAMIENTO : NO USA EL METODO PLANTAR, POR LO TANTO AGREGA SIN
                                  // VERIFICAR LOS PASOS ANTES DE AGREGAR.
  }
}
