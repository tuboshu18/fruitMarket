package njci.software.market.web;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class uploadAction extends ActionSupport{
	
	private File upload;
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	Map<String, Object> resultMap = new HashMap<String, Object>();
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public String upImg(){
		System.out.println("进入方法");
		
		if(null!=upload){
			System.out.println("进行上传");
			try {
				String realPath  = ServletActionContext.getServletContext()
                        .getRealPath("/images");
				String fileName = System.currentTimeMillis()+".jpg"; 
				File diskFile = new File(realPath + File.separator
                        + fileName);
                // 文件上传,使用FileUtils工具类
                FileUtils.copyFile(upload, diskFile);
                //System.out.println(diskFile.getAbsolutePath());
                resultMap.put("msg", "上传成功！");
                resultMap.put("code", 200);
                resultMap.put("data", diskFile.getCanonicalPath());
			} catch (Exception e) {
				e.printStackTrace();
				resultMap.put("msg", "上传失败！");
				resultMap.put("code", 405);
			}
		}else{
			resultMap.put("msg", "数据为空！");
			resultMap.put("code", 404);
		}
		return SUCCESS;
	}
}
