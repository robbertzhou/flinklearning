package com.zhisheng.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: log event
 * Created by zhisheng on 2019/10/13 上午10:07
 * blog：http://www.54tianzhisheng.cn/
 * 微信公众号：zhisheng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogEvent {
    //the type of log(app、docker、...)
    private String type;

    // the timestamp of log
    private Long timestamp;

    //the level of log(debug/info/warn/error)
    private String level;

    //the message of log
    private String message;

    //the tag of log(appId、dockerId、machine hostIp、machine clusterName、...)
    private Map<String, String> tags = new HashMap<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
}