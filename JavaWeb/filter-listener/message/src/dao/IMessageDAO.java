package dao;

import java.util.List;

import daomain.Message;


public interface IMessageDAO {
	
	void  add(Message obj);
	
	List<Message> getAll();
}
