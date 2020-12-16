package blog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QQConstants {


    @Value("${yunxiu.qq.app_id}")
    String app_id;

    @Value("${yunxiu.qq.app_key}")
    String app_key;

    @Value("${yunxiu.qq.callback}")
    String callback;


    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }


    @Override
    public String toString() {
        return "QQConstants{" +
                "app_id='" + app_id + '\'' +
                ", app_key='" + app_key + '\'' +
                ", callback='" + callback + '\'' +
                '}';
    }
}
