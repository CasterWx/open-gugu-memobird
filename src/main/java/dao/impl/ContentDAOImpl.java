package dao.impl;

import dao.IContentDAO;
import domain.Content;

import java.sql.*;
import java.util.ArrayList;

public class ContentDAOImpl implements IContentDAO {

    public static Connection connection ;

    public void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("连接成功");
        }catch (Exception e){
            System.out.println("连接失败");
        }
        try{
            connection = DriverManager.getConnection("jdbc:mysql://45.32.136.190:3306/gugu?useUnicode=true&characterEncoding=utf-8","antz","antz!");
        }catch (Exception e){
        }
    }

    public void shutdownConnection(){
        try {
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
        }
    }

    @Override
    public void save(Content content) {
        Statement statement = null ;
        try {
            setConnection();
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "INSERT INTO t_content_tab(name,content,date) VALUES(" + "'"+content.getName()+"','"+content.getContent()+"','"+content.getData()+"')";
            statement.executeUpdate(sql);
            shutdownConnection();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }
        }
    }

    @Override
    public ArrayList<Content> list() {
        ArrayList<Content> list  = new ArrayList<Content>() ;
        Statement statement = null ;
        ResultSet resultSet = null ;
        Content content = null ;
        try {
            setConnection();
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "SELECT * FROM t_content_tab" ;
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                content = new Content() ;
                content.setId(resultSet.getLong("id"));
                content.setName(resultSet.getString("name"));
                content.setContent(resultSet.getString("content"));
                content.setData(resultSet.getString("data"));
                list.add(content) ;
            }
            shutdownConnection();
            return list ;
        }catch (Exception e){
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }finally {
                try{
                    if(resultSet!=null){
                        resultSet.close();
                    }
                }catch (Exception e){
                }
            }
        }
        return list;
    }

}
