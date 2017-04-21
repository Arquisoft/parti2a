package uo.asw.dbmanagement;


import uo.asw.dbmanagement.util.CitizenMin;

public interface GetParticipant {
	CitizenMin getParticipant(String login, String password);
}
