package com.topblog.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;


public class SerializableUtils {

	public static Object DeSerializa(String serStr)
			throws UnsupportedEncodingException, IOException,
			ClassNotFoundException {
		String redStr = java.net.URLDecoder.decode(serStr, "UTF-8");
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
				redStr.getBytes("ISO-8859-1"));
		ObjectInputStream objectInputStream = new ObjectInputStream(
				byteArrayInputStream);
		Object result = objectInputStream.readObject();
		objectInputStream.close();
		byteArrayInputStream.close();

		return result;
	}
	
	public static String Serializa(Object obj) throws IOException,
			UnsupportedEncodingException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				byteArrayOutputStream);
		objectOutputStream.writeObject(obj);
		String serStr = byteArrayOutputStream.toString("ISO-8859-1");
		serStr = java.net.URLEncoder.encode(serStr, "UTF-8");

		objectOutputStream.close();
		byteArrayOutputStream.close();
		return serStr;
	}
}