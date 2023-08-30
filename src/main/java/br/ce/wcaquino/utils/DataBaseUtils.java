package br.ce.wcaquino.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBaseUtils {
    private static Connection connect;
    
    //##### CONEXÃO DO BANCO BSCS
    public static Connection newBSCSIXConnection() {
        try {
            // Load the JDBC driver
            String portNumber="", sid="", host="", url="", username="", password="", nameService=""; 
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            portNumber = "1525";
            nameService = "BSCSIXFQA1";
            host = "snelnxm83";
            url = "jdbc:oracle:thin:@" + host + ":" + portNumber + ":" + nameService;
            username = "SYSADM";
            password = "IX1bscs$.";
            if (System.getProperty("env")=="UAT2"){
                portNumber = "1521";
                nameService = "BSCSIXFQA2";
                host = "10.152.100.3";
                url = "jdbc:oracle:thin:@" + host + ":" + portNumber + ":" + nameService;
                username = "SYSADM";
                password = "IX1bscs$.";
            } else if (System.getProperty("env")=="UAT3"){
                portNumber = "1521";
                nameService = "BSCSIXFQA3";
                host = "10.152.100.8";
                url = "jdbc:oracle:thin:@" + host + ":" + portNumber + ":" + nameService;
                username = "SYSADM";
                password = "IX1bscs$.";
            }
            connect = DriverManager.getConnection(url, username, password);
            System.out.print("Sucesso ao conectar no BD do BSCS" + "\n");
        } catch (ClassNotFoundException e) {
        	System.out.println("Ops, erro ao conectar no BD!"+e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
    
    //##### CONECTAR AO BANCO DO CRIVO
    public static Connection newCrivoConnection() {
        try {
            // Load the JDBC driver
            String url="", username="", password=""; 
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            url = "jdbc:oracle:thin:@RJOLNXF70.internal.timbrasil.com.br:1527:CRIVOQ1";
            username = "crivo";
            password = "Tim#123";
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Sucesso ao conectar no BD do CRIVO");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
    
    //##### CONECTAR AO SIBEL PRÉ - UAT1
    public static Connection newSiebelPreUAT1Connection() {
        try {
            // Load the JDBC driver
            String url="", username="", password=""; 
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            url = "jdbc:oracle:thin:@10.151.36.14:1521:SBLQA01";
            username = "siebel";
            password = "ESV_9274_dDkP_FQ1";
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Sucesso ao conectar no BD do SIEBEL PRÉ - UAT1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
    
  //##### CONECTAR AO SIBEL PRÉ - UAT2
    public static Connection newSiebelPreUAT2Connection() {
        try {
            // Load the JDBC driver
            String url="", username="", password=""; 
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            url = "jdbc:oracle:thin:@OCILNX0006.OCI.internal.timbrasil.com.br:1521:SBLQA02";
            username = "siebel";
            password = "Tim#bepre02";
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Sucesso ao conectar no BD do SIEBEL PRÉ - UAT2" + "\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
    
  //##### CONECTAR AO SIBEL PÓS - UAT1
    public static Connection newSiebelUAT1Connection() {
        try {
            // Load the JDBC driver
            String url="", username="", password=""; 
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            url = "jdbc:oracle:thin:@10.151.36.108:1521/ORAHO050c.db.siebel.oraclevcn.com";
            username = "siebel";
            password = "siebel";
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Sucesso ao conectar no BD do SIEBEL PÓS - UAT1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
      
  //##### CONECTAR AO SIBEL PÓS - UAT2
    public static Connection newSiebelUAT2Connection() {
        try {
            // Load the JDBC driver
            String url="", username="", password=""; 
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            url = "jdbc:oracle:thin:@10.151.36.160:1521/ORAHO050c.db.siebel.oraclevcn.com";
            username = "siebel";
            password = "siebel";
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("\n" + "Sucesso ao conectar no BD do SIEBEL PRÉ - UAT2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
    
  //##### CONEXÃO DO BSCS COM O P2K - UAT1
    public static Connection newBSCSUAT1Connection() {
        try {
            // Load the JDBC driver
            String portNumber = "", sid = "", host = "", url = "", username = "", password = "", nameService = "";
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            portNumber = "1525";
            nameService = "ORAHO053";
            host = "AZRLNX0298";
            url = "jdbc:oracle:thin:@" + host + ":" + portNumber + ":" + nameService;
            // Nome de usuário do banco de dados
            username = "dbcsi_p2k";
            // Senha do banco de dados
            password = "Tim#fqa298";//IX1bscs$.
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Sucesso ao conectar no BD BSCS com o P2K - UT1" + "\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Ops, erro ao conectar no BD!"+e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
    
    //##### CONEXÃO DO BSCS COM O P2K - UAT2
    public static Connection newBSCSIXUAT2Connection() {
        try {
            // Load the JDBC driver
            String portNumber="", sid="", host="", url="", username="", password="", nameService=""; 
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            // Create a connection to the database
            portNumber = "1525";
            nameService = "BSCSIXFQA2";
            host = "ocilnx0053";
            url = "jdbc:oracle:thin:@" + host + ":" + portNumber + ":" + nameService;
            username = "SYSADM";
            password = "IX1bscs$.";
            if (System.getProperty("env")=="UAT2"){
                portNumber = "1521";
                nameService = "BSCSIXFQA2";
                host = "10.152.100.3";
                url = "jdbc:oracle:thin:@" + host + ":" + portNumber + ":" + nameService;
                username = "SYSADM";
                password = "IX1bscs$.";
            } else if (System.getProperty("env")=="UAT3"){
                portNumber = "1521";
                nameService = "BSCSIXFQA3";
                host = "10.152.100.8";
                url = "jdbc:oracle:thin:@" + host + ":" + portNumber + ":" + nameService;
                username = "SYSADM";
                password = "IX1bscs$.";
            }
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Sucesso ao conectar no BD BSCS com o P2K - UT2");
        } catch (ClassNotFoundException e) {
            System.out.println("Ops, erro ao conectar no BD!"+e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ops, erro ao conectar no BD!");
        }
        return connect;
    }
    
    public ResultSet executeAndReturnFirstResult(String sql, Connection connect){
        try {
            Statement query = connect.createStatement();
            System.out.print("Executando busca : " + sql);
            // Executa Script
            ResultSet dados = query.executeQuery(sql);
            dados.next();
            return dados;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
   public boolean executeInsert(String sql, Connection connect){
        try {
            Statement query = connect.createStatement();
            System.out.print("Executando busca : " + sql);
            // Executa Script
            int dados = query.executeUpdate(sql);
            
            return dados>0;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
   
    //##### Fechar Conexão
    public static void closeConnection(){
        try {
            connect.close();
            System.out.println("\n" + "Conexão com BD fechada" + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void closeConnection(Connection conn){
        try {
            conn.close();
            System.out.println("\n" + "Conexão com BD fechada" + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
