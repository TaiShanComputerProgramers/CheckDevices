package com.example.administrator.checkdevices.model.entities;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Res_login implements Serializable {
	
	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "code:" + code
				+", msg:"+msg;
	}
	
	
	
}
