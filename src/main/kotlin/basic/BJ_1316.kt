package org.example.basic

import java.util.Scanner

/**
 * URL: https://www.acmicpc.net/problem/1316
 *
 * 문제
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 *
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 *
 * 출력
 * 첫째 줄에 그룹 단어의 개수를 출력한다.
 *
 * 예제 입력 1
 * 3
 * happy
 * new
 * year
 * 예제 출력 1
 * 3
 * 예제 입력 2
 * 4
 * aba
 * abab
 * abcabc
 * a
 * 예제 출력 2
 * 1
 */
class BJ_1316 {
    fun solve() = with(Scanner(System.`in`)){
//        val cnt = readln().toInt();
//        val words = Array(cnt) { readln() }
//        var resultCnt = 0;
//        wordLoop@for (word in words) {
//            var groupChars = mutableListOf<Char>()
//            for(ch in word.toCharArray()) {
//                if (groupChars.size == 0) {
//                    groupChars.add(ch)
//                }
//                if (groupChars.last() != ch) {
//                    if (groupChars.contains(ch)) {
//                        continue@wordLoop
//                    } else {
//                        groupChars.add(ch)
//                    }
//                }
//            }
//            resultCnt ++;
//        }
//        println(resultCnt)

        var cnt = readln().toInt()
        repeat(cnt) {
            var groupChars = mutableSetOf<Char>()
            readln().forEach {
                if (it !in groupChars) groupChars.add(it)
                else if (groupChars.last() != it) {
                    cnt--
                    return@repeat
                }
            }
        }
        println(cnt)
    }
}

fun main() {
    BJ_1316().solve();
}