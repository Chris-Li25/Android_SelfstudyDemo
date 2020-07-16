package chris.li.selfstudy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {  //BaseActivity 继承了AppCompatActivity因此现有功能并不受影响，可以知道当前页面是哪个活动

    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }
    //利用在SecondActivity中自定义的方法，不仅让他人更直观了解改该活动需要的参数，也让启动变得更加简单。


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("SecondActivity","Task id is "+getTaskId());
//
//        Intent intent = getIntent();   //getIntent()方法获取到用于启动的SecondActivity的Intent。
//        String data = intent.getStringExtra("extra_data");  //然后调用getString Extra()方法，传入相应的键值，就可以得到传递的数据了。
//        Log.d("SecondActivity",data);

        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("data_return","Hello FirstActivity");
//                setResult(RESULT_OK,intent); //专门用于向上一个活动返回处理结果，一般只是用RESULT_OK或RESULT_CANCELED这两个值，第二个参数则把带有数据的Intent传递回去，然后调用了finish()来销毁当前活动。
//                finish();

                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent); //专门用于向上一个活动返回处理结果，一般只是用RESULT_OK或RESULT_CANCELED这两个值，第二个参数则把带有数据的Intent传递回去，然后调用了finish()来销毁当前活动。
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }
}
