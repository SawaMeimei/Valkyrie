package sawa.android.reader.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sawa.android.reader.R;
import sawa.android.reader.R2;
import sawa.android.reader.common.BaseActivity;
import sawa.android.reader.common.PlusImageView;

/**
 * Created by hasee on 2017/3/19.
 */
public class WebViewActivity extends BaseActivity {

    protected WebViewActivityViewWrapper view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = View.inflate(this, R.layout.activity_web_view, null);
        view = new WebViewActivityViewWrapper(rootView);
        view.webViewNestedScrollView().addView(new WebView(getApplicationContext()));
        setWindowStatusBarColor(this, android.R.color.transparent);
        setContentView(view.rootView());

        setSupportActionBar(view.toolbar());
        view.toolbar().setTitle("");
        view.toolbarLayout().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        view.contentWebView().destroy();
        view.webViewNestedScrollView().removeAllViews();
    }
}
