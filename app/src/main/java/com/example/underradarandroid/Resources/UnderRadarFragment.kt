package com.example.underradarandroid.Resources

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

open class UnderRadarFragment: Fragment() {

    fun openLink(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    fun shareLink(text: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}