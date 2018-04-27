package com.example.administrator.checkdevices.model.entities;

import com.example.administrator.checkdevices.model.login_devices;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Res_login2 implements Serializable {
	
	private String code;
	private String msg;
	private List<login_devices> devices;

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

	public List<login_devices> getDevices() {
		return devices;
	}

	public void setDevices(List<login_devices> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		return "code:" + code
				+", msg:"+msg;
	}
	
	
	
}
