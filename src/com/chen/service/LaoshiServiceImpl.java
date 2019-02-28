package com.chen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.bean.KeBiao;
import com.chen.dao.AdminMapper;
@Service("lsservice")
public class LaoshiServiceImpl implements LaoshiService {

	@Autowired AdminMapper a;
	public List<KeBiao> lskebiaoall() {
		 List<KeBiao> ls=a.kebiaoall();
		return ls;
	}

}
