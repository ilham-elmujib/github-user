package utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri

actual class UrlHandler(private val context: Context) {
    @SuppressLint("UseKtx")
    actual fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}