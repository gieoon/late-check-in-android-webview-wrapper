package com.example.tentenlatecheckin

import android.annotation.SuppressLint
import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tentenlatecheckin.ui.theme.TenTenLateCheckInTheme

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavascriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tenten_late_check_in_activity_webview)
        val mWebView = findViewById<WebView>(R.id.webView)
        mWebView.loadUrl("https://tenten-late-check-in.vercel.app")
        mWebView.webViewClient = TenTenLateCheckInClient()
        mWebView.settings.javaScriptEnabled = true
        WebView.setWebContentsDebuggingEnabled(false)
        this.webView = mWebView
    }

    private inner class TenTenLateCheckInClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//        if (Uri.parse(url).host == )
            return false // Always make URL's load inside the WebView
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
        }

//        override fun onBackPressed() {
//            // if your webview can go back it will go back
//            if (webView.canGoBack())
//                webView.goBack()
//            // if your webview cannot go back
//            // it will exit the application
//            else
//                super.onBackPressed()
//        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()) {
            this.webView.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }


//        setContent {
//            TenTenLateCheckInTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android");
//                }
//            }
//        }
    }

//    fun openWebPage(url: String) {
//        val webpage: Uri = Uri.parse("https://tenten-late-check-in.vercel.app")
//        val intent = Intent(Intent.ACTION_VIEW, webpage)
//        if (intent.resolveActivity(packageManager) != null) {
//            startActivity(intent)
//        }
//
//    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TenTenLateCheckInTheme {
        Greeting("Android")
    }
}