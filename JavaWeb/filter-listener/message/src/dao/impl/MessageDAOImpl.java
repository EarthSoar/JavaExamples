package dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import dao.IMessageDAO;
import daomain.Message;

public class MessageDAOImpl implements IMessageDAO {
	static int i = 0;
	Map<Integer, Message> map = new LinkedHashMap<>();
	@Override
	public void add(Message obj) {
		i++;
		map.put(i, obj);
	}

	@Override
	public List<Message> getAll() {
		List<Message> list = new ArrayList<>();
		for(Entry<Integer, Message> m :map.entrySet()) {
			list.add(m.getValue());
		}
		return list;
	}
}
