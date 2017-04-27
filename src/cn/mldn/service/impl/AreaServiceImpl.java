package cn.mldn.service.impl;

import java.util.List;

import cn.mldn.dao.IAreaDAO;
import cn.mldn.service.IAreaService;
import cn.mldn.util.factory.Factory;
import cn.mldn.vo.Area;

public class AreaServiceImpl implements IAreaService {

	@Override
	public List<Area> list() throws Exception {
		IAreaDAO areaDAO = Factory.getDAOInstance("area.dao") ;
		return areaDAO.findAll();
	}

}
