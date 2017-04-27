package cn.mldn.service.impl;

import java.util.List;

import cn.mldn.dao.IAreaplusDAO;
import cn.mldn.service.IAreaplusService;
import cn.mldn.util.factory.Factory;
import cn.mldn.vo.Areaplus;

public class AreaplusServiceImpl implements IAreaplusService {

	@Override
	public List<Areaplus> listByArea(int aid) throws Exception {
		IAreaplusDAO areaplusDAO = Factory.getDAOInstance("areaplus.dao") ;
		return areaplusDAO.findAllByArea(aid); 
	}

}
