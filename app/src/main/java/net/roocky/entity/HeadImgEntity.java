package net.roocky.entity;

import java.util.List;

/**
 * Created by lenovo on 2016/9/14.
 */
public class HeadImgEntity {

    /**
     * id : 5613
     * title : 茶百科androidV1.2新功能简介
     * name : 茶百科androidV1.2新功能简介
     * link : http://sns.maimaicha.com/news/detail/5613
     * content : 1、	更新页面布局，增加首次登陆提示页。
     2、	增加栏目导航，按照分类列表展示。
     * image : http://s1.sns.maimaicha.com/images/2013/04/18/b0a9fed6aaef278fb5061b194c63d088.jpg
     * image_s : http://s1.sns.maimaicha.com/images/2013/04/18/9866411d3f679484822a286d58975956.jpg
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String image;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
