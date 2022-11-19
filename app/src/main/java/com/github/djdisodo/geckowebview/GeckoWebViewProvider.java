package com.github.djdisodo.geckowebview;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewProvider;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;

import androidx.annotation.Nullable;

import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;
import org.mozilla.geckoview.GeckoWebExecutor;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

public class GeckoWebViewProvider implements WebViewProvider {
    GeckoWebViewProvider(WebView wV) {
        webView = wV;
    }
    private GeckoView geckoView;
    private GeckoSession geckoSession;
    private WebViewClient webViewClient;
    final private WebView webView;
    @Override
    public void init(Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
        geckoView = new GeckoView(webView.getContext());
        geckoSession = geckoView.getSession();
        //TODO privatebrowsing
    }

    @Override
    public void setHorizontalScrollbarOverlay(boolean overlay) {
        //TODO
    }

    @Override
    public void setVerticalScrollbarOverlay(boolean overlay) {
        //TODO
    }

    @Override
    public boolean overlayHorizontalScrollbar() {
        return false; //TODO
    }

    @Override
    public boolean overlayVerticalScrollbar() {
        return false; //TODO
    }

    @Override
    public int getVisibleTitleHeight() {
        return 0; //TODO
    }

    @Override
    public SslCertificate getCertificate() {
        return null; //TODO
    }

    @Override
    public void setCertificate(SslCertificate certificate) {
        //TODO
    }

    @Override
    public void savePassword(String host, String username, String password) {
        //TODO
    }

    @Override
    public void setHttpAuthUsernamePassword(String host, String realm, String username, String password) {
        //TODO
    }

    @Override
    public String[] getHttpAuthUsernamePassword(String host, String realm) {
        return new String[0]; //TODO
    }

    @Override
    public void destroy() {
        geckoView = null;
    }

    @Override
    public void setNetworkAvailable(boolean networkUp) {
        //TODO
    }

    @Override
    public WebBackForwardList saveState(Bundle outState) {
        return null; //TODO
    }

    @Override
    public boolean savePicture(Bundle b, File dest) {
        return false; //TODO
    }

    @Override
    public boolean restorePicture(Bundle b, File src) {
        return false; //TODO
    }

    @Override
    public WebBackForwardList restoreState(Bundle inState) {
        return null;
    }

    @Override
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        geckoSession.load(
                new GeckoSession.Loader().additionalHeaders(additionalHttpHeaders).uri(url)
        );
    }

    @Override
    public void loadUrl(String url) {
        geckoSession.loadUri(url);
    }

    @Override
    public void postUrl(String url, byte[] postData) {
        //todo
    }

    @Override
    public void loadData(String data, String mimeType, String encoding) {
        //TODO
    }

    @Override
    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        //TODO
    }

    @Override
    public void evaluateJavaScript(String script, ValueCallback<String> resultCallback) {
        //TODO
    }

    @Override
    public void saveWebArchive(String filename) {
        //TODO
    }

    @Override
    public void saveWebArchive(String basename, boolean autoname, ValueCallback<String> callback) {
        //TODO
    }

    @Override
    public void stopLoading() {
        //TODO
    }

    @Override
    public void reload() {
        geckoSession.reload();
    }

    @Override
    public boolean canGoBack() {
        return true; //TODO
    }

    @Override
    public void goBack() {
        geckoSession.goBack();
    }

    @Override
    public boolean canGoForward() {
        return true; //TODO
    }

    @Override
    public void goForward() {
        geckoSession.goForward();
    }

    @Override
    public boolean canGoBackOrForward(int steps) {
        return true; //TODO
    }

    @Override
    public void goBackOrForward(int steps) {
        for (int i = Math.abs(steps); i > 0; i--) {
            if (steps > 0) {
                geckoSession.goForward();
            } else {
                geckoSession.goBack();
            }
        }
    }

    @Override
    public boolean isPrivateBrowsingEnabled() {
        return false; //TODO
    }

    @Override
    public boolean pageUp(boolean top) {
        return false; //TODO
    }

    @Override
    public boolean pageDown(boolean bottom) {
        return false; //TODO
    }

    @Override
    public void insertVisualStateCallback(long requestId, WebView.VisualStateCallback callback) {
        //TODO
    }

    @Override
    public void clearView() {
        //TODO
    }

    @Override
    public Picture capturePicture() {
        return null; //TODO
    }

    @Override
    public PrintDocumentAdapter createPrintDocumentAdapter(String documentName) {
        return null; //TODO
    }

    @Override
    public float getScale() {
        return 1.0F; //TODO
    }

    @Override
    public void setInitialScale(int scaleInPercent) {
        //TODO
    }

    @Override
    public void invokeZoomPicker() {
        //TODO
    }

    @Override
    public WebView.HitTestResult getHitTestResult() {
        return null; //TODO
    }

    @Override
    public void requestFocusNodeHref(Message hrefMsg) {
        //TODO
    }

    @Override
    public void requestImageRef(Message msg) {
        //TODO
    }

    @Override
    public String getUrl() {
        return "http://fix.GeckoWebViewProvider.getUrl/"; //TODO
    }

    @Override
    public String getOriginalUrl() {
        return "http://fix.GeckoWebViewProvider.getOriginalUrl/"; //TODO
    }

    @Override
    public String getTitle() {
        return "fix getTitle"; //TODO
    }

    @Override
    public Bitmap getFavicon() {
        return null; //TODO
    }

    @Override
    public String getTouchIconUrl() {
        return null; //TODO
    }

    @Override
    public int getProgress() {
        return 0; //TODO
    }

    @Override
    public int getContentHeight() {
        return 0; //TODO
    }

    @Override
    public int getContentWidth() {
        return 0; //TODO
    }

    @Override
    public void pauseTimers() {
        //TODO
    }

    @Override
    public void resumeTimers() {
        //TODO
    }

    @Override
    public void onPause() {
        //TODO
    }

    @Override
    public void onResume() {
        //TODO
    }

    @Override
    public boolean isPaused() {
        return false; //TODO
    }

    @Override
    public void freeMemory() {
        //TODO
    }

    @Override
    public void clearCache(boolean includeDiskFiles) {
        //TODO
    }

    @Override
    public void clearFormData() {
        //TODO
    }

    @Override
    public void clearHistory() {
        geckoSession.purgeHistory();
    }

    @Override
    public void clearSslPreferences() {
        //TODO
    }

    @Override
    public WebBackForwardList copyBackForwardList() {
        return null; //TODO
    }

    @Override
    public void setFindListener(WebView.FindListener listener) {
        //TODO
    }

    @Override
    public void findNext(boolean forward) {
        //TODO
    }

    @Override
    public int findAll(String find) {
        return 0; //TODO
    }

    @Override
    public void findAllAsync(String find) {
        //TODO
    }

    @Override
    public boolean showFindDialog(String text, boolean showIme) {
        return false; //TODO
    }

    @Override
    public void clearMatches() {
        //TODO
    }

    @Override
    public void documentHasImages(Message response) {
        //TODO
    }

    @Override
    public void setWebViewClient(WebViewClient client) {
        webViewClient = client;
        geckoSession.setHistoryDelegate(new WebViewClientDelegate(client, webView));
    }

    @Override
    public WebViewClient getWebViewClient() {
        return webViewClient;
    }

    @Nullable
    @Override
    public WebViewRenderProcess getWebViewRenderProcess() {
        return null; //TODO
    }

    @Override
    public void setWebViewRenderProcessClient(@Nullable Executor executor, @Nullable WebViewRenderProcessClient client) {
        //TODO
    }

    @Nullable
    @Override
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return null; //TODO
    }

    @Override
    public void setDownloadListener(DownloadListener listener) {
        //TODO
    }

    @Override
    public void setWebChromeClient(WebChromeClient client) {
        //TODO
    }

    @Override
    public WebChromeClient getWebChromeClient() {
        return null; //TODO
    }

    @Override
    public void setPictureListener(WebView.PictureListener listener) {
        //TODO
    }

    @Override
    public void addJavascriptInterface(Object obj, String interfaceName) {
        //TODO
    }

    @Override
    public void removeJavascriptInterface(String interfaceName) {
        //TODO
    }

    @Override
    public WebMessagePort[] createWebMessageChannel() {
        return new WebMessagePort[0]; //TODO
    }

    @Override
    public void postMessageToMainFrame(WebMessage message, Uri targetOrigin) {
        //TODO
    }

    @Override
    public WebSettings getSettings() {
        return null; //TODO
    }

    @Override
    public void setMapTrackballToArrowKeys(boolean setMap) {
        //TODO
    }

    @Override
    public void flingScroll(int vx, int vy) {
        //TODO
    }

    @Override
    public View getZoomControls() {
        return null; //TODO
    }

    @Override
    public boolean canZoomIn() {
        return false; //TODO
    }

    @Override
    public boolean canZoomOut() {
        return false; //TODO
    }

    @Override
    public boolean zoomBy(float zoomFactor) {
        return false; //TODO
    }

    @Override
    public boolean zoomIn() {
        return false; //TODO
    }

    @Override
    public boolean zoomOut() {
        return false; //TODO
    }

    @Override
    public void dumpViewHierarchyWithProperties(BufferedWriter out, int level) {
        //TODO
    }

    @Override
    public View findHierarchyView(String className, int hashCode) {
        return null; //TODO
    }

    @Override
    public void setRendererPriorityPolicy(int rendererRequestedPriority, boolean waivedWhenNotVisible) {
        //TODO
    }

    @Override
    public int getRendererRequestedPriority() {
        return 0; //TODO
    }

    @Override
    public boolean getRendererPriorityWaivedWhenNotVisible() {
        return false; //TODO
    }

    @Override
    public ViewDelegate getViewDelegate() {
        return new ViewDelegate() {

            @Override
            public boolean shouldDelayChildPressedState() {
                return false;
            }

            @Override
            public void onProvideVirtualStructure(ViewStructure structure) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    geckoView.onProvideVirtualStructure(structure);
                }
            }

            @Override
            public AccessibilityNodeProvider getAccessibilityNodeProvider() {
                return geckoView.getAccessibilityNodeProvider();
            }

            @Override
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                //TODO
            }

            @Override
            public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
                geckoView.onInitializeAccessibilityEvent(event);
            }

            @Override
            public boolean performAccessibilityAction(int action, Bundle arguments) {
                return geckoView.performAccessibilityAction(action, arguments);
            }

            @Override
            public void setOverScrollMode(int mode) {
                geckoView.setOverScrollMode(mode);
            }

            @Override
            public void setScrollBarStyle(int style) {
                geckoView.setScrollBarStyle(style);
            }

            @Override
            public void onDrawVerticalScrollBar(Canvas canvas, Drawable scrollBar, int l, int t, int r, int b) {
                //TODO
            }

            @Override
            public void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
                //TODO
            }

            @Override
            public void onWindowVisibilityChanged(int visibility) {
                geckoView.dispatchWindowVisibilityChanged(visibility);
            }

            @Override
            public void onDraw(Canvas canvas) {
                geckoView.draw(canvas);
            }

            @Override
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                geckoView.setLayoutParams(layoutParams);
            }

            @Override
            public boolean performLongClick() {
                return geckoView.performLongClick();
            }

            @Override
            public void onConfigurationChanged(Configuration newConfig) {
                geckoView.dispatchConfigurationChanged(newConfig);
            }

            @Override
            public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
                return geckoView.onCreateInputConnection(outAttrs);
            }

            @Override
            public boolean onDragEvent(DragEvent event) {
                return geckoView.onDragEvent(event);
            }

            @Override
            public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
                return geckoView.onKeyMultiple(keyCode, repeatCount, event);
            }

            @Override
            public boolean onKeyDown(int keyCode, KeyEvent event) {
                return geckoView.onKeyDown(keyCode, event);
            }

            @Override
            public boolean onKeyUp(int keyCode, KeyEvent event) {
                return geckoView.onKeyUp(keyCode, event);
            }

            @Override
            public void onAttachedToWindow() {
                geckoView.onAttachedToWindow();
            }

            @Override
            public void onDetachedFromWindow() {
                geckoView.onDetachedFromWindow();
            }

            @Override
            public void onVisibilityChanged(View changedView, int visibility) {
                geckoView.setVisibility(visibility); //TODO clarify
            }

            @Override
            public void onWindowFocusChanged(boolean hasWindowFocus) {
                geckoView.onWindowFocusChanged(hasWindowFocus);
            }

            @Override
            public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
                //TODO
            }

            @Override
            public boolean setFrame(int left, int top, int right, int bottom) {
                return false; //TODO
            }

            @Override
            public void onSizeChanged(int w, int h, int ow, int oh) {
                //TODO
            }

            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                //TODO
            }

            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                return geckoView.dispatchKeyEvent(event);
            }

            @Override
            public boolean onTouchEvent(MotionEvent ev) {
                return geckoView.dispatchTouchEvent(ev);
            }

            @Override
            public boolean onHoverEvent(MotionEvent event) {
                return geckoView.onHoverEvent(event);
            }

            @Override
            public boolean onGenericMotionEvent(MotionEvent event) {
                return geckoView.onGenericMotionEvent(event);
            }

            @Override
            public boolean onTrackballEvent(MotionEvent ev) {
                return geckoView.onTrackballEvent(ev);
            }

            @Override
            public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
                return geckoView.requestFocus(direction, previouslyFocusedRect);
            }

            @Override
            public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                geckoView.measure(widthMeasureSpec, heightMeasureSpec);
            }

            @Override
            public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
                return requestChildRectangleOnScreen(child, rect, immediate);
            }

            @Override
            public void setBackgroundColor(int color) {
                geckoView.setBackgroundColor(color);
            }

            @Override
            public void setLayerType(int layerType, Paint paint) {
                geckoView.setLayerType(layerType, paint);
            }

            @Override
            public void preDispatchDraw(Canvas canvas) {
                //TODO
            }

            @Override
            public void onStartTemporaryDetach() {
                geckoView.onStartTemporaryDetach();
            }

            @Override
            public void onFinishTemporaryDetach() {
                geckoView.onFinishTemporaryDetach();
            }

            @Override
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                //TODO
            }

            @Override
            public Handler getHandler(Handler originalHandler) {
                return geckoView.getHandler();
            }

            @Override
            public View findFocus(View originalFocusedView) {
                return geckoView.findFocus();
            }
        }; //TODO
    }

    @Override
    public ScrollDelegate getScrollDelegate() {
        return new ScrollDelegate() {
            @Override
            public int computeHorizontalScrollRange() {
                return 0;
            }

            @Override
            public int computeHorizontalScrollOffset() {
                return 0;
            }

            @Override
            public int computeVerticalScrollRange() {
                return 0;
            }

            @Override
            public int computeVerticalScrollOffset() {
                return 0;
            }

            @Override
            public int computeVerticalScrollExtent() {
                return 0;
            }

            @Override
            public void computeScroll() {

            }
        }; //TODO
    }

    @Override
    public void notifyFindDialogDismissed() {

    }
}
