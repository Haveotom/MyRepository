package com.jingjiang.thehomeofcar.bean.infindcar;

import java.util.List;

/**
 * Created by dllo on 16/5/17.
 * 主打车
 * http://223.99.255.20/adnewnc.app.autohome.com.cn/autov5.7.0/ad/infoad.ashx?version=5.8.5&platform=2&appid=2&networkid=0&adtype=1&provinceid=210000&cityid=0&lng=121.551079&lat=38.889656&gps_city=210200&pageid=04704225-c34a-425c-8e4b-f8781eaf19dd&isretry=1&deviceid=99000628573771
 */
public class BrandMainData {

    /**
     * returncode : 0
     * message :
     * result : {"list":[{"areaid":1775,"id":234202,"seriesid":3781,"seriesname":"比亚迪元","img":"http://adm3.autoimg.cn/admdfs/g14/M12/6A/79/wKgH1VclVc6AY9awAAA3RljhTDo199.png","url":"http://c.autohome.com.cn/adfront/click?ah_mark=319BCD3F0FDAE37061B685F44749AE287EA38E2C5C2BC03BF75A7B95118ED0994B0C4DA416D1016C06CF878B37F34DFE4B0C9F889B08AE613614EBAA2EBDD5EDF1F300BD5B379DCF30C6AA721E823771C5E76C484A94B9292871C1B8704BD868&u=&isjump=0","thurl":"","jumptype":1,"jumpurl":"http://c.autohome.com.cn/adfront/click?ah_mark=319BCD3F0FDAE37061B685F44749AE287EA38E2C5C2BC03BF75A7B95118ED0994B0C4DA416D1016C06CF878B37F34DFE4B0C9F889B08AE613614EBAA2EBDD5EDF1F300BD5B379DCF30C6AA721E823771C5E76C484A94B9292871C1B8704BD868&u=AE801D7499F8F7D2D851473C57D036C1692B327201F78C773E179EF82E6AAAEB0C005D54C935E404ED7D551AD61A9AD921E874DAA522B8C684547CA6726916D758C80BC33A04AF0352D19623BA03FD51D293F5522B82A91A9F12C67CEF9B3344B78BC2D3E1DC532023B49B0FAE9950A1FB6AED2FB973B66F20C2785B10171F1210DD66D3ECD6EC68466D259D17499B398DF7B20E6D2CF9C9C5D5CE8EDE16F6920C5AE83BD632669D230D0D87A5869D7D07D7807C64FA748A05D3AE78B6F7DD09","areaid_cxzs":1781,"pvid":"d6c3adba-f725-4e5e-a1f2-8be7cdf079470","ishavead":1,"thirdadurl":"","rdposturl":"http://rd.autohome.com.cn/adfront/realdeliver?"},{"areaid":1776,"id":234828,"seriesid":793,"seriesname":"林肯MKZ","img":"http://adm3.autoimg.cn/admdfs/g17/M0E/6D/22/wKgH51cq31qAGgRdAACQZEO5mjU178.png","url":"http://c.autohome.com.cn/adfront/click?ah_mark=418F4C8F04263AC5F473A54E584F480C7EA38E2C5C2BC03BF75A7B95118ED0999DBB22368D085DDD9EC3D453432E5416129835A9D7A26FBC4276852958CF5645EFF6076C1A2A9BC773A552FCEBFCCBC5C5E76C484A94B9292871C1B8704BD868&u=47506EA63639CCCFE38542AC69205F05699A7D3380926562A59164B7CAC3427A91BAAEA37F62EE59C0136522CA77DD5022E8E5D01DDEBB13EE5D5292F1F83506&isjump=0","thurl":"","jumptype":0,"jumpurl":"","areaid_cxzs":1782,"pvid":"d6c3adba-f725-4e5e-a1f2-8be7cdf079471","ishavead":1,"thirdadurl":"","rdposturl":"http://rd.autohome.com.cn/adfront/realdeliver?"},{"areaid":1777,"id":197697,"seriesid":3290,"seriesname":"昕动","img":"http://adm3.autoimg.cn/admdfs/g19/M0B/27/92/wKjBxFb920eAFR9fAACko12PwNc276.png","url":"http://c.autohome.com.cn/adfront/click?ah_mark=A46CF696C3A3E03B78D1C1403E8016027EA38E2C5C2BC03BF75A7B95118ED099706B52DA456E910B64A11A4BABA2F4B08E94E3FB3BFA53AEB60A4F65CE33300BEFF6076C1A2A9BC773A552FCEBFCCBC5C5E76C484A94B9292871C1B8704BD868&u=A7EE1B705EB0F373AA387FB97A281658704F80530671429205F979D87C4FE89D6E96D00A9B7E1A0EA37E27DD0336A7F6C82D5C9789BA15FFB23B5D834DDED143&isjump=0","thurl":"","jumptype":0,"jumpurl":"","areaid_cxzs":1783,"pvid":"d6c3adba-f725-4e5e-a1f2-8be7cdf079472","ishavead":1,"thirdadurl":"","rdposturl":"http://rd.autohome.com.cn/adfront/realdeliver?"}]}
     */

    private int returncode;
    private String message;
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
         * areaid : 1775
         * id : 234202
         * seriesid : 3781
         * seriesname : 比亚迪元
         * img : http://adm3.autoimg.cn/admdfs/g14/M12/6A/79/wKgH1VclVc6AY9awAAA3RljhTDo199.png
         * url : http://c.autohome.com.cn/adfront/click?ah_mark=319BCD3F0FDAE37061B685F44749AE287EA38E2C5C2BC03BF75A7B95118ED0994B0C4DA416D1016C06CF878B37F34DFE4B0C9F889B08AE613614EBAA2EBDD5EDF1F300BD5B379DCF30C6AA721E823771C5E76C484A94B9292871C1B8704BD868&u=&isjump=0
         * thurl :
         * jumptype : 1
         * jumpurl : http://c.autohome.com.cn/adfront/click?ah_mark=319BCD3F0FDAE37061B685F44749AE287EA38E2C5C2BC03BF75A7B95118ED0994B0C4DA416D1016C06CF878B37F34DFE4B0C9F889B08AE613614EBAA2EBDD5EDF1F300BD5B379DCF30C6AA721E823771C5E76C484A94B9292871C1B8704BD868&u=AE801D7499F8F7D2D851473C57D036C1692B327201F78C773E179EF82E6AAAEB0C005D54C935E404ED7D551AD61A9AD921E874DAA522B8C684547CA6726916D758C80BC33A04AF0352D19623BA03FD51D293F5522B82A91A9F12C67CEF9B3344B78BC2D3E1DC532023B49B0FAE9950A1FB6AED2FB973B66F20C2785B10171F1210DD66D3ECD6EC68466D259D17499B398DF7B20E6D2CF9C9C5D5CE8EDE16F6920C5AE83BD632669D230D0D87A5869D7D07D7807C64FA748A05D3AE78B6F7DD09
         * areaid_cxzs : 1781
         * pvid : d6c3adba-f725-4e5e-a1f2-8be7cdf079470
         * ishavead : 1
         * thirdadurl :
         * rdposturl : http://rd.autohome.com.cn/adfront/realdeliver?
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int areaid;
            private int id;
            private int seriesid;
            private String seriesname;
            private String img;
            private String url;
            private String thurl;
            private int jumptype;
            private String jumpurl;
            private int areaid_cxzs;
            private String pvid;
            private int ishavead;
            private String thirdadurl;
            private String rdposturl;

            public int getAreaid() {
                return areaid;
            }

            public void setAreaid(int areaid) {
                this.areaid = areaid;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSeriesid() {
                return seriesid;
            }

            public void setSeriesid(int seriesid) {
                this.seriesid = seriesid;
            }

            public String getSeriesname() {
                return seriesname;
            }

            public void setSeriesname(String seriesname) {
                this.seriesname = seriesname;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThurl() {
                return thurl;
            }

            public void setThurl(String thurl) {
                this.thurl = thurl;
            }

            public int getJumptype() {
                return jumptype;
            }

            public void setJumptype(int jumptype) {
                this.jumptype = jumptype;
            }

            public String getJumpurl() {
                return jumpurl;
            }

            public void setJumpurl(String jumpurl) {
                this.jumpurl = jumpurl;
            }

            public int getAreaid_cxzs() {
                return areaid_cxzs;
            }

            public void setAreaid_cxzs(int areaid_cxzs) {
                this.areaid_cxzs = areaid_cxzs;
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
}
