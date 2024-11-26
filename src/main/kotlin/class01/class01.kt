package org.example.class01

import java.util.Scanner
import kotlin.math.max
import kotlin.random.Random

fun main() {
    var result = if (true) { "true!!" } else { "false!!"}
    println(result)

    val items = listOf(1,2,3,4,5)
    for (item in items) {
        println(item)
    }
    items.forEach({ item -> println(item) })
    for (i in 0..items.size-1) {
        println(items[i]);
    }

    val mList = mutableListOf(1,2,3,4,5)
    mList.add(6)
    mList.remove(1)

    var name: String? = null
    name = "Kim"
    name = null

    // NULL 처리
    var name2: String = ""
    if (name != null) { // null 체크 후 가능
        name2 = name
    }
//    name2 = name!! // not null 보증
    name?.let { // null이 아닌 경우 처리
        name2 = name
    }

    // 함수
    sum(a = 1, b =  2)
    sum(b = 1, a =  2)

    // class
    val john = Person("John", 30)
    println(john.name)
    println(john.age)
//    john.name = "Kim"
    john.age = 20

    val john2 = Person("John", 20)
    println(john)
    println(john2)
    println(john == john2)
//    john.hobby = "ssss"
    println(john.hobby)


    // 상속
    println(Cat().move())
    println(Dog().move())

    val dog: Animal = Dog()
    val cat = Cat()
    if (dog is Dog) {
        dog.draw()
        println("멍멍이")
    }
    if (dog is Animal) {
//        dog.draw()
        println("멍멍이2")
    }
    if (dog is Cat) {
        println("멍멍이3")
    }
//    cat as Dog

// callbak fun
    myFunc (10, { println("callbackFunc") })
    myFunc (10) { println("callbackFunc") }
//    myFunc { println("callbackFunc") } // 인자값 없다면 () 생략 가능

    // 코루틴

    mySusFunc(10, { println("callbackFunc!!!!!") })
}

// 함수
fun sum(a: Int, b: Int): Int = a + b
fun sum(a: Int, b: Int, c: Int = 0) = a + b + c


//class
data class Person(
//    private val name: String,
    val name: String,
    var age: Int,
) {
    var hobby = "soccer"
        private set
        get() = "취미: $field"

    init {
        println("init")
    }

    fun some() {
        hobby = "basketball"
    }
}

// 상속
abstract class Animal {
    open fun move(){
        println("움직인다")
    }
}
class Dog : Animal(), Drawable {
    override fun move(){
        println("개가 움직인다")
    }

    override fun draw() {
        println("개를 그리다")
    }
}
class Cat : Animal(), Drawable {
    override fun draw() {
        println("고양이를 그리다")
    }
}

open class Man
class SuperMan : Man()

interface Drawable {
    fun draw()
}

// callbak fun
fun myFunc( a: Int, callBack: () -> Unit) {
    println("myFunc")
    callBack()
}

// 코루틴
suspend fun mySusFunc(a: Int, callBack: () -> Unit = {}) {
    println("mySusFunc")
    callBack()
}