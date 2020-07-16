package chris.li.recyclerviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);
            fruitName = (TextView) itemView.findViewById(R.id.fruit_name);

        }
    }

    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @NonNull
    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked view "+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked image "+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        //在ViewHolder中添加了fruitView变量来保存子项最外层布局的实例，然后在onCreateViewHolder()方法中注册点击事件就可以了。
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
    //可以看到，FruitAdapter继承了RecyclerView.Adapter，泛型是FruitAdapter.ViewHolder
    //ViewHolder是自己定义的内部类，它继承了RecyclerView.ViewHolder
    //然后在ViewHolder的构造函数里传入了一个View参数，这个参数通常就是RecyclerView子项的最外层布局，可以使用findViewById()方法，通过它获取到布局中的ImageView和TextView的实例。
    //继续往下看，FruitAdapter也有一个构造函数，这个方法用于把要展示的数据源传进来，并赋值给一个全局变量mFruitList，由于FruitAdapter继承自RecyclerView.Adapter,所有必须重写下面三个方法
    //
    //1.onCreateViewHolder用于创建ViewHolder实例，在这个方法中将fruit_item布局加载进来，然后创建一个ViewHolder实例，并把加载出来的布局传入到构造函数当中，最后将ViewHolder的实例返回。
    //
    //2.onBindViewHolder()方法是用于对RecyclerView子项的数据进行赋值的，会在每个子项被滚动到屏幕内的时候执行，这里通过position参数得到当前的Fruit实例，然后再将数据设置到ViewHolder的ImagerView和TextView中即可
    //
    //3.getItemCount() 就简单了，用于告诉RecyclerView一共有多少子项，直接返回数据源的长度就行了
}
