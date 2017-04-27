package cn.mldn.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IAreaplusDAO;
import cn.mldn.util.dbc.DatabaseConnection;
import cn.mldn.vo.Areaplus;

public class AreaplusDAOImpl implements IAreaplusDAO {

	@Override
	public boolean doCreate(Areaplus vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Areaplus vo) throws SQLException {
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
	public Areaplus findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Areaplus> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Areaplus> findAllSplit(Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Areaplus> findAllSplit(Integer currentPage, Integer lineSize,
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

	@Override
	public List<Areaplus> findAllByArea(int aid) throws SQLException {
		List<Areaplus> all = new ArrayList<Areaplus>() ;
		String sql = "SELECT apid,aid,title FROM areaplus WHERE aid=?" ;
		PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql) ;
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery() ;
		while (rs.next()) {
			Areaplus areaplus = new Areaplus() ;
			areaplus.setApid(rs.getInt(1));
			areaplus.setAid(rs.getInt(2));
			areaplus.setTitle(rs.getString(3));
			all.add(areaplus) ;
		}
		return all;
	}

}
