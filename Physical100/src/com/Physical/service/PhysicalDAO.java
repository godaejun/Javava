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
				
				
				phy100.setPhy100Group(rs.getString("phy100_group"));
				phy100.setPhy100Survival(rs.getString("phy100_survival"));

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
	public List<Phy100> Game1 () {
		List<Phy100> list = new ArrayList<>();
		Phy100 phy100 = null;
		try {
			conn();
			String sql = "SELECT Phy100_NAME , Phy100_IMPO , Phy100_POWER , phy100_Group ,\r\n"
					+ "ROW_NUMBER() OVER (ORDER BY Phy100_Power  desc ) AS rank \r\n"
					+ "FROM Phy100";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, group);
			

			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				phy100 = new Phy100();
				//phy100.setPhy100Id(rs.getString("phy100_id"));
				phy100.setPhy100Name(rs.getString("phy100_name"));
				phy100.setPhy100Impo(rs.getString("phy100_impo"));
				//phy100.setPhy100Height(rs.getInt("phy100_height"));
				//phy100.setPhy100Weight(rs.getInt("phy100_weight"));
				phy100.setPhy100Power(rs.getInt("phy100_power"));
				phy100.setPhy100Group(rs.getString("phy100_group"));
				//phy100.setPhy100Survival(rs.getString("phy100_survival"));
				phy100.setRank(rs.getInt("rank"));
				

				list.add(phy100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	
	// 생존자 조회. [LIFE]
	
		public List<Phy100> getPhy101() {
			List<Phy100> list = new ArrayList<>();
			Phy100 Phy100 = null;
			try {
				conn();
				String sql = "select * from phy100 where Phy100_Survival='Life'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery(sql);
				
				while (rs.next()) {
					Phy100 = new Phy100();
					Phy100.setPhy100Id(rs.getString("phy100_id"));
					Phy100.setPhy100Name(rs.getString("phy100_name"));
					Phy100.setPhy100Impo(rs.getString("phy100_impo"));
					Phy100.setPhy100Height(rs.getInt("phy100_height"));
					Phy100.setPhy100Weight(rs.getInt("phy100_weight"));
					Phy100.setPhy100Power(rs.getInt("phy100_power"));
					Phy100.setPhy100Group(rs.getString("phy100_group"));
					Phy100.setPhy100Survival(rs.getString("phy100_survival"));
					
					list.add(Phy100);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconn();
			}
			return list;
		}

	// 탈락자 조회. [DEATH]
		
		public List<Phy100> getPhy102() {
			List<Phy100> list = new ArrayList<>();
			Phy100 Phy100 = null;
			try {
				conn();
				String sql = "select * from phy100 where Phy100_Survival='Death'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery(sql);
				
				while (rs.next()) {
					Phy100 = new Phy100();
					Phy100.setPhy100Id(rs.getString("phy100_id"));
					Phy100.setPhy100Name(rs.getString("phy100_name"));
					Phy100.setPhy100Impo(rs.getString("phy100_impo"));
					Phy100.setPhy100Height(rs.getInt("phy100_height"));
					Phy100.setPhy100Weight(rs.getInt("phy100_weight"));
					Phy100.setPhy100Power(rs.getInt("phy100_power"));
					Phy100.setPhy100Group(rs.getString("phy100_group"));
					Phy100.setPhy100Survival(rs.getString("phy100_survival"));
					
					list.add(Phy100);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconn();
			}
			return list;
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
	
	// 게임[2] 승리시 우승!! (어차피 우승은 미스터 추 ㅋ)
	
	public List<Phy100> Winner() {
		List<Phy100> list = new ArrayList<>();
		Phy100 Phy100 = null;
		try {
			conn();
			String sql = "select * from phy100 where Phy100_Survival='Life'";
			//String sql = "select * from phy100 where Phy100_Name='추성훈'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
				Phy100 = new Phy100();
				Phy100.setPhy100Id(rs.getString("phy100_id"));
				Phy100.setPhy100Name(rs.getString("phy100_name"));
				Phy100.setPhy100Impo(rs.getString("phy100_impo"));
				Phy100.setPhy100Height(rs.getInt("phy100_height"));
				Phy100.setPhy100Weight(rs.getInt("phy100_weight"));
				Phy100.setPhy100Power(rs.getInt("phy100_power"));
				Phy100.setPhy100Group(rs.getString("phy100_group"));
				Phy100.setPhy100Survival(rs.getString("phy100_survival"));
				
				list.add(Phy100);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
//	public int insertWinner(Phy100 phy100) {
//		int result = 0;
//		try {
//			conn();
//			String sql = "insert into Winner values(?,?,?,?,?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, phy100.getPhy100Id());
//			pstmt.setString(2, phy100.getPhy100Name());
//			pstmt.setString(3, phy100.getPhy100Impo());
//			//pstmt.setInt(4, phy100.getPhy100Height());
//			//pstmt.setInt(5, phy100.getPhy100Weight());
//			pstmt.setInt(6, phy100.getPhy100Power());
//			pstmt.setString(7, phy100.getPhy100Group());
//			//pstmt.setString(8, phy100.getPhy100Suvival());
//
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		return result;
//
//	}
//	
	
	
	
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


