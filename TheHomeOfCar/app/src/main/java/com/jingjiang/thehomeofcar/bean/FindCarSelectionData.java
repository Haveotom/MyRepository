package com.jingjiang.thehomeofcar.bean;

import java.util.List;

/**
 * Created by dllo on 16/5/10.
 * 找车中的筛选
 */
public class FindCarSelectionData {

    /**
     * returncode : 0
     * message :
     * result : {"pageindex":1,"totalseriescount":1057,"totalpagecount":53,"series":[{"seriesname":"博越","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g18/M14/50/ED/242x182_0_q30_autohomecar__wKgH2VcK_T-ALdMbAAebOIcc4mA331.jpg","pricerange":"9.88-15.78万","seriesid":3788,"cornericon":"1"},{"seriesname":"帝豪GS","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g20/M09/BA/D7/242x182_0_q30_autohomecar__wKgFVFbejcmAImEVAAm4g0HC9cQ202.jpg","pricerange":"7.78-10.88万","seriesid":3465,"cornericon":"2"},{"seriesname":"哈弗H7","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g19/M04/3E/EA/242x182_0_q30_autohomecar__wKgFWFcWIl6AelUOAAl1M7FG_gs306.jpg","pricerange":"14.98-16.98万","seriesid":3074,"cornericon":"3"},{"seriesname":"锐界","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/8/6/242x182_0_q30_201508060908405795699112.jpg","pricerange":"24.98-42.98万","seriesid":3615,"cornericon":""},{"seriesname":"思域","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g6/M0F/70/4B/242x182_0_q30_autohomecar__wKgH3FcpyCaAbOnhAAcqpKPkrf4198.jpg","pricerange":"12.18-19.98万","seriesid":135,"cornericon":""},{"seriesname":"汉兰达","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/4/8/242x182_0_q30_201504080900488944149112.jpg","pricerange":"23.98-42.28万","seriesid":771,"cornericon":""},{"seriesname":"卡罗拉","thumburl":"http://car0.m.autoimg.cn/carnews/2014/8/20/242x182_0_q30_20140820223127339497110.jpg","pricerange":"10.78-17.58万","seriesid":526,"cornericon":""},{"seriesname":"宝马3系","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g18/M0D/87/85/242x182_0_q30_autohomecar__wKgH2VYBQVGAeQBhAAU8bKcsP2Y404.jpg","pricerange":"28.3-60.78万","seriesid":66,"cornericon":""},{"seriesname":"英朗","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g5/M04/4B/49/242x182_0_q30_autohomecar__wKgHzFcE6d6Ad2RPAAedWKK3vM0792.jpg","pricerange":"10.99-15.99万","seriesid":982,"cornericon":""},{"seriesname":"宝沃BX7","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g22/M10/41/EF/242x182_0_q30_autohomecar__wKjBwVcZjTuAEoGmAApbw5d-7ds102.jpg","pricerange":"16.98-30.28万","seriesid":3913,"cornericon":""},{"seriesname":"艾瑞泽5","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g6/M0F/3B/91/242x182_0_q30_autohomecar__wKgH3FaVV8SATquBAAaHkH4-r3E551.jpg","pricerange":"5.89-9.79万","seriesid":3405,"cornericon":""},{"seriesname":"长安CS75","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g22/M01/BF/7E/242x182_0_q30_autohomecar__wKjBwVbf8t6Ab5SaAAZpyQcmTzQ371.jpg","pricerange":"9.28-15.78万","seriesid":3204,"cornericon":""},{"seriesname":"奥迪A4L","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g9/M0C/AA/11/242x182_0_q30_autohomecar__wKgH31Yc20iAf1fSAAlGgy0uSJs969.jpg","pricerange":"27.28-57.81万","seriesid":692,"cornericon":""},{"seriesname":"速腾","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/2/24/242x182_0_q30_20150224213405865443511.jpg","pricerange":"13.18-18.58万","seriesid":442,"cornericon":""},{"seriesname":"东南DX7","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/5/25/242x182_0_q30_201505251503353015132110.jpg","pricerange":"9.69-13.99万","seriesid":3634,"cornericon":""},{"seriesname":"探险者","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g9/M06/4F/5E/242x182_0_q30_autohomecar__wKjBzlXW5s-AXYuRAAUcg03JGAo090.jpg","pricerange":"44.98-63.98万","seriesid":2024,"cornericon":""},{"seriesname":"兰德酷路泽","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g12/M00/5A/AD/242x182_0_q30_autohomecar__wKgH01cWAKiAFBtBAAWNrqqmk5g931.jpg","pricerange":"76.5-119.4万","seriesid":45,"cornericon":""},{"seriesname":"福克斯","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/8/2/242x182_0_q30_201508022217085914971110.jpg","pricerange":"9.98-16.99万","seriesid":364,"cornericon":""},{"seriesname":"昂科威","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g7/M04/85/35/242x182_0_q30_autohomecar__wKjB0FX_7qCAF7OmAAue6YHr_b0423.jpg","pricerange":"21.99-34.99万","seriesid":3554,"cornericon":""},{"seriesname":"雅阁","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g19/M05/E4/3C/242x182_0_q30_autohomecar__wKgFU1bqcdSAcCPiAAmrfezSiWI456.jpg","pricerange":"16.98-29.88万","seriesid":78,"cornericon":""}]}
     */

    private int returncode;
    private String message;
    /**
     * pageindex : 1
     * totalseriescount : 1057
     * totalpagecount : 53
     * series : [{"seriesname":"博越","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g18/M14/50/ED/242x182_0_q30_autohomecar__wKgH2VcK_T-ALdMbAAebOIcc4mA331.jpg","pricerange":"9.88-15.78万","seriesid":3788,"cornericon":"1"},{"seriesname":"帝豪GS","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g20/M09/BA/D7/242x182_0_q30_autohomecar__wKgFVFbejcmAImEVAAm4g0HC9cQ202.jpg","pricerange":"7.78-10.88万","seriesid":3465,"cornericon":"2"},{"seriesname":"哈弗H7","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g19/M04/3E/EA/242x182_0_q30_autohomecar__wKgFWFcWIl6AelUOAAl1M7FG_gs306.jpg","pricerange":"14.98-16.98万","seriesid":3074,"cornericon":"3"},{"seriesname":"锐界","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/8/6/242x182_0_q30_201508060908405795699112.jpg","pricerange":"24.98-42.98万","seriesid":3615,"cornericon":""},{"seriesname":"思域","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g6/M0F/70/4B/242x182_0_q30_autohomecar__wKgH3FcpyCaAbOnhAAcqpKPkrf4198.jpg","pricerange":"12.18-19.98万","seriesid":135,"cornericon":""},{"seriesname":"汉兰达","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/4/8/242x182_0_q30_201504080900488944149112.jpg","pricerange":"23.98-42.28万","seriesid":771,"cornericon":""},{"seriesname":"卡罗拉","thumburl":"http://car0.m.autoimg.cn/carnews/2014/8/20/242x182_0_q30_20140820223127339497110.jpg","pricerange":"10.78-17.58万","seriesid":526,"cornericon":""},{"seriesname":"宝马3系","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g18/M0D/87/85/242x182_0_q30_autohomecar__wKgH2VYBQVGAeQBhAAU8bKcsP2Y404.jpg","pricerange":"28.3-60.78万","seriesid":66,"cornericon":""},{"seriesname":"英朗","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g5/M04/4B/49/242x182_0_q30_autohomecar__wKgHzFcE6d6Ad2RPAAedWKK3vM0792.jpg","pricerange":"10.99-15.99万","seriesid":982,"cornericon":""},{"seriesname":"宝沃BX7","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g22/M10/41/EF/242x182_0_q30_autohomecar__wKjBwVcZjTuAEoGmAApbw5d-7ds102.jpg","pricerange":"16.98-30.28万","seriesid":3913,"cornericon":""},{"seriesname":"艾瑞泽5","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g6/M0F/3B/91/242x182_0_q30_autohomecar__wKgH3FaVV8SATquBAAaHkH4-r3E551.jpg","pricerange":"5.89-9.79万","seriesid":3405,"cornericon":""},{"seriesname":"长安CS75","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g22/M01/BF/7E/242x182_0_q30_autohomecar__wKjBwVbf8t6Ab5SaAAZpyQcmTzQ371.jpg","pricerange":"9.28-15.78万","seriesid":3204,"cornericon":""},{"seriesname":"奥迪A4L","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g9/M0C/AA/11/242x182_0_q30_autohomecar__wKgH31Yc20iAf1fSAAlGgy0uSJs969.jpg","pricerange":"27.28-57.81万","seriesid":692,"cornericon":""},{"seriesname":"速腾","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/2/24/242x182_0_q30_20150224213405865443511.jpg","pricerange":"13.18-18.58万","seriesid":442,"cornericon":""},{"seriesname":"东南DX7","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/5/25/242x182_0_q30_201505251503353015132110.jpg","pricerange":"9.69-13.99万","seriesid":3634,"cornericon":""},{"seriesname":"探险者","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g9/M06/4F/5E/242x182_0_q30_autohomecar__wKjBzlXW5s-AXYuRAAUcg03JGAo090.jpg","pricerange":"44.98-63.98万","seriesid":2024,"cornericon":""},{"seriesname":"兰德酷路泽","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g12/M00/5A/AD/242x182_0_q30_autohomecar__wKgH01cWAKiAFBtBAAWNrqqmk5g931.jpg","pricerange":"76.5-119.4万","seriesid":45,"cornericon":""},{"seriesname":"福克斯","thumburl":"http://car0.m.autoimg.cn/car/carnews/2015/8/2/242x182_0_q30_201508022217085914971110.jpg","pricerange":"9.98-16.99万","seriesid":364,"cornericon":""},{"seriesname":"昂科威","thumburl":"http://car2.m.autoimg.cn/cardfs/product/g7/M04/85/35/242x182_0_q30_autohomecar__wKjB0FX_7qCAF7OmAAue6YHr_b0423.jpg","pricerange":"21.99-34.99万","seriesid":3554,"cornericon":""},{"seriesname":"雅阁","thumburl":"http://car3.m.autoimg.cn/cardfs/product/g19/M05/E4/3C/242x182_0_q30_autohomecar__wKgFU1bqcdSAcCPiAAmrfezSiWI456.jpg","pricerange":"16.98-29.88万","seriesid":78,"cornericon":""}]
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
        private int pageindex;
        private int totalseriescount;
        private int totalpagecount;
        /**
         * seriesname : 博越
         * thumburl : http://car3.m.autoimg.cn/cardfs/product/g18/M14/50/ED/242x182_0_q30_autohomecar__wKgH2VcK_T-ALdMbAAebOIcc4mA331.jpg
         * pricerange : 9.88-15.78万
         * seriesid : 3788
         * cornericon : 1
         */

        private List<SeriesBean> series;

        public int getPageindex() {
            return pageindex;
        }

        public void setPageindex(int pageindex) {
            this.pageindex = pageindex;
        }

        public int getTotalseriescount() {
            return totalseriescount;
        }

        public void setTotalseriescount(int totalseriescount) {
            this.totalseriescount = totalseriescount;
        }

        public int getTotalpagecount() {
            return totalpagecount;
        }

        public void setTotalpagecount(int totalpagecount) {
            this.totalpagecount = totalpagecount;
        }

        public List<SeriesBean> getSeries() {
            return series;
        }

        public void setSeries(List<SeriesBean> series) {
            this.series = series;
        }

        public static class SeriesBean {
            private String seriesname;
            private String thumburl;
            private String pricerange;
            private int seriesid;
            private String cornericon;

            public String getSeriesname() {
                return seriesname;
            }

            public void setSeriesname(String seriesname) {
                this.seriesname = seriesname;
            }

            public String getThumburl() {
                return thumburl;
            }

            public void setThumburl(String thumburl) {
                this.thumburl = thumburl;
            }

            public String getPricerange() {
                return pricerange;
            }

            public void setPricerange(String pricerange) {
                this.pricerange = pricerange;
            }

            public int getSeriesid() {
                return seriesid;
            }

            public void setSeriesid(int seriesid) {
                this.seriesid = seriesid;
            }

            public String getCornericon() {
                return cornericon;
            }

            public void setCornericon(String cornericon) {
                this.cornericon = cornericon;
            }
        }
    }
}