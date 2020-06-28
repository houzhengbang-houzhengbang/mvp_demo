package com.hzb.myapplication.bean;

import com.hzb.myapplication.api.BaseBean;

import java.util.List;

/**
 * FileName: LoginBean
 * Author: houzhengbang
 * Date: 2020-05-27 11:04
 * Description:
 */
public class LoginBean extends BaseBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * advertisementName : 荣知教育1
         * advertisementCover : http://39.98.205.102/group1/M00/00/08/rBp8l1xHzlSAYQbPAABONK7Bpx4374.png
         * advertisementContent : 测试广告1
         * advertisementUrl : 1
         * id : 2
         * timestamp : 2
         * urlType : 1
         */

        private String advertisementName;
        private String advertisementCover;
        private String advertisementContent;
        private String advertisementUrl;
        private String id;
        private String timestamp;
        private String urlType;

        public String getAdvertisementName() {
            return advertisementName;
        }

        public void setAdvertisementName(String advertisementName) {
            this.advertisementName = advertisementName;
        }

        public String getAdvertisementCover() {
            return advertisementCover;
        }

        public void setAdvertisementCover(String advertisementCover) {
            this.advertisementCover = advertisementCover;
        }

        public String getAdvertisementContent() {
            return advertisementContent;
        }

        public void setAdvertisementContent(String advertisementContent) {
            this.advertisementContent = advertisementContent;
        }

        public String getAdvertisementUrl() {
            return advertisementUrl;
        }

        public void setAdvertisementUrl(String advertisementUrl) {
            this.advertisementUrl = advertisementUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getUrlType() {
            return urlType;
        }

        public void setUrlType(String urlType) {
            this.urlType = urlType;
        }
    }
}
