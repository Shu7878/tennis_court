package tennisCourtDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CourtBean;



public class TennisCourtDao {
	private Connection connection;
	//コンストラクター
	//データベースとの接続をおこなう
	public TennisCourtDao() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/tennis_court";
		String user = "********";
		String password = "********";
		connection = DriverManager.getConnection(url, user, password);
	}

	public void close(){
		try{
			if(connection != null){
				connection.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	//コート名を受け取り、コートの検索をおこなうメソッド
	public ArrayList<CourtBean> getCourtDataByAddress(String courtAddress)throws SQLException{
		ArrayList<CourtBean> courtData = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try{

			//SQLを保持するオブジェクトの生成
			String sql = "SELECT * FROM court WHERE court_address = ?";
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, courtAddress);
			rs = pstatement.executeQuery();
			courtData = new ArrayList<CourtBean>();
			while(rs.next()){
				CourtBean courtBean = new CourtBean();
				courtBean = new CourtBean();
				courtBean.setCourt_id(rs.getInt("court_id"));
				courtBean.setCourt_name(rs.getString("court_name"));
				courtBean.setCourt_address(rs.getString("court_address"));
				courtBean.setCourt_cost(rs.getInt("court_cost"));
				courtBean.setCourt_time(rs.getString("court_time"));
				courtData.add(courtBean);
			}
			rs.close();
		}finally{
			pstatement.close();
		}
		return courtData;
	}

	//未入力の場合コート一覧をすべて表示
	public ArrayList<CourtBean> getCourtDataAll() throws SQLException{
		ArrayList<CourtBean> courtData = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try{
			//SQLを保持するオブジェクトの生成
			String sql = "SELECT * FROM court";
			pstatement = connection.prepareStatement(sql);
			rs = pstatement.executeQuery();
			courtData = new ArrayList<CourtBean>();
			while(rs.next()){
				CourtBean courtBean = new CourtBean();
				courtBean = new CourtBean();
				courtBean.setCourt_id(rs.getInt("court_id"));
				courtBean.setCourt_name(rs.getString("court_name"));
				courtBean.setCourt_address(rs.getString("court_address"));
				courtBean.setCourt_cost(rs.getInt("court_cost"));
				courtBean.setCourt_time(rs.getString("court_time"));
				courtData.add(courtBean);
			}
			rs.close();
		}finally{
			pstatement.close();
		}
		return courtData;
	}

	//引数に指定された情報を受け取り、コート情報を登録するメソッド
	public int insertCourtData(CourtBean court)throws SQLException{
		int numRow = 0;
		PreparedStatement pstatement = null;
		try{
			//トランザクション開始
			connection.setAutoCommit(false);
			//SQLを保持するPreparedStatementオブジェクトの作成
			String sql = "INSERT INTO court(court_id, court_name, court_address, court_cost, court_time)VALUES(?, ?, ?, ?, ?)";
			pstatement = connection.prepareStatement(sql);
			//INパラメーターの設定
			pstatement.setInt(1, court.getCourt_id());
			pstatement.setString(2, court.getCourt_name());
			pstatement.setString(3, court.getCourt_address());
			pstatement.setInt(4, court.getCourt_cost());
			pstatement.setString(5, court.getCourt_time());
			//SQLを発行して、courtの表に登録された行数を取得
			numRow = pstatement.executeUpdate();
		}finally{
			if(numRow > 0){
				connection.commit();
			}else{
				connection.rollback();
			}
			pstatement.close();
		}
		return numRow;
	}

	//引数に指定された情報を受け取り、コート情報を削除するメソッド
	public int deleteCourtData(int deleteNum)throws SQLException{
		int numRow = 0;
		PreparedStatement pstatement = null;

		try{
			connection.setAutoCommit(false);
			String sql = "DELETE FROM court WHERE court_id = ?";
			pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1, deleteNum);
			numRow = pstatement.executeUpdate();
		}finally{
			if(numRow > 0){
				connection.commit();
			}else{
				connection.rollback();
			}
		}
		return numRow;
	}
}
