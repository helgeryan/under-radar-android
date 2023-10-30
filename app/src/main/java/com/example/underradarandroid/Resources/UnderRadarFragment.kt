package com.example.underradarandroid.Resources

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

open class UnderRadarFragment: Fragment() {

    public fun openLink(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}