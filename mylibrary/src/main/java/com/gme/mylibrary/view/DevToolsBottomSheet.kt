package com.gme.mylibrary.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.gme.androiddebugfragmework.listeners.DevToolsListener
import com.gme.mylibrary.data.DevToolsConfiguration
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.gme.mylibrary.R

class DevToolsBottomSheet(
    private val devToolsListener: DevToolsListener,
    private val configuration: DevToolsConfiguration
) : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val bottomSheetView =
            inflater.inflate(R.layout.bottom_sheet_dev_tools_layout, container, false)
        val tvNetworkLogs: TextView = bottomSheetView.findViewById(R.id.networkLogs)
        val tvMemoryLeaks: TextView = bottomSheetView.findViewById(R.id.memoryLeaks)
        val tvACSLogs: TextView = bottomSheetView.findViewById(R.id.acs_logs)
        val tvCrashesAnr: TextView = bottomSheetView.findViewById(R.id.crashesANRs)
        val tvSharedPref: TextView = bottomSheetView.findViewById(R.id.sharedPrefs)
        val tvLogs: TextView = bottomSheetView.findViewById(R.id.logger)
        val tvLayoutInspector: TextView = bottomSheetView.findViewById(R.id.layoutInspector)
        val tvECSValues: TextView = bottomSheetView.findViewById(R.id.ecsValues)

        if (context == null) {
            return bottomSheetView
        }


        // Check configuration and show/hide features accordingly
        if (!configuration.showMemoryLeaks) {
            tvMemoryLeaks.visibility = View.GONE
            devToolsListener.onMemoryLeakSwitchChanged(false)
        }

        if (!configuration.showShareLogs) {
            tvACSLogs.visibility = View.GONE
        }
        return bottomSheetView

    }
}