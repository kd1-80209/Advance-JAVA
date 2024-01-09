package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VotingDoneBean {

	private int candId;
	private int userId;
	private String message;

	public VotingDoneBean() {
		// TODO Auto-generated constructor stub
	}

	public int getCandId() {
		return candId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void doneVoting() {
		try (UserDao uDao = new UserDaoImpl()) {

			User u = uDao.findById(userId);

			if (u.getStatus() != 0) {
				this.message = "Action Not Allowed... You've Already Voted !!!";
				return;
			}

			try (CandidateDao candDao = new CandidateDaoImpl()) {

				int count = candDao.incrementVote(candId);

				if (count == 1) {

					int cnt = uDao.updateStatus(userId, true);

					if (cnt == 1) {

						this.message = "Congratulations !!! Your Vote is Registered";
					} else {
						this.message = "Sorry... Some Error Occurred";
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
