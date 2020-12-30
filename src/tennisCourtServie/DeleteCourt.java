package tennisCourtServie;

import javax.servlet.http.HttpServletRequest;

import tennisCourtDao.TennisCourtDao;

public class DeleteCourt {
	public void execute(HttpServletRequest request)throws Exception{
		TennisCourtDao dao = null;
		String id = request.getParameter("courtId");

		try{
			 if(id != null){
				 dao = new TennisCourtDao();
				 int numRow = dao.deleteCourtData(Integer.parseInt(id));		//このあたりでNumberFormatException
				 if(numRow > 0){
					 request.setAttribute("completeMessage", "指定されたコート情報を削除しました");
				 }else{
					 request.setAttribute("completeMessage", "コート情報を削除できませんでした");
				 }
			 }else{
				 request.setAttribute("comfirmMessage", "不正アクセスです");
			 }
		}finally{
			if(dao != null){
				dao.close();
			}
		}
	}
}
