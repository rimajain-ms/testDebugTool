package com.gme.androiddebugfragmework.listeners

interface ShareLogsListener {
    fun onShareLogsClicked()
    fun shouldShowShareLogs(): Boolean
}