package ex01._01_getMin

import util.tools.*
import java.util.*

/**
 *设计一个有getMin的栈
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：
 * 1.pop/push/getMin操作的时间复杂度都是O(1)
 * 2.设计的栈类型可以使用现成的栈结构
 * */
object MyStack {
    private val m_StackData: Stack<Int> = Stack()
    private val m_StackMin: Stack<Int> = Stack()
    private fun push(value: Int) {
        when {
            m_StackMin.isEmpty() -> m_StackMin.push(value)
            m_StackMin.peek() > value -> m_StackMin.push(value)
        }
        m_StackData.push(value)
    }

    fun push(vararg value: Int) = value.forEach { push(it) }
    fun pop(): Int? {
        if (m_StackData.isEmpty()) return null
        val popValue = m_StackData.pop()
        if (popValue == m_StackMin.peek()) m_StackMin.pop()
        return popValue
    }

    fun getMin(): Int? = if (m_StackMin.isEmpty()) null else m_StackMin.peek()
}

object MyStack2 {
    private val mStackData: Stack<Int> = Stack()
    private val mStackMin: Stack<Int> = Stack()

    private fun push(value: Int) {
        when {
            mStackMin.isEmpty() -> mStackMin.push(value)
            mStackMin.peek() > value -> mStackMin.push(value)
            else -> mStackMin.push(mStackMin.peek())
        }
        mStackData.push(value)
    }

    fun push(vararg value: Int) = value.forEach { push(it) }

    fun pop(): Int? = when {
        mStackData.isEmpty() -> null
        else -> {
            mStackMin.pop()
            mStackData.pop()
        }
    }

    fun getMin(): Int? = if (mStackMin.isEmpty()) null else mStackMin.peek()
}

fun main(args: Array<String>) {
    MyStack.push(3, 4, 5, 1, 2, 1)
    MyStack.getMin()?.println()
    MyStack.pop()?.println()
    MyStack.pop()?.println()
    MyStack.pop()?.println()
    MyStack.pop()?.println()
    MyStack.pop()?.println()
    MyStack.pop()?.println()
    MyStack.pop()?.println()
    "=====MyStack2======".println()
    MyStack2.push(3, 4, 5, 1, 2, 1)
    MyStack2.getMin()?.println()
    MyStack2.pop()?.println()
    MyStack2.pop()?.println()
    MyStack2.pop()?.println()
    MyStack2.pop()?.println()
    MyStack2.pop()?.println()
    MyStack2.pop()?.println()
}