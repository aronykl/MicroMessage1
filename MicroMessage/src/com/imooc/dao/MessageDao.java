package com.imooc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imooc.bean.Message;

/**
 * 和message表相关的数据库操作
 * @author Administrator
 *
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList = new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message", "root", "111111");
			StringBuffer sql = new StringBuffer("select id,command,description,content from message where 1=1");
			List<String> paramList = new ArrayList<String>();
			if(null != command && !"".equals(command.trim())) {
				sql.append(" and command=?");
				paramList.add(command);
			}
			if(null != description && !"".equals(description.trim())) {
				sql.append(" and description like '%'?'%'");
				paramList.add(description);
			}
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			for(int i = 0; i < paramList.size(); i++) {
				statement.setString(i + 1, paramList.get(i));
			}
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setCommand(rs.getString("command"));
				message.setDescription(rs.getString("description"));
				message.setContent(rs.getString("content"));
				messageList.add(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}

}
