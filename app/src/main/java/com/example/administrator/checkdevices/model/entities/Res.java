package com.example.administrator.checkdevices.model.entities;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Res implements Serializable {
	
	private String YesOrNO;
	private ArrayList<ResponseItems> items;

	public String getYesOrNO() {
		return YesOrNO;
	}

	public void setYesOrNO(String yesOrNO) {
		YesOrNO = yesOrNO;
	}

	public ArrayList<ResponseItems> getItems() {
		return items;
	}

	public void setItems(ArrayList<ResponseItems> items) {
		this.items = items;
	}

	public static class ResponseItems{
		private String type;//用户类型 1 个人用户 2 企业用户
		private String name;
		private String tel;
		private String weixin;
		private String address;
		private String param1;
		private String param2;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getWeixin() {
			return weixin;
		}

		public void setWeixin(String weixin) {
			this.weixin = weixin;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getParam1() {
			return param1;
		}

		public void setParam1(String param1) {
			this.param1 = param1;
		}

		public String getParam2() {
			return param2;
		}

		public void setParam2(String param2) {
			this.param2 = param2;
		}
	}
	
	@Override
	public String toString() {
		return "YesOrNo:" + YesOrNO
				+", items:[{"
				+ ", items:[{ User_status=" +items.get(0).getType()
				+" User_Name="+items.get(0).getName()
				+" User_Telphone="+items.get(0).getTel()
				+" unit_name="+items.get(0).getAddress()
				+" Unit_Code="+items.get(0).getWeixin()
				+" Pergun_polnum="+items.get(0).getParam1()
				+" Pergun_Name="+items.get(0).getParam2()
				 + "]";
	}
	
	
	
}
