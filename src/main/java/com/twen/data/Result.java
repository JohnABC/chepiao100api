package com.twen.data;

import java.util.List;

public class Result
{
    private String errMsg = null;
    private List<ChePiaoData> data = null;
    private List<JiPiaoData> data2 = null;

	public String getErrMsg()
    {
        return errMsg;
    }
    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }
    public List<ChePiaoData> getData()
    {
        return data;
    }
    public void setData(List<ChePiaoData> data)
    {
        this.data = data;
    }
	public List<JiPiaoData> getData2() {
		return data2;
	}
	public void setData2(List<JiPiaoData> data2) {
		this.data2 = data2;
	}
    

    
}
