package net.roocky.constant;

/**
 * Created by lenovo on 2016/9/14.
 */
public interface Contants {

  /*  //头部viewpager
    String HEAD_VP="http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getSlideshow";
    //头条数据接口：
    String HEADLINES="http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getHeadlines";
    //百科(16)、资讯(52)、数据(54)、经营(53)列表数据获取的接口：
    String OTHER="http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getListByType&page=0&rows=20&type=%d";
*/
    //Base URL
    String BASE_URL = "http://sns.maimaicha.com/";

    //头部轮播图片
    String HEADPIC_URL = "api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getSlideshow";

    //头部轮播图片
    String TOUTIAO_URL = "api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getHeadlines";

    //百科(16)、资讯(52)、数据(54)、经营(53)列表数据获取的接口
    String OTHERFRAG_URL = "api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getListByType&page=0&rows=20&type=%d";

}
