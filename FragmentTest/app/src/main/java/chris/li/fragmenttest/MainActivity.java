package chris.li.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
//        replaceFragment(new RightFragment());
//        RightFragment rightFragment = (RightFragment) getSupportFragmentManager().findFragmentById(R.id.right_layout);
        //该方法可以在活动中得到相应碎片的实例，然后就能轻松地调用碎片里的方法了。
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
//                replaceFragment(new AnotherRightFragment());
                Toast.makeText(MainActivity.this, "test",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

//    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.right_layout,fragment);
//        transaction.addToBackStack(null);//addToBackStack()方法用于将一个事务添加到返回栈中，可以接收一个名字用于描述返回栈的状态，一般传入null即可。
//        transaction.commit();
//    }

    //首先给左侧碎片中的案件注册了一个点击事件按，然后调用replaceFragment()方法动态添加了RightFragment这个碎片。
    //当点击左侧碎片中的按钮时，又会调用replaceFragment()方法将右侧碎片替换成AnotherRightFragment。
    //动态添加碎片主要分为5步
    //（1）创建待添加的碎片实例。
    //（2）获取FragmentManager，在活动中可以直接调用个getSupportFragmManager()方法得到
    //（3）开启一个事务，通过调用beginTransaction()方法开启。
    //（4）项容器内添加或替换碎片，一般使用replace()方法实现，需要传入容器的id和待添加的碎片实例。
    //（5）提交事务，调用commit()方法来完成
}
