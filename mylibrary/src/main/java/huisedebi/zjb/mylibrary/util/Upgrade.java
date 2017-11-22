package huisedebi.zjb.mylibrary.util;

public class Upgrade {
	int version;
	String feature;
	String apkurl;
	String title;
	String intro;
	String fileSize;
	int filelen;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public int getVersion()
	{
		return version;
	}

	public void setVersion(int version)
	{
		this.version = version;
	}

	public String getFeature()
	{
		return feature;
	}

	public void setFeature(String feature)
	{
		this.feature = feature;
	}

	public String getApkurl()
	{
		return apkurl;
	}

	public void setApkurl(String apkurl)
	{
		this.apkurl = apkurl;
	}

	public int getFilelen()
	{
		return filelen;
	}

	public void setFilelen(int filelen)
	{
		this.filelen = filelen;
	}

}
