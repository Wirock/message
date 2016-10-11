package org.myproject.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TuringRobot {
	public String getRobotResponse(String message) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		String APIkey = "8f485e10536a4bcfaf29cc3749599dbf";
		URL url = null;
		String param = null;
		HttpURLConnection connection = null;
		// BufferedReader reader = null;
		// post输入输出字符流
		PrintWriter out = null;
		BufferedReader in = null;
		String response = null;
		try {
			// param = URLEncoder.encode(message, "utf-8");
			param = "key=" + APIkey + "&info=" + message;
			// String path =
			// "http://www.tuling123.com/openapi/api?key="+APIkey+"&info="+info;
			String path = "http://www.tuling123.com/openapi/api";
			url = new URL(path);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			// get连接
			// connection.connect();
			// 发送post请求设置允许输入输出
			connection.setDoInput(true);
			connection.setDoOutput(true);
			// reader = new BufferedReader(new
			// InputStreamReader(connection.getInputStream(), "utf-8"));

			out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "utf-8"));
			out.print(param);
			out.flush();

			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line = "";
			StringBuffer sb = new StringBuffer();
			// while ((line = reader.readLine()) != null) {
			// sb.append(line);
			// }
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			JSONObject result = new JSONObject(sb.toString());
			long code = result.getLong("code");
			if (code == 100000) {
				response = result.getString("text");
			}
			if (code == 200000) {
				response = result.getString("text") + "\r\n" + result.getString("url");
			}
			if (code == 302000) {
				StringBuffer temp = new StringBuffer();
				temp.append(result.getString("text")).append("\r\n");
				JSONArray list = result.getJSONArray("list");
				for (int i = 0; i < list.length(); i++) {
					String content = null;
					if (!(content = ((JSONObject) list.get(i)).getString("article")).equals("")) {
						temp.append(content).append("\r\n");
					}
					if (!(content = ((JSONObject) list.get(i)).getString("source")).equals("")) {
						temp.append(content).append("\r\n");
					}
					if (!(content = ((JSONObject) list.get(i)).getString("icon")).equals("")) {
						temp.append(content).append("\r\n");
					}
					if (!(content = ((JSONObject) list.get(i)).getString("detailurl")).equals("")) {
						temp.append(content).append("\r\n");
					}
				}
				response = temp.toString();
			}
			if (code == 308000) {
				StringBuffer temp = new StringBuffer();
				temp.append(result.getString("text")).append("\r\n");
				JSONArray list = result.getJSONArray("list");
				for (int i = 0; i < list.length(); i++) {
					String content = null;
					if (!(content = ((JSONObject) list.get(i)).getString("name")).equals("")) {
						temp.append(content).append("\r\n");
					}
					if (!(content = ((JSONObject) list.get(i)).getString("icon")).equals("")) {
						temp.append(content).append("\r\n");
					}
					if (!(content = ((JSONObject) list.get(i)).getString("info")).equals("")) {
						temp.append(content).append("\r\n");
					}
					if (!(content = ((JSONObject) list.get(i)).getString("detailurl")).equals("")) {
						temp.append(content).append("\r\n");
					}
				}
				response = temp.toString();
			}
			System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			logger.info("不支持编码类型转换");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			logger.info("生成url出错");
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("获取连接失败");
			e.printStackTrace();
		} finally {

			try {
				// if (reader != null) {
				// reader.close();
				// }
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				logger.info("输入流关闭异常");
				e.printStackTrace();
			}
			if (connection != null) {
				connection.disconnect();
			}
		}
		return response;
	}

	public static void main(String[] args) {
		TuringRobot tr = new TuringRobot();
		System.out.println(tr.getRobotResponse("中午吃什么？"));
		System.out.println(tr.getRobotResponse("新闻"));
		System.out.println(tr.getRobotResponse("美图"));
		System.out.println(tr.getRobotResponse("麻婆豆腐"));
	}
}
