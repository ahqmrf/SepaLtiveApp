package com.example.lenovo.sepaltive;

import java.util.List;

/**
 * Created by Lenovo on 1/12/2017.
 */
public class ImageData {


    /**
     * totalHits : 500
     * hits : [{"previewHeight":99,"likes":43,"favorites":39,"tags":"tulips, yellow, flowers","webformatHeight":426,"views":28682,"webformatWidth":640,"previewWidth":150,"comments":6,"downloads":20190,"pageURL":"https://pixabay.com/en/tulips-yellow-flowers-spring-1364024/","previewURL":"https://cdn.pixabay.com/photo/2016/04/30/21/45/tulips-1364024_150.jpg","webformatURL":"https://pixabay.com/get/e836b70b28f6053ed95c4518b7484495e473e5d104b0154991f2c17ca3edb0_640.jpg","imageWidth":3000,"user_id":194001,"user":"hansbenn","type":"photo","id":1364024,"userImageURL":"https://cdn.pixabay.com/user/2016/12/13/22-15-04-376_250x250.jpg","imageHeight":2000}]
     * total : 12653
     */

    private int totalHits;
    private int total;
    private List<HitsBean> hits;

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<HitsBean> getHits() {
        return hits;
    }

    public void setHits(List<HitsBean> hits) {
        this.hits = hits;
    }

    public static class HitsBean {
        /**
         * previewHeight : 99
         * likes : 43
         * favorites : 39
         * tags : tulips, yellow, flowers
         * webformatHeight : 426
         * views : 28682
         * webformatWidth : 640
         * previewWidth : 150
         * comments : 6
         * downloads : 20190
         * pageURL : https://pixabay.com/en/tulips-yellow-flowers-spring-1364024/
         * previewURL : https://cdn.pixabay.com/photo/2016/04/30/21/45/tulips-1364024_150.jpg
         * webformatURL : https://pixabay.com/get/e836b70b28f6053ed95c4518b7484495e473e5d104b0154991f2c17ca3edb0_640.jpg
         * imageWidth : 3000
         * user_id : 194001
         * user : hansbenn
         * type : photo
         * id : 1364024
         * userImageURL : https://cdn.pixabay.com/user/2016/12/13/22-15-04-376_250x250.jpg
         * imageHeight : 2000
         */

        private int previewHeight;
        private int likes;
        private int favorites;
        private String tags;
        private int webformatHeight;
        private int views;
        private int webformatWidth;
        private int previewWidth;
        private int comments;
        private int downloads;
        private String pageURL;
        private String previewURL;
        private String webformatURL;
        private int imageWidth;
        private int user_id;
        private String user;
        private String type;
        private int id;
        private String userImageURL;
        private int imageHeight;

        public int getPreviewHeight() {
            return previewHeight;
        }

        public void setPreviewHeight(int previewHeight) {
            this.previewHeight = previewHeight;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public int getWebformatHeight() {
            return webformatHeight;
        }

        public void setWebformatHeight(int webformatHeight) {
            this.webformatHeight = webformatHeight;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public int getWebformatWidth() {
            return webformatWidth;
        }

        public void setWebformatWidth(int webformatWidth) {
            this.webformatWidth = webformatWidth;
        }

        public int getPreviewWidth() {
            return previewWidth;
        }

        public void setPreviewWidth(int previewWidth) {
            this.previewWidth = previewWidth;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public int getDownloads() {
            return downloads;
        }

        public void setDownloads(int downloads) {
            this.downloads = downloads;
        }

        public String getPageURL() {
            return pageURL;
        }

        public void setPageURL(String pageURL) {
            this.pageURL = pageURL;
        }

        public String getPreviewURL() {
            return previewURL;
        }

        public void setPreviewURL(String previewURL) {
            this.previewURL = previewURL;
        }

        public String getWebformatURL() {
            return webformatURL;
        }

        public void setWebformatURL(String webformatURL) {
            this.webformatURL = webformatURL;
        }

        public int getImageWidth() {
            return imageWidth;
        }

        public void setImageWidth(int imageWidth) {
            this.imageWidth = imageWidth;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserImageURL() {
            return userImageURL;
        }

        public void setUserImageURL(String userImageURL) {
            this.userImageURL = userImageURL;
        }

        public int getImageHeight() {
            return imageHeight;
        }

        public void setImageHeight(int imageHeight) {
            this.imageHeight = imageHeight;
        }
    }
}
