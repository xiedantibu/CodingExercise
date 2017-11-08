package ex01._03_StackReverse

import util.tools.*
import java.util.*

/**
 * 【题目】一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5，4，3，2，1.将这栈转置后，
 * 从栈顶到栈底为1,2,3,4,5。也就是实现栈中元素的逆序。但是只能使用递归实现，不能用其他数据结构。
 * */

fun <T> Stack<T>.getAndRemoveLastElement(): T {
    val value = pop()
    return when {
        empty() -> value
        else -> {
            val currentValue = getAndRemoveLastElement()
            push(value)
            currentValue
        }
    }
}

fun <T> Stack<T>.reverse() {
    when {
        empty() -> return
        else -> {
            val last = getAndRemoveLastElement()
            reverse()
            push(last)
        }
    }
}

fun main(args: Array<String>) {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.println()
    stack.reverse()
    stack.println()
    stack.reversed()
}
