package com.proctice;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class MyFileServlet
 */
@MultipartConfig
@WebServlet("/MyFileServlet")
public class MyFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part=request.getPart("file1");
		//拿到文件名
		//拿到一个输入流   要把这个流保存到磁盘中的某个文件里去
		String fileName=part.getSubmittedFileName();
		InputStream is=part.getInputStream();
		BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream("d:\\wenjian\\"+fileName));
		byte[] cache=new byte[1024*1024];
		int len=0;
		while((len=is.read(cache))!=-1) {
			os.write(cache, 0, len);
			os.flush();
			
		}
		os.close();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("已经上传完成了");
	}
	
}
