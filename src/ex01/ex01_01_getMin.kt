package ex01._01_getMin

import util.tools.*
import java.util.*
import kotlin.Comparator

/**
 *设计一个有getMin的栈
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：
 * 1.pop/push/getMin操作的时间复杂度都是O(1)
 * 2.设计的栈类型可以使用现成的栈结构
 * */
class MyStack<T:Comparable<T>> {
    private val m_StackData: Stack<T> = Stack()
    private val m_StackMin: Stack<T> = Stack()
    private fun push(value: T) {
        when {
            m_StackMin.isEmpty() -> m_StackMin.push(value)
            m_StackMin.peek() > value -> m_StackMin.push(value)
        }
        m_StackData.push(value)
    }

    fun push(vararg value: T) = value.forEach { push(it) }
    fun pop(): T? {
        if (m_StackData.isEmpty()) return null
        val popValue = m_StackData.pop()
        if (popValue == m_StackMin.peek()) m_StackMin.pop()
        return popValue
    }

    fun getMin(): T? = if (m_StackMin.isEmpty()) null else m_StackMin.peek()
}

class MyStack2<T:Comparable<T>> {
    private val mStackData: Stack<T> = Stack()
    private val mStackMin: Stack<T> = Stack()

    private fun push(value: T) {
        when {
            mStackMin.isEmpty() -> mStackMin.push(value)
            mStackMin.peek() > value -> mStackMin.push(value)
            else -> mStackMin.push(mStackMin.peek())
        }
        mStackData.push(value)
    }

    fun push(vararg value: T) = value.forEach { push(it) }

    fun pop(): T? = when {
        mStackData.isEmpty() -> null
        else -> {
            mStackMin.pop()
            mStackData.pop()
        }
    }

    fun getMin(): T? = if (mStackMin.isEmpty()) null else mStackMin.peek()
}

fun main(args: Array<String>) {
    val myStack = MyStack<Int>()
    myStack.push(3, 4, 5, 1, 2, 1)
    myStack.getMin()?.println()
    myStack.pop()?.println()
    myStack.pop()?.println()
    myStack.pop()?.println()
    myStack.pop()?.println()
    myStack.pop()?.println()
    myStack.pop()?.println()
    myStack.pop()?.println()
    "=====MyStack2======".println()
    val myStack2 = MyStack2<Int>()
    myStack2.push(3, 4, 5, 1, 2, 1)
    myStack2.getMin()?.println()
    myStack2.pop()?.println()
    myStack2.pop()?.println()
    myStack2.pop()?.println()
    myStack2.pop()?.println()
    myStack2.pop()?.println()
    myStack2.pop()?.println()
}