package chris.li.activitytest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity{  //BaseActivity 继承了AppCompatActivity因此现有功能并不受影响，可以知道当前页面是哪个活动

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d("ThirdActivity", "Task id is "+getTaskId());

        Button button3 = (Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();  //直接退出应用程序。
            }
        });
    }
}
