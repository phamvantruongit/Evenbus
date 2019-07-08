package vn.com.it.truongpham.evenbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void OnCustomEvent(CustomEvent customEvent) {
        customEvent=EventBus.getDefault().getStickyEvent(CustomEvent.class);
        if(customEvent!=null) {
            CustomItem customItem = customEvent.customItem;
            TextView tvContent = findViewById(R.id.tvContent);
            tvContent.setText(customItem.name + "\t" + customItem.address);
            EventBus.getDefault().removeStickyEvent(customEvent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
