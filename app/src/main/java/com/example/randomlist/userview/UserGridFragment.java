package com.example.randomlist.userview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomlist.R;

import java.util.ArrayList;
import java.util.Random;

public class UserGridFragment extends Fragment {

    final private String[] fnms = {"Костянтин", "Ігор", "Мирослав", "Ярослава", "Катерина",
            "Валентина", "Дмитро", "Ілля", "Вадим", "Тимофій"};
    final private String[] lnms = {"Панасюк", "Іванченко", "Антоненко", "Броварчук", "Романченко",
            "Гнатюк", "Василенко", "Крамаренко", "Шевченко", "Васильчук"};
    final private String[] cntrs = {"Ukraine", "Poland", "Germany"};
    final private String[] cts = {"Rivne", "Vinnitsa", "Lviv", "Dnipro", "Ternopil",
            "Krakow", "Wroclaw", "Warsaw", "Lublin", "Gdansk",
            "Berlin", "Aachen", "Bremen", "Hamburg", "Dresden"};
    final private String[] imgs = {"https://cdn3.iconfinder.com/data/icons/business-avatar-1/512/3_avatar-512.png",
            "https://www.businesstyc.com/wp-content/uploads/2019/03/avataaars.png",
            "https://koolinus.files.wordpress.com/2019/03/avataaars-e28093-koolinus-1-12mar2019.png",
            "https://cdn.pixabay.com/photo/2016/11/01/21/11/avatar-1789663_960_720.png",
            "https://cdn.iconscout.com/icon/free/png-512/avatar-367-456319.png"};

    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_grid, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),
                1, GridLayoutManager.VERTICAL, false));

        ArrayList<UserModel>userlist = new ArrayList<>();

        randList(userlist);

        UserViewAdapter userAdapter = new UserViewAdapter(userlist);
        recyclerView.setAdapter(userAdapter);

        return view;
    }

    public void randList(ArrayList<UserModel>userlist){
        Random random = new Random();

        for (int i = 0; i < 10; i++){
            int fnm = random.nextInt(4);
            int lnm = random.nextInt(4);
            int age = random.nextInt(86) + 14;
            int cntr = random.nextInt(2);
            int city = 0;
            switch (cntr){
                case 0:
                    city = random.nextInt(4);
                    break;
                case 1:
                    city = random.nextInt(5) + 5;
                    break;
                case 2:
                    city = random.nextInt(5) + 10;
                    break;
            }
            int img = random.nextInt(4);

            userlist.add(new UserModel(fnms[fnm], lnms[lnm], age, cntrs[cntr], cts[city], imgs[img]));
        }
    }
}
