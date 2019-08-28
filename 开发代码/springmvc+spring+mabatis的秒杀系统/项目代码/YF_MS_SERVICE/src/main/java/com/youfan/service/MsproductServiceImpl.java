package com.youfan.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youfan.dao.MsmerchantDao;
import com.youfan.dao.MsproductDao;
import com.youfan.dao.MsuserDao;
import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;

@Service
public class MsproductServiceImpl implements MsproductService{
	
	@Autowired
	MsproductDao msproductDao;
	
	/**
	 * ������ɱ��Ʒ
	 * @param msproductinfo
	 */
	public void applymsproduct(Msproductinfo msproductinfo){
		String starttime = msproductinfo.getStarttimestring();//
		String endtime = msproductinfo.getEndtimestring();
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date starttimedate = dateformat.parse(starttime);
			msproductinfo.setStarttime(starttimedate);
			Date endtimedate = dateformat.parse(endtime);
			msproductinfo.setEndtime(endtimedate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 msproductinfo.setApplydate(new Date());
		 msproductinfo.setAuditstate(1);
		msproductDao.applymsproduct(msproductinfo);
	}
	
	/**
	 * ��ɱ��Ʒ�б�
	 * @param msproductinfo
	 */
	public List<Msproductinfo> listmsproduct(MsProductVo msProductVo){
		return msproductDao.listmsproduct(msProductVo);
	}
	
	/**
	 * ������ɱ��Ʒid��ѯ��ɱ��Ʒ
	 * @param msproductinfo
	 */
	public Msproductinfo querymsproductByid(int id){
		return msproductDao.querymsproductByid(id);
	}
	
	public void deletemsproductByid(int id){
		msproductDao.deletemsproductByid(id);
	}
	
	public void updatemsproduct(Msproductinfo msproductinfo){
		String starttime = msproductinfo.getStarttimestring();//
		String endtime = msproductinfo.getEndtimestring();
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date starttimedate = dateformat.parse(starttime);
			msproductinfo.setStarttime(starttimedate);
			Date endtimedate = dateformat.parse(endtime);
			msproductinfo.setEndtime(endtimedate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msproductDao.updatemsproduct(msproductinfo);
	}
	
	/**
	 * ����ת̬
	 * @param id
	 * @param state
	 */
	public void updatemsproductstate(int id,int state){
		MsProductVo msProductVo = new MsProductVo();
		ConstomProduct constomProduct = new ConstomProduct();
		constomProduct.setId(id);
		constomProduct.setAuditstate(state);
		msProductVo.setConstomProduct(constomProduct);
		msproductDao.updatemsproductstate(msProductVo);
	}
	
	
	
}
