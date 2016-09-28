package net.roocky.convenientbanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.facebook.drawee.backends.pipeline.Fresco;

import net.roocky.constant.Contants;
import net.roocky.entity.HeadImgEntity;
import net.roocky.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ConvenientBanner convenientBanner;
//    private String[] images = {
//            "http://pic3.zhimg.com/da1fcaf6a02d1223d130d5b106e828b9.jpg",
//            "http://p1.zhimg.com/dd/f1/ddf10a04227ea50fd59746dbcd13c728.jpg",
//            "http://p3.zhimg.com/64/5c/645cde143c9a371005f3f749366cffad.jpg"
//    };
    private List<String> strList = new ArrayList<>();
    private List<String> strList2 = new ArrayList<>();
    private String[] images;
    private String[] titles;

    private List<BannerItem> bannerItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        convenientBanner = (ConvenientBanner)findViewById(R.id.convenientBanner);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonUtil util = retrofit.create(JsonUtil.class);
        Call<HeadImgEntity> call = util.getpicDatas();
        call.enqueue(new Callback<HeadImgEntity>() {
            @Override
            public void onResponse(Call<HeadImgEntity> call, Response<HeadImgEntity> response) {
                List<HeadImgEntity.DataBean> list = response.body().getData();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getImage() != null) {
                        strList.add(list.get(i).getImage());
                    }
                }

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getTitle() != null) {
                        strList2.add(list.get(i).getTitle());
                    }
                }

                images = new String[strList.size()];
                for (int i = 0; i < strList.size(); i++) {
                    images[i] = strList.get(i);
                }

                titles = new String[strList2.size()];
                for (int i = 0; i < strList2.size(); i++) {
                    titles[i] = strList2.get(i);
                }

                //生成所需的数据
                for (int i = 0; i < images.length; i ++) {
                    bannerItems.add(new BannerItem(titles[i], images[i]));
                }

                convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView();
                    }
                }, bannerItems)
                        .setPageIndicator(new int[] {R.drawable.dot_unselected, R.drawable.dot_selected})
                        .setPointViewVisible(true)    //设置指示器是否可见
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                        .startTurning(2000);
//                        .setPageIndicator(new int[] {R.drawable.dot_unselected, R.drawable.dot_selected})
//                        .setPointViewVisible(true)    //设置指示器是否可见
//                        .setPageIndicator(new int[]{R.drawable.dot_unselected, R.drawable.dot_selected})   //设置指示器圆点
//                        .startTurning(5000)     //设置自动切换（同时设置了切换时间间隔）
//                        .stopTurning()    //关闭自动切换
//                        .setManualPageable(false)  //设置手动影响（设置了该项无法手动切换）
//                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT) //设置指示器位置（左、中、右）
//                        .setOnItemClickListener(this); //设置点击监听事件

            }

            @Override
            public void onFailure(Call<HeadImgEntity> call, Throwable t) {

            }
        });




    }
}
