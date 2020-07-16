package chris.li.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button  = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.edit_text);
        imageView = (ImageView)findViewById(R.id.image_view);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
//                String inputText = editText.getText().toString();

//                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();

//                imageView.setImageResource(R.drawable.img_2);

//                if(progressBar.getVisibility() == View.GONE){  //若控件gone 则设置为可见 否则设置为gone
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                }

//                int progress = progressBar.getProgress();
//                progress = progress+10;
//                progressBar.setProgress(progress);    //获取进度条的当前进度，然后在现有的进度上加10作为更新后的进度

//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                //通过AlertDialog.Bulider创建一个AlertDialog的实例
//                dialog.setTitle("This is Dialog");
//                //为这个对话框设置标题
//                dialog.setMessage("Something important.");
//                //设置内容
//                dialog.setCancelable(false);
//                //设置可否取消
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                //设置确定按钮的点击事件
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                //设置取消按钮的点击事件
//                dialog.show();
//                //show()方法将对话框显示出来

//                ProgressDialog //弹出式进度条对话框，已被弃用。

                break;
            default:
                break;
        }
    }
}
