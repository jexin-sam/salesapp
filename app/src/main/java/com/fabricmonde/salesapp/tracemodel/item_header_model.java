package com.fabricmonde.salesapp.tracemodel;

public class item_header_model {

    Integer image1;
    String tv1,tv2,tv3;

    public Integer getImage1() {
        return image1;
    }

    public void setImage1(Integer image1) {
        this.image1 = image1;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public String getTv3() {
        return tv3;
    }

    public void setTv3(String tv3) {
        this.tv3 = tv3;
    }

    public item_header_model(Integer image1, String tv1, String tv2, String tv3) {
        this.image1 = image1;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
    }
}
