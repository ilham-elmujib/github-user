package utils

import java.awt.Desktop
import java.net.URI

actual class UrlHandler {
    actual fun openUrl(url: String) {
        val desktop = Desktop.getDesktop()
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            desktop.browse(URI(url))
        }
    }
}