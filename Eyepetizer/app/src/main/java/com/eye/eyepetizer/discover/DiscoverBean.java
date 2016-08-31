package com.eye.eyepetizer.discover;

import java.util.List;

/**
 * Discover主页的bean
 */
public class DiscoverBean {

    /**
     * itemList : [{"type":"horizontalScrollCard","data":{"dataType":"HorizontalScrollCard","itemList":[{"type":"banner1","data":{"dataType":"Banner","id":106,"title":"","description":"","image":"http://img.kaiyanapp.com/b8c50281716659783895c97c7de77bb1.jpeg","actionUrl":"0","adTrack":null,"shade":false}},{"type":"banner1","data":{"dataType":"Banner","id":14,"title":"","description":"","image":"http://img.kaiyanapp.com/2c892eeefb675b22636ce6f71d2ec76c.png","actionUrl":"eyepetizer://recommend/","adTrack":null,"shade":false}}],"count":2}},{"type":"squareCard","data":{"dataType":"SquareCard","id":-1,"title":"","image":"http://img.wdjimg.com/image/video/46360c61d96fef74a776b3db1e221db7_0_0.jpeg","actionUrl":"eyepetizer://ranklist/","shade":false,"adTrack":null}}]
     * count : 16
     * total : 0
     * nextPageUrl : null
     */

    private int count;
    private int total;
    private Object nextPageUrl;
    /**
     * type : horizontalScrollCard
     * data : {"dataType":"HorizontalScrollCard","itemList":[{"type":"banner1","data":{"dataType":"Banner","id":106,"title":"","description":"","image":"http://img.kaiyanapp.com/b8c50281716659783895c97c7de77bb1.jpeg","actionUrl":"0","adTrack":null,"shade":false}},{"type":"banner1","data":{"dataType":"Banner","id":14,"title":"","description":"","image":"http://img.kaiyanapp.com/2c892eeefb675b22636ce6f71d2ec76c.png","actionUrl":"eyepetizer://recommend/","adTrack":null,"shade":false}}],"count":2}
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

    public Object getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(Object nextPageUrl) {
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
         * dataType : HorizontalScrollCard
         * itemList : [{"type":"banner1","data":{"dataType":"Banner","id":106,"title":"","description":"","image":"http://img.kaiyanapp.com/b8c50281716659783895c97c7de77bb1.jpeg","actionUrl":"0","adTrack":null,"shade":false}},{"type":"banner1","data":{"dataType":"Banner","id":14,"title":"","description":"","image":"http://img.kaiyanapp.com/2c892eeefb675b22636ce6f71d2ec76c.png","actionUrl":"eyepetizer://recommend/","adTrack":null,"shade":false}}]
         * count : 2
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
            private int count;
            private int id;
            private String title;
            private String image , actionUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            private List<ItemListBean1> itemList;

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<ItemListBean1> getItemList() {
                return itemList;
            }

            public void setItemList(List<ItemListBean1> itemList) {
                this.itemList = itemList;
            }

            public static class ItemListBean1 {
                private String type;
                /**
                 * dataType : Banner
                 * id : 106
                 * title :
                 * description :
                 * image : http://img.kaiyanapp.com/b8c50281716659783895c97c7de77bb1.jpeg
                 * actionUrl : 0
                 * adTrack : null
                 * shade : false
                 */

                private DataBean1 data;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public DataBean1 getData() {
                    return data;
                }

                public void setData(DataBean1 data) {
                    this.data = data;
                }

                public static class DataBean1 {
                    private String dataType;
                    private int id;
                    private String title;
                    private String description;
                    private String image;
                    private String actionUrl;
                    private Object adTrack;
                    private boolean shade;

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

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
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

                    public boolean isShade() {
                        return shade;
                    }

                    public void setShade(boolean shade) {
                        this.shade = shade;
                    }
                }
            }
        }
    }
}
