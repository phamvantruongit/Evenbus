package vn.com.it.truongpham.evenbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomItem customItem=new CustomItem("Pham Van Truong","Nam Dinh");
        EventBus.getDefault().postSticky(new CustomEvent(customItem));
        startActivity(new Intent(this,DetailActivity.class));
    }
}
