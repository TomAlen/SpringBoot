package com.tomalen.springlanuch.pojo;

import java.io.Serializable;

/**
 * notification
 * @author 
 */
public class Notification implements Serializable {
    private Integer id;

    /**
     * 回复的人
     */
    private Integer notifier;

    /**
     * 消息接收者
     */
    private Integer receiver;

    /**
     * 外键
     */
    private Integer outerId;

    /**
     * 回复或者评论
     */
    private Integer notifiedType;

    /**
     * 创建时间
     */
    private Long gmtCreate;

    /**
     * 消息未读或者已读
     */
    private Integer notifiedStatus;

    private String notifierName;

    private String outTitle;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNotifier() {
        return notifier;
    }

    public void setNotifier(Integer notifier) {
        this.notifier = notifier;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public Integer getOuterId() {
        return outerId;
    }

    public void setOuterId(Integer outerId) {
        this.outerId = outerId;
    }

    public Integer getNotifiedType() {
        return notifiedType;
    }

    public void setNotifiedType(Integer notifiedType) {
        this.notifiedType = notifiedType;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getNotifiedStatus() {
        return notifiedStatus;
    }

    public void setNotifiedStatus(Integer notifiedStatus) {
        this.notifiedStatus = notifiedStatus;
    }

    public String getNotifierName() {
        return notifierName;
    }

    public void setNotifierName(String notifierName) {
        this.notifierName = notifierName;
    }

    public String getOutTitle() {
        return outTitle;
    }

    public void setOutTitle(String outTitle) {
        this.outTitle = outTitle;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Notification other = (Notification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNotifier() == null ? other.getNotifier() == null : this.getNotifier().equals(other.getNotifier()))
            && (this.getReceiver() == null ? other.getReceiver() == null : this.getReceiver().equals(other.getReceiver()))
            && (this.getOuterId() == null ? other.getOuterId() == null : this.getOuterId().equals(other.getOuterId()))
            && (this.getNotifiedType() == null ? other.getNotifiedType() == null : this.getNotifiedType().equals(other.getNotifiedType()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getNotifiedStatus() == null ? other.getNotifiedStatus() == null : this.getNotifiedStatus().equals(other.getNotifiedStatus()))
            && (this.getNotifierName() == null ? other.getNotifierName() == null : this.getNotifierName().equals(other.getNotifierName()))
            && (this.getOutTitle() == null ? other.getOutTitle() == null : this.getOutTitle().equals(other.getOutTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNotifier() == null) ? 0 : getNotifier().hashCode());
        result = prime * result + ((getReceiver() == null) ? 0 : getReceiver().hashCode());
        result = prime * result + ((getOuterId() == null) ? 0 : getOuterId().hashCode());
        result = prime * result + ((getNotifiedType() == null) ? 0 : getNotifiedType().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getNotifiedStatus() == null) ? 0 : getNotifiedStatus().hashCode());
        result = prime * result + ((getNotifierName() == null) ? 0 : getNotifierName().hashCode());
        result = prime * result + ((getOutTitle() == null) ? 0 : getOutTitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", notifier=").append(notifier);
        sb.append(", receiver=").append(receiver);
        sb.append(", outerId=").append(outerId);
        sb.append(", notifiedType=").append(notifiedType);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", notifiedStatus=").append(notifiedStatus);
        sb.append(", notifierName=").append(notifierName);
        sb.append(", outTitle=").append(outTitle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}