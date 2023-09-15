package com.example.mymonitorbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName Resources
 */
@TableName(value ="Resources")
@Data
public class Resources implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String recordTimestamp;

    /**
     * 
     */
    private Object cpufreq;

    /**
     * 
     */
    private BigDecimal download;

    /**
     * 
     */
    private BigDecimal upload;

    /**
     * 
     */
    private BigDecimal fps;

    /**
     * 
     */
    private BigDecimal cpuusage;

    /**
     * 
     */
    private BigDecimal latitude;

    /**
     * 
     */
    private BigDecimal longitude;

    /**
     * 
     */
    private BigDecimal memoryusage;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        Resources other = (Resources) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRecordTimestamp() == null ? other.getRecordTimestamp() == null : this.getRecordTimestamp().equals(other.getRecordTimestamp()))
            && (this.getCpufreq() == null ? other.getCpufreq() == null : this.getCpufreq().equals(other.getCpufreq()))
            && (this.getDownload() == null ? other.getDownload() == null : this.getDownload().equals(other.getDownload()))
            && (this.getUpload() == null ? other.getUpload() == null : this.getUpload().equals(other.getUpload()))
            && (this.getFps() == null ? other.getFps() == null : this.getFps().equals(other.getFps()))
            && (this.getCpuusage() == null ? other.getCpuusage() == null : this.getCpuusage().equals(other.getCpuusage()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getMemoryusage() == null ? other.getMemoryusage() == null : this.getMemoryusage().equals(other.getMemoryusage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRecordTimestamp() == null) ? 0 : getRecordTimestamp().hashCode());
        result = prime * result + ((getCpufreq() == null) ? 0 : getCpufreq().hashCode());
        result = prime * result + ((getDownload() == null) ? 0 : getDownload().hashCode());
        result = prime * result + ((getUpload() == null) ? 0 : getUpload().hashCode());
        result = prime * result + ((getFps() == null) ? 0 : getFps().hashCode());
        result = prime * result + ((getCpuusage() == null) ? 0 : getCpuusage().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getMemoryusage() == null) ? 0 : getMemoryusage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", recordTimestamp=").append(recordTimestamp);
        sb.append(", cpufreq=").append(cpufreq);
        sb.append(", download=").append(download);
        sb.append(", upload=").append(upload);
        sb.append(", fps=").append(fps);
        sb.append(", cpuusage=").append(cpuusage);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", memoryusage=").append(memoryusage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}