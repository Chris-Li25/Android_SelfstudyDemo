package chris.li.fragmenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AnotherRightFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.another_right_fragment,container,false);
        return view;
    }

    MainActivity activity = (MainActivity) getActivity();
    //通过getActivity()方法来得到和当前碎片相关联的活动实例。另外当碎片当中需要使用Context对象时，也可以使用getActivity()方法，因为获取到的活动本身就是一个Context对象。

}
