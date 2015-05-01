package com.twen.data;

import java.util.List;

public class Result2
{
    private String errMsg = null;
    private List<JiPiaoData> data = null;

	public String getErrMsg()
    {
        return errMsg;
    }
    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }
	public List<JiPiaoData> getData() {
		return data;
	}
	public void setData(List<JiPiaoData> data) {
		this.data = data;
	}
    

    
}

