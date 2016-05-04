package com.ok.datamining.creator.train.data;

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

import com.ok.datamining.database.DataBaseConnection;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

public abstract class ITrainCreator {
	protected Statement st = null;
	protected ResultSet rs = null;
	protected int numAtts;

	public Instances getDatasetDB(String tableName,String query) throws Exception {
		Instances data = null;
		try {

			Connection conn = DataBaseConnection.getDBConn();
			String q = getFeatureQuery(tableName,query);

			st = conn.createStatement();
			rs = st.executeQuery(q);

			ResultSetMetaData rsmd = rs.getMetaData();
			ArrayList<Attribute> attributes = new ArrayList<Attribute>();

			numAtts = rsmd.getColumnCount();
			for (int i = 1; i <= numAtts; i++) {
				String attName = (rsmd.getColumnName(i));
				Attribute att = new Attribute(attName);
				attributes.add(att);
			}
			data = new Instances(tableName, attributes, 0);
		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}

		return data;
	}

	public Instances addAttributes(Instances data) throws Exception {
		try {

			while (rs.next()) {
				double[] values = new double[numAtts];
				for (int i = 1; i <= numAtts; i++) {
					values[i - 1] = rs.getDouble(i);
				}
				data.add(new DenseInstance(1.0, values));
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
		return data;
	}

	public Instances discretize(Instances data,Integer instanceDBCount) throws Exception {
		Instances newData = null;
		try {
			// set options
			String[] options = new String[4];
			// choose the number of intervals, e.g. 2 :
			options[0] = "-B";
			options[1] = "" + (instanceDBCount);
			// choose the range of attributes on which to apply the filter:
			options[2] = "-R";
			options[3] = "last";
			// Apply discretization:
			Discretize discretize = new Discretize();
			discretize.setOptions(options);
			discretize.setInputFormat(data);
			newData = Filter.useFilter(data, discretize);

		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		} 
		return newData;
	}
	public void saveFolder(Instances data,String saveFolder) throws Exception {
		try {

			ArffSaver saver = new ArffSaver();
			saver.setInstances(data);
			saver.setFile(new File(saveFolder));
			saver.writeBatch();

		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
	}

	private String getFeatureQuery(String tableName,String query) throws Exception {
		String q = query;
		q = q.replaceAll("##DataTable##", tableName);
		return q;
	}
}
