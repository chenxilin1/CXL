package com.chen.bean;


public class KeBiao {
private int id;
private Kecheng kecheng;//课程编号(获取编号,课程名称,课时)
private String shi_jian;
private String jieci;
private String jiaoshi;
private LaoShi laoshi;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public String getShi_jian() {
	return shi_jian;
}

public void setShi_jian(String shi_jian) {
	this.shi_jian = shi_jian;
}

public String getJieci() {
	return jieci;
}

public void setJieci(String jieci) {
	this.jieci = jieci;
}

public String getJiaoshi() {
	return jiaoshi;
}

public void setJiaoshi(String jiaoshi) {
	this.jiaoshi = jiaoshi;
}


public Kecheng getKecheng() {
	return kecheng;
}

public void setKecheng(Kecheng kecheng) {
	this.kecheng = kecheng;
}

public LaoShi getLaoshi() {
	return laoshi;
}

public void setLaoshi(LaoShi laoshi) {
	this.laoshi = laoshi;
}

public KeBiao() {
	super();
}


public KeBiao( Kecheng kecheng, String shi_jian, String jieci,
		String jiaoshi, LaoShi laoshi) {
	super();
	this.kecheng = kecheng;
	this.shi_jian = shi_jian;
	this.jieci = jieci;
	this.jiaoshi = jiaoshi;
	this.laoshi = laoshi;
}

public String toString() {
	return "KeBiao [id=" + id + ", kecheng=" + kecheng + ", shi_jian="
			+ shi_jian + ", jieci=" + jieci + ", jiaoshi=" + jiaoshi
			+ ", laoshi=" + laoshi + "]";
}

}
