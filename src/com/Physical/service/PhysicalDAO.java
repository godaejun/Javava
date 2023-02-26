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

	// 1) 전체 조호; 게임 시작전.
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

	// 2) 조별(Group)대진표 조회후 게임[1] 시작.
	public List<Phy100> Game1 (String grade) {
		List<Phy100> list = new ArrayList<>();
		Phy100 phy100 = null;
		try {
			conn();
			String sql = "select * from Phy100 where phy100_group = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade);

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

	
	// 생존자 조회.
	
		public Phy100 getPhy1001() {
			Phy100 Phy100 = null;
			try {
				conn();
				String sql = "select Phy100_name, Phy100_grade from Phy100 where Phy100_Survival='Life'";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, PhysicalService.PhysicalInfo.getPhy100Name());
				pstmt.setString(1, PhysicalService.PhysicalInfo.getPhy100Grade());
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

	// 탈락자 조회
		
		public Phy100 getPhy1002() {
			Phy100 Phy100 = null;
			try {
				conn();
				String sql = "select Phy100_name, Phy100_group from Phy100 where Phy100_Survival='Death'";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, PhysicalService.PhysicalInfo.getPhy100Name());
				pstmt.setString(1, PhysicalService.PhysicalInfo.getPhy100Grade());
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

	// 게임[2] 시작.	
		
		
	// 탈락 (삭제)!!
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
	
	// 게임2 패자부활전 승리시 생존자 등록
	public int insertPhy100(Phy100 phy100) {
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


