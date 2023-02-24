package com.Physical.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Manager.service.ManagerDAO;
import com.Physical.common.DAO;

public class PhysicalDAO extends DAO {

	// 싱글톤
	private static PhysicalDAO PDao = null;

	private PhysicalDAO() {

	}

	public static PhysicalDAO getInstance() {
		if (PDao == null) {
			PDao = new PhysicalDAO();
		}
		return PDao;
	}

	// 전체 조호;
	public List<Phy100> getPhy100List() {
		List<Phy100> list = new ArrayList<>();
		Phy100 phy100 = null;
		try {
			conn();
			String sql = "select * from Phy100";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				phy100 = new Phy100();
				phy100.setPhy100Id(rs.getString("phy100_id"));
				phy100.setPhy100Name(rs.getString("phy100_name"));
				phy100.setPhy100Impo(rs.getString("phy100_impo"));
				phy100.setPhy100Height(rs.getInt("phy100_height"));
				phy100.setPhy100Weight(rs.getInt("phy100_weight"));
				phy100.setPhy100Power(rs.getInt("phy100_power"));
				phy100.setPhy100Grade(rs.getString("phy100_grade"));

				list.add(phy100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 참가자 이름 조회
	public Phy100 getPhy100(String Phy100Name) {
		Phy100 Phy100 = null;
		try {
			conn();
			String sql = "select * from Phy100 where Phy100_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PhysicalService.PhysicalInfo.getPhy100Name());

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Phy100 = new Phy100();
				Phy100.setPhy100Id(rs.getString("phy100_id"));
				Phy100.setPhy100Name(rs.getString("phy100_name"));
				Phy100.setPhy100Impo(rs.getString("phy100_impo"));
				Phy100.setPhy100Height(rs.getInt("phy100_height"));
				Phy100.setPhy100Weight(rs.getInt("phy100_weight"));
				Phy100.setPhy100Power(rs.getInt("phy100_power"));
				Phy100.setPhy100Grade(rs.getString("phy100_grade"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return Phy100;
	}

//	PHY100_ID     NOT NULL VARCHAR2(20) 
//	PHY100_NAME   NOT NULL VARCHAR2(15) 
//	PHY100_IMPO            VARCHAR2(30) 
//	PHY100_HEIGHT           NUMBER(10)   
//	PHY100_WEIGHT          NUMBER(10)   
//	PHY100_POWER           NUMBER(10)   
//	PHY100_GRADE           VARCHAR2(1)

	// 등록
	public int insertStd(Phy100 phy100) {
		int result = 0;
		try {
			conn();
			String sql = "insert into phy100 values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phy100.getPhy100Id());
			pstmt.setString(2, phy100.getPhy100Name());
			pstmt.setString(3, phy100.getPhy100Impo());
			pstmt.setInt(4, phy100.getPhy100Height());
			pstmt.setInt(5, phy100.getPhy100Weight());
			pstmt.setInt(6, phy100.getPhy100Power());
			pstmt.setString(7, phy100.getPhy100Grade());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;

	}

	// 탈락 !!
	public int deletePhy100(String phy100Name) {
		int result = 0;
		try {
			conn();
			String sql = "delete from phy100 where phy100_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phy100Name);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
//	public void deletePhy100() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("이름 입력>");
//		String phy100 = PhysicalDAO.deletePhy100(sc.nextLine());
//
//		System.out.println(" ===탈락===");
//	}

	// 수정
//	public int modifyPhy100(Phy100 phy100) {
//		int result = 0;
//		try {
//			conn();
//			String sql = "update phy100\r\n" + "set phy100_Name = ?\r\n" + "where phy100_id = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, phy100.getPhy100Id());
//			pstmt.setString(2, phy100.getPhy100Name());
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		return result;
//	}



	}


