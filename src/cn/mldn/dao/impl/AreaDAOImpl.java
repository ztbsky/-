package cn.mldn.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IAreaDAO;
import cn.mldn.util.dbc.DatabaseConnection;
import cn.mldn.vo.Area;

public class AreaDAOImpl implements IAreaDAO {

	@Override
	public boolean doCreate(Area vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Area vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Area findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Area> findAll() throws SQLException {
		List<Area> all = new ArrayList<Area>() ;
		String sql = "SELECT aid,title FROM area" ;
		PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql) ;
		ResultSet rs = pstmt.executeQuery() ;
		while (rs.next()) {
			Area area = new Area() ;
			area.setAid(rs.getInt(1));
			area.setTitle(rs.getString(2));
			all.add(area) ;
		}
		return all;
	}

	@Override
	public List<Area> findAllSplit(Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Area> findAllSplit(Integer currentPage, Integer lineSize,
			String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
