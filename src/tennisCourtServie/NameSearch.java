package tennisCourtServie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.CourtBean;
import tennisCourtDao.TennisCourtDao;

public class NameSearch {
	public void execute(HttpServletRequest request)throws Exception{

		TennisCourtDao courtDao = null;
		String courtAddress = request.getParameter("paramAddress");
		try{
			if(courtAddress != null && !courtAddress.isEmpty()){
				courtDao = new TennisCourtDao();
				ArrayList<CourtBean> courtData = courtDao.getCourtDataByAddress(courtAddress);
				if(courtData != null){
					request.setAttribute("courtList", courtData);
				}else{
					request.setAttribute("message", "対象となるコートはありません");
				}
			}else{
				courtDao = new TennisCourtDao();
				ArrayList<CourtBean> courtData = courtDao.getCourtDataAll();
				request.setAttribute("courtList", courtData);
			}
		}finally{
			if(courtDao != null){
				courtDao.close();
			}
		}
	}
}
