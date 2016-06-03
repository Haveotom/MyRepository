package com.jingjiang.thehomeofcar.inrecommend.infastreport;

import java.util.List;

/**
 * Created by dllo on 16/6/1.
 *  http://223.99.255.20/news.app.autohome.com.cn/fastnews_v5.6.0/news/fastnewslevel-pm2-ts0.json
 */
public class AllRankData {

    /**
     * returncode : 0
     * message :
     * result : {"TimeStamp":635970420608240000,"list":[{"levelid":0,"levelname":"不限"},{"levelid":1,"levelname":"微型车"},{"levelid":2,"levelname":"小型车"},{"levelid":3,"levelname":"紧凑型车"},{"levelid":4,"levelname":"中型车"},{"levelid":5,"levelname":"中大型车"},{"levelid":6,"levelname":"大型车"},{"levelid":7,"levelname":"跑车"},{"levelid":8,"levelname":"MPV"},{"levelid":15,"levelname":"高端皮卡"},{"levelid":16,"levelname":"小型SUV"},{"levelid":17,"levelname":"紧凑型SUV"},{"levelid":18,"levelname":"中型SUV"},{"levelid":19,"levelname":"中大型SUV"},{"levelid":20,"levelname":"大型SUV"}]}
     */

    private int returncode;
    private String message;
    /**
     * TimeStamp : 635970420608240000
     * list : [{"levelid":0,"levelname":"不限"},{"levelid":1,"levelname":"微型车"},{"levelid":2,"levelname":"小型车"},{"levelid":3,"levelname":"紧凑型车"},{"levelid":4,"levelname":"中型车"},{"levelid":5,"levelname":"中大型车"},{"levelid":6,"levelname":"大型车"},{"levelid":7,"levelname":"跑车"},{"levelid":8,"levelname":"MPV"},{"levelid":15,"levelname":"高端皮卡"},{"levelid":16,"levelname":"小型SUV"},{"levelid":17,"levelname":"紧凑型SUV"},{"levelid":18,"levelname":"中型SUV"},{"levelid":19,"levelname":"中大型SUV"},{"levelid":20,"levelname":"大型SUV"}]
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
        private long TimeStamp;
        /**
         * levelid : 0
         * levelname : 不限
         */

        private List<ListBean> list;

        public long getTimeStamp() {
            return TimeStamp;
        }

        public void setTimeStamp(long TimeStamp) {
            this.TimeStamp = TimeStamp;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int levelid;
            private String levelname;

            public int getLevelid() {
                return levelid;
            }

            public void setLevelid(int levelid) {
                this.levelid = levelid;
            }

            public String getLevelname() {
                return levelname;
            }

            public void setLevelname(String levelname) {
                this.levelname = levelname;
            }
        }
    }
}
