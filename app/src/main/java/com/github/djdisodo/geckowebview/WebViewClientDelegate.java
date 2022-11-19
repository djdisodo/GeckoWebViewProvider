package com.github.djdisodo.geckowebview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

import org.mozilla.geckoview.GeckoSession;

public class WebViewClientDelegate implements GeckoSession.HistoryDelegate {
    WebView webView;
    public WebViewClient webViewClient;
    WebViewClientDelegate(WebViewClient wVC, WebView wV) {
        webViewClient = wVC;
        webView = wV;
    }

    @Override
    public void onHistoryStateChange(@NonNull GeckoSession session, @NonNull HistoryList historyList) {
        GeckoSession.HistoryDelegate.super.onHistoryStateChange(session, historyList);
        /*
        if (webViewClient != null) {
            int i = historyList.getCurrentIndex();
            HistoryItem item = historyList.get(i);
            webViewClient.doUpdateVisitedHistory(webView, item.getUri(), false); //TODO
        }
         */
    }
}
