package com.eye.eyepetizer.my.mymessage;

import java.util.List;

/**
 * 　　　　　　　 ┏┓ 　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　帅哥 　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽大帅哥在上
 * 　　　　　　　　　┃　　　┃          无bug代码在下
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * <p>
 * 作者：TheTopKing_杨燚 on 16/9/1 10:58
 * 这周日你有空吗
 */
public class MyMessageBean {

    /**
     * messageList : [{"id":27382,"title":"官方通知","content":"亲爱的开眼用户，由于过度劳累，开眼同学今天突然崩溃了。小伙伴们正在全力抢救中，一定会尽快恢复更新！大家今天早点睡吧～或者，看看往期精彩内容也不错。么么哒。","date":1471020063000,"actionUrl":"","icon":"http://img.wdjimg.com/image/video/418d281e65bf010c38c7b07bdd7b6a94_0_0.png"},{"id":2358,"title":"活动通知","content":"＃分享有福利＃分享视频：关于「死水边的美人鱼」，即有可能收到由孟京辉工作室提供的一些周边小礼品。（我们将在分享的用户中随机抽取 15 位，截止日期：6 月 1 日。）","date":1464414491000,"actionUrl":"","icon":"http://img.wdjimg.com/image/video/8a47b9fd167779342188b518f38775ef_0_0.png"},{"id":416,"title":"官方通知","content":"开眼 2.1 增加了视频标签，通过标签能快速找到更多相关内容！","date":1463154000000,"actionUrl":"","icon":"http://img.wdjimg.com/image/video/418d281e65bf010c38c7b07bdd7b6a94_0_0.png"}]
     * updateTime : 1471020063000
     * nextPageUrl : null
     */

    private long updateTime;
    private Object nextPageUrl;
    /**
     * id : 27382
     * title : 官方通知
     * content : 亲爱的开眼用户，由于过度劳累，开眼同学今天突然崩溃了。小伙伴们正在全力抢救中，一定会尽快恢复更新！大家今天早点睡吧～或者，看看往期精彩内容也不错。么么哒。
     * date : 1471020063000
     * actionUrl :
     * icon : http://img.wdjimg.com/image/video/418d281e65bf010c38c7b07bdd7b6a94_0_0.png
     */

    private List<MessageListBean> messageList;

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public Object getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(Object nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public List<MessageListBean> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageListBean> messageList) {
        this.messageList = messageList;
    }

    public static class MessageListBean {
        private int id;
        private String title;
        private String content;
        private long date;
        private String actionUrl;
        private String icon;

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
