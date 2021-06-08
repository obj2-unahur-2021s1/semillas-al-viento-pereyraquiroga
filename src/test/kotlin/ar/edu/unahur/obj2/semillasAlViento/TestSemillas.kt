package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec({
    // PLANTAS
    val plantaMenta = Menta(2021, 0.5F)
    val plantaSoja= Soja(2020, 0.6F,true)
    //PARCELAS
    val parcelaPlantar=Parcela(20,12,20)
    val parcela=Parcela(12,20,8)
    val parcela2=Parcela(12,20,8)
    val parcela3=Parcela(20,10,2)
    // LISTAS PARCELAS
    val parcelaPlantas= mutableListOf<Planta>()
    val parcelaLista= mutableListOf<Parcela>()
    val parcelaAgricultora=Agricultora(parcelaLista)

    describe("Horas de sol que tolera"){
        it("planta de Menta"){
            plantaMenta.horasDeSolQueTolera().shouldBe(6)
        }
        it("planta de Soja"){
            plantaSoja.horasDeSolQueTolera().shouldBe(14)
        }
    }
    describe ("Es fuerte"){
        it("planta de menta"){
            plantaMenta.esFuerte().shouldBe(false)
        }
        it("planta de Soja"){
            plantaSoja.esFuerte().shouldBe(true)
        }
    }
    describe("da semillas"){
        it("planta de Menta"){
            plantaMenta.daSemillas().shouldBe(true)
        }
        it("planta de soja"){
            plantaSoja.daSemillas().shouldBe(false)
        }
    }
    describe("parcela"){
        it("superficie"){
            parcela.superficie().shouldBe(240)
        }
        it("cantidad Maxima de plantas que tolera"){
            parcela.cantidadMaximaPlantas().shouldBe(100)
        }
        it ("tiene complicaciones"){
            parcelaPlantas.add(plantaSoja)
            parcela.parcelaTieneComplicaciones(parcela).shouldBe(false)
        }
        it("Plantar"){
            // TIRA ERROR PORQUE SE QUEMA NO SE PUEDE PLANTAR
            shouldThrowAny {
                parcelaPlantar.plantar(plantaSoja)
            }
        }

        it("parcela Agricola es semillera o no "){
            parcelaAgricultora.parcelasSemilleras().shouldBe(true)
            parcela2.plantar(plantaSoja)
            parcelaLista.add(parcela2)
            parcelaAgricultora.parcelasSemilleras().shouldBe(false)

        }
        it("Plantar estrategicamente"){ // ANTES NO SE PODIA PORQUE EL METODO NO USABA EL METODO PLANTAR
            val parcelaEstrategica=Parcela(12,20,2)
            parcelaEstrategica.plantar(plantaSoja)
            parcela3.plantar(plantaMenta)
            parcelaLista.add(parcelaEstrategica) // cantidad maxima de plantas 100 -1= 99, 1 es la que le agregamos arriba .
            parcelaLista.add(parcela3)//cantidad maxima de plantas 40 -1 = 39, 1 es la planta que le agregamos arriba
            parcelaAgricultora.plantarEstrategicamente(plantaMenta)
            parcelaEstrategica.cantidadPlantas().shouldBe(2) // LA PLANTA EN LA PARCELA ESTA PORQUE ES LA QUE
                                                                     // TIENE CANTIDAD MAXIMA DE PLANTAS.
        }



    }


})

