package com.jingjiang.thehomeofcar.bean.infindcar;

/**
 * Created by dllo on 16/5/21.
 * 在降价中的推广
 * http://adnewnc.app.autohome.com.cn/autov5.7.0/ad/getadinfo.ashx?appid=2&platform=2&version=5.8.5&advertype=23&series=0&networkid=0&idfa=0&deviceid=99000628573771&mac=02%3A00%3A00%3A00%3A00%3A00&cityid=210200&devicebrand=Xiaomi&devicemodel=MI4LTE&lng=121.550923&lat=38.88966&gps_city=210200&pageid=0898c0ec-e7bd-42b3-a141-fa67bb04d023&isretry=0
 */
public class DepreciateExpandData {
    //609 GET http://m.che168.com/handler/carlist/getcarlist.ashx?rand=2012&area=dalian&brand=&ls=&spec=&minPrice=0&maxPrice=0&minRegisteAge=0&maxRegisteAge=0&MileageId=0&disp=&stru=&gb=0&color=&source=&listview=0&sell=1&newCar=0&credit=0&sort=0&extrepair=0&page=1&ex=cd0t0p0w0ru0e0sa0o0i0g0nfzlk0v0a0m0_0xb101y15&sourcename=mainapp HTTP/1.1 	=> HTTP/1.1 200 OK	 [1.163 s]
    //621 GET http://m.che168.com/handler/carlist/getcarlist.ashx?rand=2012&area=dalian&brand=&ls=&spec=&minPrice=0&maxPrice=0&minRegisteAge=0&maxRegisteAge=0&MileageId=0&disp=&stru=&gb=0&color=&source=&listview=0&sell=1&newCar=0&credit=0&sort=0&extrepair=0&page=2&ex=cd0t0p0w0ru0e0sa0o0i0g0nfzlk0v0a0m0_0xb101y15&sourcename=mainapp HTTP/1.1 	=> HTTP/1.1 200 OK	 [0.349 s]
    //944 GET http://223.99.255.20/news.app.autohome.com.cn/news_v5.8.5/newspf/NPNewsList.ashx?a=2&pm=2&v=5.8.5&au=&type=1&lastid=&lastuid=0&size=30 HTTP/1.1 	=> HTTP/1.1 200 OK	 [0.456 s]
    //7 GET http://forum.app.autohome.com.cn/forum_v5.7.0/forum/club/topiccontent-a2-pm2-v5.8.5-t52642235-o0-p1-s20-c1-nt0-fs0-sp0-al0-cw360.json HTTP/1.1 	=> HTTP/1.1 200 OK	 [0.194 s]

    /**
     * returncode : 0
     * message :
     * result : {"title":"东风风行直降万元","pubtime":"2016-05-21","imgpath":"http://img2.autoimg.cn/admdfs/g14/M06/82/F7/wKjByVc-hzaABtnNAAAXiWGTlK8151.jpg","url":"http://c.autohome.com.cn/adfront/click?ah_mark=29416761DF7F2E485342434409EA4C49A9A27FB25262043B39BF74A7781F376B2B64B30F8FD663B290F6B616FAA2A92ED86FA4554CC33A1CF4B23EFDF3476F954FC13CFA2E774D9E7F2476C3ADA5554A174775DE7EA9C91051BDD2721993A2D4&u=B81B2AAF0AEF9138EAF9E9FABB34C8D8038AA6C9A3799DDB17753702A5993514C4D72A74BDEF6C39499BB73B7840C04804CE42617F2B6D89789F0723DEDCDF66AD6DB26449259CE80E417BD089030AAE&isjump=1","jumptype":1,"shorttitle":"","isshow":1,"posindex":6,"adtype":0,"areaid":1793,"pvid":"54abafa5-92de-41d3-bdd0-85d70b04c92f0","ishavead":1,"thirdadurl":"","rdposturl":"http://rd.autohome.com.cn/adfront/realdeliver?"}
     */

    private int returncode;
    private String message;
    /**
     * title : 东风风行直降万元
     * pubtime : 2016-05-21
     * imgpath : http://img2.autoimg.cn/admdfs/g14/M06/82/F7/wKjByVc-hzaABtnNAAAXiWGTlK8151.jpg
     * url : http://c.autohome.com.cn/adfront/click?ah_mark=29416761DF7F2E485342434409EA4C49A9A27FB25262043B39BF74A7781F376B2B64B30F8FD663B290F6B616FAA2A92ED86FA4554CC33A1CF4B23EFDF3476F954FC13CFA2E774D9E7F2476C3ADA5554A174775DE7EA9C91051BDD2721993A2D4&u=B81B2AAF0AEF9138EAF9E9FABB34C8D8038AA6C9A3799DDB17753702A5993514C4D72A74BDEF6C39499BB73B7840C04804CE42617F2B6D89789F0723DEDCDF66AD6DB26449259CE80E417BD089030AAE&isjump=1
     * jumptype : 1
     * shorttitle :
     * isshow : 1
     * posindex : 6
     * adtype : 0
     * areaid : 1793
     * pvid : 54abafa5-92de-41d3-bdd0-85d70b04c92f0
     * ishavead : 1
     * thirdadurl :
     * rdposturl : http://rd.autohome.com.cn/adfront/realdeliver?
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
        private String title;
        private String pubtime;
        private String imgpath;
        private String url;
        private int jumptype;
        private String shorttitle;
        private int isshow;
        private int posindex;
        private int adtype;
        private int areaid;
        private String pvid;
        private int ishavead;
        private String thirdadurl;
        private String rdposturl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPubtime() {
            return pubtime;
        }

        public void setPubtime(String pubtime) {
            this.pubtime = pubtime;
        }

        public String getImgpath() {
            return imgpath;
        }

        public void setImgpath(String imgpath) {
            this.imgpath = imgpath;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getJumptype() {
            return jumptype;
        }

        public void setJumptype(int jumptype) {
            this.jumptype = jumptype;
        }

        public String getShorttitle() {
            return shorttitle;
        }

        public void setShorttitle(String shorttitle) {
            this.shorttitle = shorttitle;
        }

        public int getIsshow() {
            return isshow;
        }

        public void setIsshow(int isshow) {
            this.isshow = isshow;
        }

        public int getPosindex() {
            return posindex;
        }

        public void setPosindex(int posindex) {
            this.posindex = posindex;
        }

        public int getAdtype() {
            return adtype;
        }

        public void setAdtype(int adtype) {
            this.adtype = adtype;
        }

        public int getAreaid() {
            return areaid;
        }

        public void setAreaid(int areaid) {
            this.areaid = areaid;
        }

        public String getPvid() {
            return pvid;
        }

        public void setPvid(String pvid) {
            this.pvid = pvid;
        }

        public int getIshavead() {
            return ishavead;
        }

        public void setIshavead(int ishavead) {
            this.ishavead = ishavead;
        }

        public String getThirdadurl() {
            return thirdadurl;
        }

        public void setThirdadurl(String thirdadurl) {
            this.thirdadurl = thirdadurl;
        }

        public String getRdposturl() {
            return rdposturl;
        }

        public void setRdposturl(String rdposturl) {
            this.rdposturl = rdposturl;
        }
    }
}
