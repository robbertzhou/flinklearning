package com.zhisheng.alert.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文本类型钉钉消息
 * blog：http://www.54tianzhisheng.cn/
 * 微信公众号：zhisheng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextMessage extends BaseMessage {
    public TextMessage(){

    }

    public TextMessage(TextContent text,AtMobiles at){
        this.text = text;
        this.at = at;
    }

    /**
     * 消息内容
     */
    public TextContent text;

    /**
     * @
     */
    public AtMobiles at;

    public TextContent getText() {
        return text;
    }

    public void setText(TextContent text) {
        this.text = text;
    }

    public AtMobiles getAt() {
        return at;
    }

    public void setAt(AtMobiles at) {
        this.at = at;
    }

    @Override
    protected void init() {
        this.msgtype = MessageType.text;
    }


    @Data
    public static class TextContent {
        /**
         * 消息内容
         */
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
