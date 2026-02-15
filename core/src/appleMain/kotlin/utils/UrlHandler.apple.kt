package utils

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual class UrlHandler {
    actual fun openUrl(url: String) {
        val nsUrl = NSURL.URLWithString(url)
        if (nsUrl != null) {
            val application = UIApplication.sharedApplication

            application.openURL(
                url = nsUrl,
                options = emptyMap<Any?, Any?>(),
                completionHandler = null
            )
        }
    }
}