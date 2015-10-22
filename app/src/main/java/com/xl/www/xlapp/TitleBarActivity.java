package com.xl.www.xlapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import utils.UIUtils;


/**
 * 最有TitleBar的Activity 可以自定义左中右控件
 */
public abstract class TitleBarActivity extends FragmentActivity {
    public LinearLayout mContentView;
    TitleBar mBar;
    private boolean mDone = true;
    private View mTitleBarView;
    private boolean misFinish = true;

    @Override
    public void setContentView(int layoutResID) {
        initTitle();
        // mContentView 必须是 LinearLayout
        mContentView = (LinearLayout) getLayoutInflater().inflate(layoutResID,
                null);
        mContentView.addView(mTitleBarView, 0);
        super.setContentView(mContentView);
    }

    @Override
    public void setContentView(View view) {
        initTitle();

        // mContentView 必须是 LinearLayout
        mContentView = (LinearLayout) view;
        mContentView.addView(mTitleBarView, 0);
        super.setContentView(mContentView);
    }

    public View getTitleBar() {
        return mTitleBarView;
    }

    private void initTitle() {
        mBar = new TitleBar();
        mBar.setListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.left_layout:
                    case R.id.leftbar:
                        if (misFinish)
                            //TitleBarActivity.this.finish();
                            TitleBarActivity.this.finish();
                        break;

                    default:
                        break;
                }
                onTitleBarItemClicked(v);
            }
        });
        showRightBar(false, null);
        showLeftBar(false);
    }

    protected abstract void onTitleBarItemClicked(View v);

    public void setTitleBarTitle(SpannableString title) {
        if (mBar.mMiddlebar != null)
            mBar.mMiddlebar.setText(title);
    }

    public void showLactionBar(boolean show) {
        mBar.mLocationBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showLactionBar(boolean show, String text) {
        if (text != null) {
            mBar.mLocationBar.setText(text);
        }
        mBar.mLocationBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showLactionBar(String text) {
        if (text != null) {
            mBar.mLocationBar.setText(text);
        }
    }

    public void showLeftBar(boolean show) {
        mBar.mLeftbar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showLeftBar(boolean show, String text, int id) {
        if (text != null) {
            mBar.mLeftbar.setText(text);
        }
        if (id != 0) {
            mBar.mLeftbar.setBackgroundResource(id);
        }
        mBar.mLeftbar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showLeftBar(boolean show, String text, int id, boolean isFinish) {
        if (text != null) {
            mBar.mLeftbar.setText(text);
        }

        if (id != 0) {
            mBar.mLeftbar.setBackgroundResource(id);
        }
        mBar.mLeftbar.setVisibility(show ? View.VISIBLE : View.GONE);
        misFinish = isFinish;
    }

    public void showRightBar(boolean show, String text) {
        if (text != null) {
            mBar.mRightbar.setText(text);
        }
        mBar.mRightbar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showRightBar(boolean show) {
        mBar.mRightbar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showRightBar(boolean show, String text, int id) {
        if (text != null) {
            mBar.mRightbar.setText(text);
        }
        if (id != 0) {
            mBar.mRightbar.setBackgroundResource(id);
        }
        mBar.mRightbar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showAttachBar(boolean show, String text) {
        if (text != null) {
            mBar.mAttach.setText(text);
        }
        mBar.mAttach.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showTipBar(boolean show) {
        mBar.mTipbar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showRightBar(boolean show, int id, int color) {
        mBar.mRightbar.setText("");
        mBar.mRightbar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public TextView getTitleBarTitle() {
        return mBar.mMiddlebar;
    }

    public void setTitleBarTitle(String title) {
        if (mBar.mMiddlebar != null)
            mBar.mMiddlebar.setText(title);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        mDone = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    @Override
    public void startActivity(Intent intent) {
        if (mDone) {// 防止陷入死循环
            mDone = false;
        } else {
            super.startActivity(intent);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
//        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void startActivityNoAm(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    class TitleBar {
        FrameLayout mLeft;
        TextView mLeftbar;
        TextView mTipbar;
        TextView mMiddlebar;
        TextView mRightbar;
        TextView mLocationBar;
        TextView mAttach;
        private OnClickListener mClickListener;

        public TitleBar() {
            mTitleBarView = getLayoutInflater()
                    .inflate(R.layout.titlebar, null);
            RelativeLayout layout = (RelativeLayout) mTitleBarView
                    .findViewById(R.id.titleRoot);
            LayoutParams p = new LayoutParams(LayoutParams.MATCH_PARENT,
                    UIUtils.dip2px(getApplicationContext(), 45));
            layout.setLayoutParams(p);
            mLeft = (FrameLayout) mTitleBarView.findViewById(R.id.left_layout);
            mLocationBar = (TextView) mTitleBarView.findViewById(R.id.rightLactionbar);
            mLeftbar = (TextView) mTitleBarView.findViewById(R.id.leftbar);
            mMiddlebar = (TextView) mTitleBarView.findViewById(R.id.middlebar);
            mRightbar = (TextView) mTitleBarView.findViewById(R.id.rightbar);
            mAttach = (TextView) mTitleBarView.findViewById(R.id.attachbar);
            mTipbar = (TextView) mTitleBarView.findViewById(R.id.tip);
            UIUtils.expandViewTouchDelegate(mLeftbar, 200, 200, 200, 200);
//            UIUtils.expandViewTouchDelegate(mRightbar, 150, 150, 150, 150);
        }

        public void setListener(OnClickListener listener) {
            mClickListener = listener;
            mBar.mLeft.setOnClickListener(mClickListener);
            mBar.mLeftbar.setOnClickListener(mClickListener);
            mBar.mMiddlebar.setOnClickListener(mClickListener);
            mBar.mRightbar.setOnClickListener(mClickListener);
            mBar.mLocationBar.setOnClickListener(mClickListener);
        }
    }

}
