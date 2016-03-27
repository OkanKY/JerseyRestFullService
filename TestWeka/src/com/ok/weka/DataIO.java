package com.ok.weka;


import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import weka.core.*;
import weka.filters.Filter;

public class DataIO {

    public static void main(String[] argv) throws Exception {
        // 
    	getDBConn();
    	getDatasetDB("Otherirregationinfo");
    }

    public static Connection getDBConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    Config.connString,
                    Config.connUser,
                    Config.connPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Instances getDatasetDB(String tableName) throws Exception {
        Statement st = null;
        ResultSet rs = null;
        Connection conn = getDBConn();
        String query = getFeatureQuery(tableName);
        st = conn.createStatement();
        rs = st.executeQuery(query);
        System.out.println("rs:"+rs.toString());
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("rsmd:"+rsmd.toString());
        ArrayList<Attribute> attributes = new ArrayList<Attribute>();

        int numAtts = rsmd.getColumnCount();
        for (int i = 1; i <= numAtts; i++) {
            String attName = (rsmd.getColumnName(i));
            Attribute att = new Attribute(attName);
            attributes.add(att);
        }

        Instances data = new Instances(tableName, attributes, 0);


        
//        weka.filters.unsupervised.attribute.Add addAtt = new weka.filters.unsupervised.attribute.Add();
//        addAtt.setOptions(weka.core.Utils.splitOptions("-N class -L numeric -C last"));
//       // addAtt.setAttributeName("test");
//        addAtt.setInputFormat(data);
//
//        data = Filter.useFilter(data, addAtt);
       
      weka.filters.unsupervised.attribute.Add addClimateType = new weka.filters.unsupervised.attribute.Add();
      addClimateType.setOptions(weka.core.Utils.splitOptions("-T NOM -N climateType "
      		+ "-L humid_tropical,tropical_savanna,dessert,steppe,mediterranean,"
      		+ "humid_subtropical,marine_west_coast,humid_continental,subartic,tundra,"
      		+ "ice_cap,highland -C last"));
      addClimateType.setInputFormat(data);
      data = Filter.useFilter(data, addClimateType);
      
   
      weka.filters.unsupervised.attribute.Add addSoilType = new weka.filters.unsupervised.attribute.Add();
      addSoilType.setOptions(weka.core.Utils.splitOptions("-T NOM -N soilType "+
      		"-L sand,clay,silt,loam,coarse_soil,fine_soil -C last"));
      addSoilType.setInputFormat(data);
      data = Filter.useFilter(data, addSoilType);
        
      while (rs.next()) {
          double[] values = new double[numAtts+2];
          for (int i = 1; i <= numAtts; i++) {
              values[i - 1] = rs.getDouble(i);
          }
          values[numAtts]=1;
          values[numAtts+1]=2;
          data.add(new DenseInstance(1.0, values));
      }

        return data;
    }

    private static String readFile(String path) throws Exception {
        FileInputStream stream = new FileInputStream(new File(path));
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            return Charset.defaultCharset().decode(bb).toString();
        } finally {
            stream.close();
        }
    }

    public static String getFeatureQuery(String tableName) throws Exception {
        String q = readFile(Config.sqlFilePath);
        
        q = q.replaceAll("##DataTable##", tableName);
        System.out.println(q.toString());
        return q;
    }
}
