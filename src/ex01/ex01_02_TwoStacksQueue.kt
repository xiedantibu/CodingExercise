package ex01._02_TwoStacksQueue

import util.tools.*
import java.util.*

/**
 * 【题目】编写一个类，用两个栈实现队列，支持队列的基本操作(add,poll,peek)
 * 栈的特点是先进后出，而队列的特点是先进先出。我们用两个栈正好把顺序反过来实现类似序列的操作。
 * */
class TwoStacksQueue<T> {
    private val mStacksPush = Stack<T>()
    private val mStacksPop = Stack<T>()

    private fun add(value: T) = mStacksPush.push(value)

    fun add(vararg value: T) = value.forEach { add(it) }

    fun poll(): T? {
        when {
            mStacksPop.isEmpty() && mStacksPush.isEmpty() -> return null
            mStacksPop.isEmpty() -> while (!mStacksPush.isEmpty()) {
                mStacksPop.push(mStacksPush.pop())
            }
        }
        return mStacksPop.pop()
    }

    fun peek(): T? {
        when {
            mStacksPop.isEmpty() && mStacksPush.isEmpty() -> return null
            mStacksPop.isEmpty() -> while (!mStacksPush.isEmpty()) {
                mStacksPop.push(mStacksPush.pop())
            }
        }
        return mStacksPop.peek()
    }
}

fun main(args: Array<String>) {
    val twoStacksQueue = TwoStacksQueue<Int>()
    twoStacksQueue.poll()?.println()
    twoStacksQueue.add(1, 2, 3, 4, 5)
    twoStacksQueue.poll()?.println()
    twoStacksQueue.poll()?.println()
    twoStacksQueue.add(10,11)
    twoStacksQueue.poll()?.println()
    twoStacksQueue.poll()?.println()
}
