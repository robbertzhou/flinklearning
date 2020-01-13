package com.zhisheng.alert.model;

import com.zhisheng.common.constant.MachineConstant;
import com.zhisheng.common.model.MetricEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

import static com.zhisheng.common.constant.MachineConstant.*;

/**
 * Desc: outage event
 * Created by zhisheng on 2019/10/15 上午12:11
 * blog：http://www.54tianzhisheng.cn/
 * 微信公众号：zhisheng
 */
@Data
@NoArgsConstructor
public class OutageMetricEvent {
    //machine cluster name
    private String clusterName;
    //machine host ip
    private String hostIp;
    //event time
    private Long timestamp;
    //if the machine alert is recover (true/false)
    private Boolean recover;
    //the time when machine alert recover
    private Long recoverTime;
    //system time
    private Long systemTimestamp;
    //machine cpu usage percent
    private Double cpuUsePercent;
    //machine mem usage percent
    private Double memUsedPercent;
    //machine swap usage percent
    private Double swapUsedPercent;
    //machine load in five minutes
    private Double load5;
    //the machine alert count
    private int counter = 0;

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getRecover() {
        return recover;
    }

    public void setRecover(Boolean recover) {
        this.recover = recover;
    }

    public Long getRecoverTime() {
        return recoverTime;
    }

    public void setRecoverTime(Long recoverTime) {
        this.recoverTime = recoverTime;
    }

    public Long getSystemTimestamp() {
        return systemTimestamp;
    }

    public void setSystemTimestamp(Long systemTimestamp) {
        this.systemTimestamp = systemTimestamp;
    }

    public Double getCpuUsePercent() {
        return cpuUsePercent;
    }

    public void setCpuUsePercent(Double cpuUsePercent) {
        this.cpuUsePercent = cpuUsePercent;
    }

    public Double getMemUsedPercent() {
        return memUsedPercent;
    }

    public void setMemUsedPercent(Double memUsedPercent) {
        this.memUsedPercent = memUsedPercent;
    }

    public Double getSwapUsedPercent() {
        return swapUsedPercent;
    }

    public void setSwapUsedPercent(Double swapUsedPercent) {
        this.swapUsedPercent = swapUsedPercent;
    }

    public Double getLoad5() {
        return load5;
    }

    public void setLoad5(Double load5) {
        this.load5 = load5;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public OutageMetricEvent(String clusterName, String hostIp, long timestamp, Boolean recover, Long systemTimestamp) {
        this.clusterName = clusterName;
        this.hostIp = hostIp;
        this.timestamp = timestamp;
        this.recover = recover;
        this.systemTimestamp = systemTimestamp;
    }

    public String getKey() {
        return clusterName + hostIp;
    }

    public static OutageMetricEvent buildFromEvent(MetricEvent event) {
        Map<String, String> tags = event.getTags();
        Map<String, Object> fields = event.getFields();
        OutageMetricEvent outageMetricEvent = new OutageMetricEvent(tags.get(MachineConstant.CLUSTER_NAME),
                tags.get(MachineConstant.HOST_IP), event.getTimestamp(), null, null);

        switch (event.getName()) {
            case MEM:
                if (fields.containsKey(USED_PERCENT)) {
                    outageMetricEvent.setMemUsedPercent((Double) fields.get(USED_PERCENT));
                }
                break;
            case LOAD:
                if (fields.containsKey(LOAD5)) {
                    outageMetricEvent.setLoad5((Double) fields.get(LOAD5));
                }
                break;
            case SWAP:
                if (fields.containsKey(USED_PERCENT)) {
                    outageMetricEvent.setMemUsedPercent((Double) fields.get(USED_PERCENT));
                }
                break;
            case CPU:
                if (fields.containsKey(USED_PERCENT)) {
                    outageMetricEvent.setCpuUsePercent((Double) fields.get(USED_PERCENT));
                }
                break;
            default:
                return null;
        }
        return outageMetricEvent;
    }
}
