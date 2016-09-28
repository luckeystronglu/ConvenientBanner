package net.roocky.util;


import net.roocky.constant.Contants;
import net.roocky.entity.HeadImgEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2016/9/11.
 */
public interface JsonUtil {


    @GET(Contants.HEADPIC_URL)
    Call<HeadImgEntity> getpicDatas();

//    @GET(Contants.TOUTIAO_URL)
//    Call<HeadLineEntity> getheadlineDatas();
//
//    @GET(Contants.OTHERFRAG_URL)
//    Call<HeadLineEntity> getOtherDatas(@Query("type") int type);


}
