package ex01._05_SortStackByStack

/**
 * 【题目：一个栈实现另一个栈的排序】
 * 一个栈中元素的类型为整形，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构
 * */
import util.tools.println
import java.util.*

fun <T : Comparable<T>> Stack<T>.sortStackByStack() {
    if (isEmpty()) return
    else {
        val helpStack = Stack<T>()
        while (isEmpty().not()) {
            val popValue = pop()
            while (!helpStack.isEmpty() && popValue > helpStack.peek()) push(helpStack.pop())
            helpStack.push(popValue)
        }
        while (!helpStack.isEmpty()) push(helpStack.pop())
    }
}

fun main(args: Array<String>) {
    val stack = Stack<Int>()
    stack.push(5)
    stack.push(3)
    stack.push(8)
    stack.push(1)
    stack.push(52)
    stack.push(10)
    stack.push(0)
    stack.sortStackByStack()
    stack.println()
}

