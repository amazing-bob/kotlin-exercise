package org.example.basic

import java.util.Scanner

/**
 * URL: https://www.acmicpc.net/problem/1157
 *
 * 문제
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 *
 * 입력
 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 *
 * 출력
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 *
 * 예제 입력 1
 * Mississipi
 * 예제 출력 1
 * ?
 * 예제 입력 2
 * zZa
 * 예제 출력 2
 * Z
 * 예제 입력 3
 * z
 * 예제 출력 3
 * Z
 * 예제 입력 4
 * baaa
 * 예제 출력 4
 * A
 */
class BJ_1157 {
    fun solve() = with(Scanner(System.`in`)) {
        val word = nextLine().toString().uppercase();
        var wordMap = mutableMapOf<Char, Int>()
        for (c in word.toCharArray()) {
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1)
        }
        val max = wordMap.maxOf { it.value }
        val maxChars = wordMap.filter { it.value == max }
        if (maxChars.size > 1) {
            println("?")
        } else {
            println(maxChars.keys.first())
        }

    }

}

fun main() {
    BJ_1157().solve()
}