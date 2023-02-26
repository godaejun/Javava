package com.Manager.service;

import com.Physical.common.DAO;

public class ManagerDAO extends DAO {

	private static ManagerDAO mDao = new ManagerDAO();

	private ManagerDAO() {

	}

	public static ManagerDAO getInstance() {
		return mDao;
	}

	// 1.로그인 기능
	public Manager login(String id) {
		Manager man = null;
		try {
			conn();
			String sql = "select * from Manager where Manager_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				man = new Manager();
				man.setManagerId(rs.getString("manager_id"));
				man.setManagerPw(rs.getString("manager_pw"));
				man.setManagerName(rs.getString("manager_name"));
				man.setManagerTell(rs.getInt("manager_tell"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return man;
	}

	// 아이디 조회
	public Manager getManager() {
		Manager manager = null;
		try {
			conn();
			String sql = "select * from manager where manager_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ManagerService.managerInfo.getManagerId());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				manager = new Manager();
				manager.setManagerId(rs.getString("manager_id"));
				manager.setManagerPw(rs.getString("manager_pw"));
				manager.setManagerName(rs.getString("manager_name"));
				manager.setManagerTell(rs.getInt("manager_tell"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return manager;
	}

	// 수정
	public int modifyMember(Manager manager) {
		int result = 0;
		try {
			conn();
			String sql = "update manager\r\n"  + "where manager_Id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager.getManagerId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 삭제
	public int deleteManager(String manId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from manager where manager_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manId);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

}
