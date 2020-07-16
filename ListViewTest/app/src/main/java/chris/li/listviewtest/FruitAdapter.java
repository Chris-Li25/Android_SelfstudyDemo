package chris.li.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);

        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
//
//        if(convertView == null){
//            view = LayoutInflater.from(getContext().).inflate(resourceId,parent,false);
//        }else {
//            view = convertView;
//        }
//        //提升ListView的运行效率  加了判断，如果convertView为null则使用LayoutInflater去加载布局，如果不为null则直接对convertView进行重用
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //新增了一个内部类ViewHolder，用于对控件的实例进行缓存。当convertView为null的时候，创建一个ViewHolder对象，并将控件的实例都存放在ViewHolder里，然后调用View的setTag()方法
        //换ViewHolder对象存储在View中。当convertView不为null的时候，则调用View的getTag()方法，把convertView不为null的时候，则调用View的getTag()方法，把ViewHolder重新取出
        //这样所有控件的实例都缓存在了ViewHolder里，就没有必要每次都通过findViewById()方法来获取控件实例了。
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());



//        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

//        ImageView fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
//        TextView fruitName = (TextView)view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }

    //重写了父类的一组构造函数，用于将上下文、ListView子项布局的id和数据都传递进来。另外又重写了getView()方法，这个方法在每个子项被滚动到屏幕内的时候都会被调用，。
    //在getView()方法中，首先用过getItem()方法得到当前项的Fruit实例，然就使用LayoutInflater来为这个子项加载我们传入的布局。
}
