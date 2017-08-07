package com.basicselectdemo.app;
public class SelectDemo {
    public static void main(String[] args) {
        /**
         * JDBC Routine
         * 1. Open a DB Session
         * 2. Execute a Query
         * 3. Expect a Return Value(s)
         * 4. Close a DB Session
         */
        
        java.sql.Connection conn  = null;
        java.sql.Statement stmt = null;
        String url = "jdbc:sqlite:C:\\Users\\Admin01\\Documents\\NetBeansProjects\\BasicSelectDemo\\src\\com\\basicselectdemo\\app\\demo.sqlite";
        String error = ""; 
        
        try{
            //1. Open a DB Session
            Class.forName("org.sqlite.JDBC");
            conn = java.sql.DriverManager.getConnection(url);
            
            //2. Execute a Query
            stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT lastname FROM demo ORDER BY lastname DESC");
            
            //3. Expect a Return Statement
            while(rs.next()){ 
//                String id = rs.getString("id");
                String lastname = rs.getString("lastname");
                
//                System.out.println("ID: " + id);
                System.out.println("Lastname: " + lastname);
                System.out.println("=============");
            }            
            
            //4. Colse a DB Session
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

