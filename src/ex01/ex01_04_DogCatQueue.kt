package ex01._04_DogCatQueue

import java.util.*
import util.tools.*

/**
 * 【题目：猫狗队列】宠物、狗和猫的类如下：
 * open class Pet(val type: String)
 * class Dog() : Pet("dog")
 * class Cat() : Pet("cat")
 * 实现一种猫狗队列的结构，要求如下：
 * 1.用户可以调用add方法将cat或dog类的实例放入队列中
 * 2.用户可以调用pollAll方法，将队列中所以的实例按照进队列的先后顺序依次弹出
 * 3.用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
 * 4.用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
 * 5.用户可以调用isEmpty方法，检查队列中是否还有dog或者cat的实例
 * 6.用户可以调用isDogEmpty方法，检查队列中是否还有dog的实例
 * 7.用户可以调用isCatEmpty方法，检查队列中是否还有cat的实例
// * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用
 * */
open class Pet(val type: String)

class Dog() : Pet("dog")
class Cat() : Pet("cat")
class PetEnterQuene(val pet: Pet, val count: Long)

class DogCatQueue() {
    private val dogQueue: Queue<PetEnterQuene> = LinkedList<PetEnterQuene>()
    private val catQueue: Queue<PetEnterQuene> = LinkedList<PetEnterQuene>()
    private var count: Long = 0

    fun add(pet: Pet): Boolean? = when (pet) {
        is Cat -> catQueue.add(PetEnterQuene(pet, ++count))
        is Dog -> dogQueue.add(PetEnterQuene(pet, ++count))
        else -> {
            "pet not find the type".println()
            null
        }
    }

    fun pollAll() {
        while (!isEmpty()) poll()
    }

    fun poll(): Pet? {
        return when {
            !dogQueue.isEmpty() && !catQueue.isEmpty() -> {
                val dogPeek = dogQueue.peek()
                val catPeek = catQueue.peek()
                when {
                    dogPeek.count < catPeek.count -> dogQueue.poll().pet
                    else -> catQueue.poll().pet
                }
            }
            isDogEmpty().not() -> dogQueue.poll().pet
            isCatEmpty().not() -> catQueue.poll().pet
            else -> null
        }
    }

    fun pollDog() = when {
        isDogEmpty().not() -> dogQueue.poll().pet
        else -> null
    }

    fun pollCat() = when {
        isCatEmpty().not() -> catQueue.poll().pet
        else -> null
    }

    fun isEmpty() = isDogEmpty() && isCatEmpty()
    fun isDogEmpty() = dogQueue.isEmpty()
    fun isCatEmpty() = catQueue.isEmpty()
}

fun main(args: Array<String>) {
    val dogcatQueue = DogCatQueue()
    dogcatQueue.add(Dog())
    dogcatQueue.add(Cat())
    dogcatQueue.add(Cat())
    dogcatQueue.add(Dog())
    dogcatQueue.poll().toString().println()
    dogcatQueue.pollCat().toString().println()
    dogcatQueue.poll().toString().println()
    dogcatQueue.pollCat().toString().println()
    dogcatQueue.isDogEmpty().println()
    dogcatQueue.pollAll()
    dogcatQueue.isDogEmpty().println()
}