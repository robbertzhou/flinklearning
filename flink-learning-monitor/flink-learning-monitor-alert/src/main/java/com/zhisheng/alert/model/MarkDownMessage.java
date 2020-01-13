package com.zhisheng.alert.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * markdown 类型钉钉消息
 * blog：http://www.54tianzhisheng.cn/
 * 微信公众号：zhisheng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDownMessage extends BaseMessage {
    public MarkDownMessage(){

    }

    public MarkDownMessage(MarkDownContent markdown,AtMobiles at){
        this.markdown = markdown;
        this.at = at;
    }

    public MarkDownContent markdown;

    public AtMobiles at;

    public MarkDownContent getMarkdown() {
        return markdown;
    }

    public void setMarkdown(MarkDownContent markdown) {
        this.markdown = markdown;
    }

    public AtMobiles getAt() {
        return at;
    }

    public void setAt(AtMobiles at) {
        this.at = at;
    }

    @Override
    protected void init() {
        this.msgtype = MessageType.markdown;
    }


    @Data
    public static class MarkDownContent {
        /**
         * 首屏会话透出的展示内容
         */
        private String title;

        /**
         * markdown格式的消息
         */
        private String text;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
