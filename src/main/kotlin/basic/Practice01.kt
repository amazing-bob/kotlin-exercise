package org.example.basic

import kotlin.collections.mutableMapOf

/**
 * 문제
 * 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.
 *
 * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
 * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
 * 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
 * 예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
 *
 * 3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.
 *
 * 입력
 * 첫째 줄에 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.
 *
 * 출력
 * 첫째 줄에 게임의 상금을 출력 한다
 */

fun main() {
    print("주사위 3개의 눈을 입력하세요 : ")
    val inputs = readLine()!!.split(" ").map { it.toInt() }
    println("상금: ${Practice01().getPrize(inputs)}")

}

class Practice01 {

    fun getPrize (lots: List<Int>) : Int {
        var lotMap = mutableMapOf(lots.get(0) to 1)
        lotMap.put(lots.get(1), lotMap.getOrDefault(lots.get(1), 0) + 1)
        lotMap.put(lots.get(2), lotMap.getOrDefault(lots.get(2), 0) + 1)

        val cnt = lotMap.values.max()
        val keys = lotMap.filterKeys { lotMap.get(it) == cnt }
        val key  = keys.keys.first()
        when (cnt) {
            3 -> return calcPrize1(key)
            2 -> return calcPrize2(key)
            else -> return calcPrize3(lotMap.keys.max())
        }
    }

    fun calcPrize1(num: Int) = 10_000 + num * 1_000

    fun calcPrize2(num: Int) = 1000 + num * 100

    fun calcPrize3(num: Int) = num * 100

}