package com.gme.androiddebugfragmework.listeners

interface MemoryLeakListener {
    fun onMemoryLeakSwitchChanged(isChecked: Boolean)
    fun shouldShowMemoryLeaks(): Boolean
}