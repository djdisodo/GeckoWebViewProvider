package com.github.djdisodo.geckowebview;


import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.TokenBindingService;
import android.webkit.TracingController;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.webkit.WebViewProvider;

import com.github.djdisodo.WebViewFactoryProvider;
import com.github.djdisodo.WebViewPrivateAccess;

public class GeckoWebViewFactoryProvider implements WebViewFactoryProvider {

    @Override
    public WebViewProvider createWebView(WebView webView, WebViewPrivateAccess privateAccess) {
        return null;
    }

    @Override
    public Statics getStatics() {
        return null; //TODO
    }

    @Override
    public GeolocationPermissions getGeolocationPermissions() {
        return null; //TODO
    }

    @Override
    public CookieManager getCookieManager() {
        return null; //TODO
    }

    @Override
    public TokenBindingService getTokenBindingService() {
        return null; //TODO
    }

    @Override
    public TracingController getTracingController() {
        return null; //TODO
    }

    @Override
    public ServiceWorkerController getServiceWorkerController() {
        return null; //TODO
    }

    @Override
    public WebIconDatabase getWebIconDatabase() {
        return null; //TODO
    }

    @Override
    public WebStorage getWebStorage() {
        return null; //TODO
    }

    @Override
    public WebViewDatabase getWebViewDatabase(Context context) {
        return null; //TODO
    }

    @Override
    public ClassLoader getWebViewClassLoader() {
        return ClassLoader.getSystemClassLoader(); //TODO
    }
}
