package entity;

import java.util.HashMap;
import java.util.Map;

public class StaticsParam
{

    public final static Map<String, String> STA_TYPE = new HashMap<String, String>()
    {

        {
            put("all", "0");
            put("auth", "1");
            put("passenger", "2");
            put("new", "3");
            put("old", "4");
        }
    };

    public final static Map<String, String> CYCLE_TYPE = new HashMap<String, String>()
    {

        {
            put("w", "0");// 周
            put("q", "1");// 季度
            put("m", "2");// 月
            put("y", "3");// 年
        }
    };

    // 集团ID
    private Integer groupId;

    // 区域等级（100，99，0，1，2）
    private Integer regionLevel;

    private String regionId;

    // 开始时间
    private String from;

    // 结束时间
    private String to;

    // 统计数据类型(0,1,2,3,4)
    private String staType;

    // 是否为周期性
    private Boolean cycle;

    // 周期类型：m,w
    private String cycleType;

    // 认证类型
    private String authType;

    // 认证子类型
    private String authcType;

    // 是否为虚拟网
    private Boolean vnet;

    // 查询几个周期
    private String cycleNum;

    public String getCycleNum()
    {
        return cycleNum;
    }

    public void setCycleNum(String cycleNum)
    {
        this.cycleNum = cycleNum;
    }

    public Integer getGroupId()
    {
        return groupId;
    }

    public void setGroupId(Integer groupId)
    {
        this.groupId = groupId;
    }

    public Integer getRegionLevel()
    {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel)
    {
        this.regionLevel = regionLevel;
    }

    public String getRegionId()
    {
        return regionId;
    }

    public void setRegionId(String regionId)
    {
        this.regionId = regionId;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }

    public String getStaType()
    {
        return staType;
    }

    public void setStaType(String staType)
    {
        this.staType = staType;
    }

    public Boolean getCycle()
    {
        return cycle;
    }

    public void setCycle(Boolean cycle)
    {
        this.cycle = cycle;
    }

    public Boolean getVnet()
    {
        return vnet;
    }

    public void setVnet(Boolean vnet)
    {
        this.vnet = vnet;
    }

    public String getCycleType()
    {
        return cycleType;
    }

    public void setCycleType(String cycleType)
    {
        if (cycleType == null || cycleType.equals(""))
        {
            this.cycleType = null;
        }
        else
        {
            this.cycleType = CYCLE_TYPE.get(cycleType);
        }

    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthcType() {
        return authcType;
    }

    public void setAuthcType(String authcType) {
        this.authcType = authcType;
    }
}
