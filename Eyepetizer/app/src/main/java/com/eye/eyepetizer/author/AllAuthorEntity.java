package com.eye.eyepetizer.author;

import java.util.List;

/**
 * Created by dllo on 16/8/31.
 */
public class AllAuthorEntity {

    /**
     * itemList : [{"type":"briefCard","data":{"dataType":"BriefCard","id":232,"icon":"http://img.kaiyanapp.com/10a34f3360972e8530d7f3856cd4b722.jpeg","title":"集舞视界","subTitle":"2 个视频","description":"DanceFocus，聚焦你的舞蹈！","actionUrl":"eyepetizer://pgc/detail/232/?title=%E9%9B%86%E8%88%9E%E8%A7%86%E7%95%8C","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":230,"icon":"http://img.kaiyanapp.com/1e0c1cc19a8a638898a23b8e3f33b7af.jpeg","title":"箴贺","subTitle":"1 个视频","description":"导演/摄影","actionUrl":"eyepetizer://pgc/detail/230/?title=%E7%AE%B4%E8%B4%BA","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":228,"icon":"http://img.wdjimg.com/image/video/19c7c03d61cacf97ba9e77fb81244867_0_0.jpeg","title":"adidas Originals","subTitle":"5 个视频","description":"NMD_超越过去 ，再创未来","actionUrl":"eyepetizer://pgc/detail/228/?title=adidas%20Originals","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":226,"icon":"http://img.wdjimg.com/image/video/53bfbe637b5796674a8f801e16db93b1_0_0.jpeg","title":"陈子扬","subTitle":"2 个视频","description":"自由摄影师陈子扬，擅长创意类视频拍摄。","actionUrl":"eyepetizer://pgc/detail/226/?title=%E9%99%88%E5%AD%90%E6%89%AC","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":224,"icon":"http://img.wdjimg.com/image/video/940e17d6ef5bda0c1f679a579f1e96e2_180_180.jpeg","title":"庞太师","subTitle":"2 个视频","description":"庞太师是一只照相机","actionUrl":"eyepetizer://pgc/detail/224/?title=%E5%BA%9E%E5%A4%AA%E5%B8%88","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":222,"icon":"http://img.wdjimg.com/image/video/d8dff79042e2755bb5c4685c6d94f570_0_0.jpeg","title":"飞宇科技传媒","subTitle":"1 个视频","description":"飞宇科技是全球领先的无人机及手持稳定器/手持云台相机开发企业，致力于创造优质的硬件和软件，帮助创作者创作出动人心扉的作品。","actionUrl":"eyepetizer://pgc/detail/222/?title=%E9%A3%9E%E5%AE%87%E7%A7%91%E6%8A%80%E4%BC%A0%E5%AA%92","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":220,"icon":"http://img.wdjimg.com/image/video/7cbd8960a3a2efaa808958a2146e14ce_180_180.jpeg","title":"刻画视频","subTitle":"2 个视频","description":"原创短视频，聚焦生活方式及人文艺术，致一切美好事物。","actionUrl":"eyepetizer://pgc/detail/220/?title=%E5%88%BB%E7%94%BB%E8%A7%86%E9%A2%91","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":218,"icon":"http://img.wdjimg.com/image/video/7774eac2a978eec8d2350c1b604bd146_0_0.jpeg","title":"ELLEMEN 睿士","subTitle":"1 个视频","description":"一本以荷尔蒙为灵感的男性杂志。关注时装、生活方式以及社会精神。","actionUrl":"eyepetizer://pgc/detail/218/?title=ELLEMEN%20%E7%9D%BF%E5%A3%AB","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":214,"icon":"http://img.wdjimg.com/image/video/51da06b9fd93086fc155201016ebd707_0_0.jpeg","title":"上海彩虹室内合唱团","subTitle":"2 个视频","description":"造化随顺，风雅之诚。","actionUrl":"eyepetizer://pgc/detail/214/?title=%E4%B8%8A%E6%B5%B7%E5%BD%A9%E8%99%B9%E5%AE%A4%E5%86%85%E5%90%88%E5%94%B1%E5%9B%A2","adTrack":null}},{"type":"briefCard","data":{"dataType":"BriefCard","id":212,"icon":"http://img.wdjimg.com/image/video/657383baf9fd839ece40797738b5a352_0_0.jpeg","title":"Lens","subTitle":"5 个视频","description":"Lens 旗下原创视频，覆盖文化、建筑、设计、视觉艺术、电影等领域。","actionUrl":"eyepetizer://pgc/detail/212/?title=Lens","adTrack":null}}]
     * count : 10
     * total : 0
     * nextPageUrl : http://baobab.wandoujia.com/api/v3/tabs/pgcs/more?start=20&num=10
     */

    private int count;
    private int total;
    private String nextPageUrl;
    /**
     * type : briefCard
     * data : {"dataType":"BriefCard","id":232,"icon":"http://img.kaiyanapp.com/10a34f3360972e8530d7f3856cd4b722.jpeg","title":"集舞视界","subTitle":"2 个视频","description":"DanceFocus，聚焦你的舞蹈！","actionUrl":"eyepetizer://pgc/detail/232/?title=%E9%9B%86%E8%88%9E%E8%A7%86%E7%95%8C","adTrack":null}
     */

    private List<ItemListBean> itemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        private String type;
        /**
         * dataType : BriefCard
         * id : 232
         * icon : http://img.kaiyanapp.com/10a34f3360972e8530d7f3856cd4b722.jpeg
         * title : 集舞视界
         * subTitle : 2 个视频
         * description : DanceFocus，聚焦你的舞蹈！
         * actionUrl : eyepetizer://pgc/detail/232/?title=%E9%9B%86%E8%88%9E%E8%A7%86%E7%95%8C
         * adTrack : null
         */

        private DataBean data;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            private String dataType;
            private int id;
            private String icon;
            private String title;
            private String subTitle;
            private String description;
            private String actionUrl;
            private Object adTrack;

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }
        }
    }
}
