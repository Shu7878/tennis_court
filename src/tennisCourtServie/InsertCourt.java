package tennisCourtServie;

import javax.servlet.http.HttpServletRequest;

import model.CourtBean;
import tennisCourtDao.TennisCourtDao;

public class InsertCourt {
	public void execute(HttpServletRequest request) throws Exception{
		TennisCourtDao dao = null;
		//コート情報をパラメーターから入手
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String cost = request.getParameter("cost");
		String time = request.getParameter("time");

		try{
			if(id != null && !id.isEmpty()
					&&name != null && !name.isEmpty()
					&&address != null && !address.isEmpty()
					&&cost != null && !cost.isEmpty()
					&&time != null && !time.isEmpty()){
				CourtBean bean = new CourtBean();
				bean.setCourt_id(Integer.parseInt(id));
				bean.setCourt_name(name);
				bean.setCourt_address(address);
				bean.setCourt_cost(Integer.parseInt(cost));
				bean.setCourt_time(time);

				dao = new TennisCourtDao();
				int numRow = dao.insertCourtData(bean);
				if(numRow > 0){
					request.setAttribute("message", "コート情報を登録しました");
				}else{
					request.setAttribute("message", "コート情報を登録できませんでした");
				}
			}
		}finally{
			if(dao != null){
				dao.close();
			}
		}
	}
}
