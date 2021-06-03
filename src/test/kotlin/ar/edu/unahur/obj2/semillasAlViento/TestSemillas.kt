package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec({

    var plantaMenta = Menta(2021, 0.5F)
    var plantaSoja= Soja(2020, 0.6F,true)

    describe("Horas de sol que tolera"){
        it("planta de Menta"){
            plantaMenta.horasDeSolQueTolera().shouldBe(6)
        }
        it("planta de Soja"){
            plantaSoja.horasDeSolQueTolera().shouldBe(7)
        }
    }
})