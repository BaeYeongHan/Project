package com.pr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.pr.vo.ViewVo;

public class ViewDao {
	Connection conn = null;
	PreparedStatement pstmt = null; // SQL ���� �����ͺ��̽��� ���������� ��ü
	ResultSet rs = null; // SQL ���ǿ� ���� ������ ���̺��� �����ϴ� ��ü
	
	// ��� �޼ҵ�
	// db ���� �׽�Ʈ

	public void dbConnect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/practice";
		conn = DriverManager.getConnection(url, "root", "1234");
		System.out.println("���� ����");
	}
	
	public ViewVo bdSelect(int id) throws Exception {

		ViewVo vvo = new ViewVo();
		String SQL = "SELECT *FROM board WHERE id=?";

		pstmt = conn.prepareStatement(SQL);
		pstmt.setInt(1, id);
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
			vvo.setId(rs.getInt("id"));
			vvo.setTitle(rs.getString("title"));
			vvo.setSub(rs.getString("sub"));
			vvo.setWho(rs.getString("who"));
			vvo.setDate(rs.getString("date"));
			
		}

		return vvo;

	}
	
	public ViewVo bdInsert(String title, String sub, String who) throws Exception {
		String SQL = "INSERT INTO board (title,sub,who,date) VALUES (?,?,?,?)";
		ViewVo vvo = new ViewVo();
		Date dt =new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = transFormat.format(dt);

		System.out.println();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, title);
		pstmt.setString(2, sub);
		pstmt.setString(3, who);
		pstmt.setString(4, date);
		
		int r = pstmt.executeUpdate();
		System.out.println("����� row : " + r);
		return vvo;
	}
	
	
	public ViewVo dbUpdate(int id,String title,String sub) throws Exception {
		String SQL = "UPDATE board SET title=? ,sub=? ,date=? WHERE  id=?";
		ViewVo vvo = new ViewVo();
		Date dt =new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = transFormat.format(dt);
		
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, title);
		pstmt.setString(2, sub);
		pstmt.setString(3, date1);
		pstmt.setInt(4, id);
		int r = pstmt.executeUpdate();
		System.out.println("����� row : " + r);
		return vvo;
	}
	
	public ArrayList<ViewVo> view() throws Exception{
		String SQL = "SELECT * FROM board order by date desc";
		ArrayList<ViewVo>list =new ArrayList<ViewVo>();
		pstmt = conn.prepareStatement(SQL);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			ViewVo vvo = new ViewVo();
			vvo.setId(rs.getInt("id"));
			vvo.setTitle(rs.getString("title"));
			vvo.setSub(rs.getString("sub"));
			vvo.setWho(rs.getString("who"));
			vvo.setDate(rs.getString("date"));
			list.add(vvo);
		}
		//for(int i =0; i<list.size(); i++) {
			//System.out.println("���� : "+ list.get(i).getTitle());
			//System.out.println("�ۼ��� : "+ list.get(i).getWho());
			//System.out.println("��¥ : "+ list.get(i).getDate());
	
		return list;
		
	}
	public void dbDelete(int id) throws Exception {
		String SQL = "DELETE FROM board WHERE id=?";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setInt(1, id);
		int r = pstmt.executeUpdate();
		System.out.println("����� row : " + r);
	}

	public void closeAll() {
		// �������� �ݴ�� close ��
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
