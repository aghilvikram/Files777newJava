package fileUploadDownload;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class FileUploadDownloadClass {
	@BeforeTest
	public void utility() {
		RestAssured.baseURI="http://13.234.202.14:8088";
	}
	
	
	@Test(priority=1)
	public void uploadFile(ITestContext uploadAttributes) {
		
		String response=
			given()
				.log().all()
				.contentType(ContentType.MULTIPART)
		        .multiPart("fileName", new File(".\\ImageFolder\\multipart.jpg"))
		   .when()
		        .post("/api/files/upload/database")
		   .then()
		        .assertThat()
		        .statusCode(200)
		        .extract().response().asString();
		
		System.out.println(response);
		JsonPath jp=new JsonPath(response);
		String fileid = jp.getString("fileId");
		String fileType = jp.getString("fileType");
		//filetype and fileid from uploaded file
		System.out.println("filetype: "+fileType);
		System.out.println("fileid: "+fileid);
		uploadAttributes.setAttribute("fileType", fileType);
		uploadAttributes.setAttribute("fileid", fileid);
		
	}
	@Test(priority=2)
	public void downloadFileLengthValidation(ITestContext uploadAttributes) throws IOException {
		String fileIdAttribute = (String)uploadAttributes.getAttribute("fileid");
		System.out.println("fileid: "+fileIdAttribute);
	
		byte[] downloadFile = 
				given()
				     .log().all().pathParam("fileId",fileIdAttribute ).
				when()
				     .get("/api/files/download/database/{fileId}").
				then()
				     .assertThat().statusCode(200)
				     .extract().response()
				     .asByteArray();
		
		File uploadFile=new File(".\\ImageFolder\\multipart.jpg");
		
		//uploadfile length
		long uploadFileLength = uploadFile.length();
		System.out.println("UploadFileLength: "+uploadFileLength);
		
		//downloadfilelength
		int downloadFileLength = downloadFile.length;
		System.out.println("DownloadedFileLength: "+downloadFileLength);
		Assert.assertEquals(downloadFileLength, uploadFileLength,"Both are having equal file length");
		
		
		
		
	}
	@Test(priority=3)
	public void downloadFileTypeValidation(ITestContext uploadAttributes) {
		String fileIdAttribute = (String)uploadAttributes.getAttribute("fileid");
		String uploadedfileType = (String)uploadAttributes.getAttribute("fileType");
		System.out.println("fieldid: "+fileIdAttribute);
		System.out.println("uploadedfiletype: "+uploadedfileType);
		
		
		
				Response res = given()
				     .log().all().pathParam("fileId",fileIdAttribute ).
				when()
				     .get("/api/files/download/database/{fileId}").
				then()
				     .assertThat().statusCode(200)
				     .extract().response();
	
				String downloadFileContentType = res.getContentType();
				System.out.println("uploadedfiletype: "+uploadedfileType);
				System.out.println("downloadFileContentType: "+downloadFileContentType);
				Assert.assertEquals(uploadedfileType, downloadFileContentType);
				
		
		
		

}
	@Test(priority=4)
	public void downloadFileNameValidation(ITestContext uploadAttributes) throws IOException {
		String fileIdAttribute = (String)uploadAttributes.getAttribute("fileid");
		byte[] downloadFile = 
				given()
				     .log().all().pathParam("fileId",fileIdAttribute ).
				when()
				     .get("/api/files/download/database/{fileId}").
				then()
				     .assertThat().statusCode(200)
				     .extract().response()
				     .asByteArray();
		InputStream is =new ByteArrayInputStream(downloadFile);
		String downloadFilename = URLConnection.guessContentTypeFromStream(is);
		System.out.println("downloadfilename: "+downloadFilename);
		
		File uploadFile=new File(".\\ImageFolder\\multipart.jpg");
		String uploadFileName = uploadFile.getName();
		System.out.println("uploadfilename: "+uploadFileName);
		}
	}
