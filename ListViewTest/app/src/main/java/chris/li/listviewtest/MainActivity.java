package chris.li.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data= {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango",
            "Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {    //数组中的数据是无法直接传递给ListView的，需要借助适配器来完成 ArrayAdapter
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this,android.R.layout.simple_list_item_1,data   //android.R.layout.simple_list_item_1是一个Android内置的布局文件，里面只有一个TextView，可用于简单地显示一段文本。
//        );

        initFruits();  //初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        //为ListView设置点击事件  使用setOnItemClickListener()方法为ListView注册了一个监听器，当用户点击了ListView中的任何一个子项时，就会回调onItemClick()方法。
        //这个方法中可以通过positon参数判断出用户点击的是哪一个子项，然后获取到相应的水果，并通过Toast将水果的名字显示出来。
    }

    private void initFruits(){
        for(int i=0; i<2; i++){
            Fruit apple = new Fruit("Apple",R.drawable.q1);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.q2);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.q3);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.q4);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear",R.drawable.q5);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.q6);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.q7);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.q8);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry",R.drawable.q9);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango",R.drawable.q10);
            fruitList.add(mango);

        }
    }

}
