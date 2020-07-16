package chris.li.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FirstActivity extends BaseActivity {  //BaseActivity 继承了AppCompatActivity因此现有功能并不受影响，可以知道当前页面是哪个活动

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Log.d("FirstActivity","Task id is "+getTaskId());

        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();   //Toast
//                finish();    //结束Activity
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);      //通过显性Intent跳转界面
//                Intent intent = new Intent("chris.li.activitytest.ACTION_START");
//                intent.addCategory("chris.li.activitytest.MY_CATRGORY");
//                startActivity(intent);       //通过隐形Intent跳转界面
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://baidu.com"));           //将一个网址字符串解析成一个Uri对象，再调用Intent的setData()方法将这个Uri对象传递出去
                                                                            //字符串传入Uri.parse()方法中解析成数据给Intent
//                startActivity(intent);     //通过隐形Intent调用手机浏览器访问百度网
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));     //指定了协议是tel 号码是10086
//                startActivity(intent);       //通过隐形Intent调用手机拨号器拨打10086

//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);    //使用putExtra()方法接收两个参数，第一个参数是键，用于后面从Intent中取值，第二个参数才是真正要传递的数据
//                startActivity(intent);

//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1); //startActivityForResult()来启动SecondActivity，该方法接收两个参数，第一个参数还是Intent，第二个参数是请求码，用于在之后的回调中判断数据的来源，请求码只要是一个唯一值就可以了

//                Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
//                startActivity(intent);  //测试singleTop 和 standard启动模式的区别

//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);

                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
                //利用在SecondActivity中自定义的方法，不仅让他人更直观了解改该活动需要的参数，也让启动变得更加简单。
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  //三个参数，第一个requestCode请求码，第二个resultCode返回的处理结果，第三个参数data就是携带着返回数据的Intent。
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                    Toast.makeText(FirstActivity.this,returnedData,Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }
}

