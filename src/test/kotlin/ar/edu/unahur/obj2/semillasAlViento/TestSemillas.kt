package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec({

    var plantaMenta = Menta(2021, 0.5F)
    var plantaSoja= Soja(2020, 0.6F,true)

    var parcela=Parcela(12,20,8)
    var parcelaAgricultora= Agricultora( mutableListOf<Parcela>())

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
    }

})

