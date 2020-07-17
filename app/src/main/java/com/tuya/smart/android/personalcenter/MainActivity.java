package com.tuya.smart.android.personalcenter;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tuya.smart.android.demo.R;
import com.tuya.smart.api.MicroContext;
import com.tuya.smart.api.router.UrlBuilder;
import com.tuya.smart.api.router.UrlRouter;
import com.tuya.smart.demo_login.base.utils.ActivityUtils;
import com.tuya.smart.feedback.api.FeedbackService;
import com.tuya.smart.message.base.activity.message.MessageContainerActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button mActivityMessageBtn;
    private Button mRouteMessageBtn;
    private Button mFeedbackServiceBtn;
    private Button mFeedbackRouteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mActivityMessageBtn = findViewById(R.id.btn_message_start);
        mRouteMessageBtn  = findViewById(R.id.btn_message_route);
        mFeedbackServiceBtn = findViewById(R.id.btn_feedback_service);
        mFeedbackRouteBtn = findViewById(R.id.btn_feedback_route);
        mFeedbackServiceBtn.setOnClickListener(this);
        mFeedbackRouteBtn.setOnClickListener(this);
        mActivityMessageBtn.setOnClickListener(this);
        mRouteMessageBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_message_start) {
            ActivityUtils.gotoActivity(MainActivity.this,
                        MessageContainerActivity.class,
                        ActivityUtils.ANIMATE_SLIDE_TOP_FROM_BOTTOM,
                        false);
        } else if (v.getId() == R.id.btn_message_route) {
            UrlRouter.execute(new UrlBuilder(MainActivity.this, "messageCenter"));
        } else if (v.getId() == R.id.btn_feedback_service) {
            FeedbackService feedbackService = MicroContext.findServiceByInterface(FeedbackService.class.getName());
            if (feedbackService != null) {
                feedbackService.jumpToWebHelpPage(MainActivity.this);
            }
        } else if (v.getId() == R.id.btn_feedback_route) {
            UrlRouter.execute(UrlRouter.makeBuilder(MainActivity.this, "helpCenter"));
        }
    }
}
