package com.jingjiang.thehomeofcar.bean.indiscover;

import java.util.List;

/**
 * Created by dllo on 16/5/28.
 */
public class RecyclerPlayPictureData {


    /**
     * returncode : 0
     * message :
     * result : {"list":[{"id":6528,"url":"http://topic.m.autohome.com.cn/mall/2016/5/xiandai/#pvareaid=104735","imgurl":"http://app2.autoimg.cn/appdfs/g9/M0B/86/DA/autohomecar__wKjBzldHsa2ASoZZAAKf9ulxAAc035.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0},{"id":6530,"url":"http://topic.m.autohome.com.cn/mall/2016/4/hafu/#pvareaid=104735","imgurl":"http://app2.autoimg.cn/appdfs/g15/M05/8E/35/autohomecar__wKgH1ldHsqSAZCNaAAIs92XBKUo003.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0},{"id":6536,"url":"http://j.autohome.com.cn/loan/loan/sqty?type=ty#pvareaid=2017436","imgurl":"http://app2.autoimg.cn/appdfs/g19/M09/6F/38/autohomecar__wKgFWFdH_8yAGG1qAAKMeEi1ygk148.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0},{"id":6532,"url":"http://topic.m.autohome.com.cn/mall/2016/5/chuanqi/index.html#pvareaid=104735","imgurl":"http://app2.autoimg.cn/appdfs/g11/M0B/8D/40/autohomecar__wKgH0ldHsyOAJvR8AAKEYzltRvc821.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0},{"id":6533,"url":"http://topic.m.autohome.com.cn/mall/2016/5/track/#pvareaid=104735","imgurl":"http://app2.autoimg.cn/appdfs/g23/M0F/6F/19/autohomecar__wKgFV1dHtSOANUYCAAG6HLyS39Q530.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0}],"charad":{"duration":0,"list":[]}}
     */

    private int returncode;
    private String message;
    /**
     * list : [{"id":6528,"url":"http://topic.m.autohome.com.cn/mall/2016/5/xiandai/#pvareaid=104735","imgurl":"http://app2.autoimg.cn/appdfs/g9/M0B/86/DA/autohomecar__wKjBzldHsa2ASoZZAAKf9ulxAAc035.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0},{"id":6530,"url":"http://topic.m.autohome.com.cn/mall/2016/4/hafu/#pvareaid=104735","imgurl":"http://app2.autoimg.cn/appdfs/g15/M05/8E/35/autohomecar__wKgH1ldHsqSAZCNaAAIs92XBKUo003.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0},{"id":6536,"url":"http://j.autohome.com.cn/loan/loan/sqty?type=ty#pvareaid=2017436","imgurl":"http://app2.autoimg.cn/appdfs/g19/M09/6F/38/autohomecar__wKgFWFdH_8yAGG1qAAKMeEi1ygk148.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0},{"id":6532,"url":"http://topic.m.autohome.com.cn/mall/2016/5/chuanqi/index.html#pvareaid=104735","imgurl":"http://app2.autoimg.cn/appdfs/g11/M0B/8D/40/autohomecar__wKgH0ldHsyOAJvR8AAKEYzltRvc821.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0},{"id":6533,"url":"http://topic.m.autohome.com.cn/mall/2016/5/track/#pvareaid=104735","imgurl":"http://app2.autoimg.cn/appdfs/g23/M0F/6F/19/autohomecar__wKgFV1dHtSOANUYCAAG6HLyS39Q530.jpg","urlscheme":"","type":2,"appicon":"","siteindex":0}]
     * charad : {"duration":0,"list":[]}
     */

    private ResultBean result;

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * duration : 0
         * list : []
         */

        private CharadBean charad;
        /**
         * id : 6528
         * url : http://topic.m.autohome.com.cn/mall/2016/5/xiandai/#pvareaid=104735
         * imgurl : http://app2.autoimg.cn/appdfs/g9/M0B/86/DA/autohomecar__wKjBzldHsa2ASoZZAAKf9ulxAAc035.jpg
         * urlscheme :
         * type : 2
         * appicon :
         * siteindex : 0
         */

        private List<ListBean> list;

        public CharadBean getCharad() {
            return charad;
        }

        public void setCharad(CharadBean charad) {
            this.charad = charad;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class CharadBean {
            private int duration;
            private List<?> list;

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }
        }

        public static class ListBean {
            private int id;
            private String url;
            private String imgurl;
            private String urlscheme;
            private int type;
            private String appicon;
            private int siteindex;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImgurl() {
                return imgurl;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public String getUrlscheme() {
                return urlscheme;
            }

            public void setUrlscheme(String urlscheme) {
                this.urlscheme = urlscheme;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getAppicon() {
                return appicon;
            }

            public void setAppicon(String appicon) {
                this.appicon = appicon;
            }

            public int getSiteindex() {
                return siteindex;
            }

            public void setSiteindex(int siteindex) {
                this.siteindex = siteindex;
            }
        }
    }
}
