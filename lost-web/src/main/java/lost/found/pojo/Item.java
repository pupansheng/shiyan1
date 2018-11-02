package lost.found.pojo;

import java.util.Date;

public class Item {
    private Integer id;

    private String title;

    private String location;

    private Date losttime;

    private Date createtime;

    private Integer num;

    private String image;

    private Integer itemstatus;

    private Integer uid;

    private String itemdesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getLosttime() {
        return losttime;
    }

    public void setLosttime(Date losttime) {
        this.losttime = losttime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }
    
    public String [] getImages() {
    	if(image!=null&&!"".equals(image))
    	{
    		String ima []=image.split(",");
    		
    		 return ima;
    		
    		
    		
    		
    	}
    		
    		
    	return null;	
    }
    
    

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(Integer itemstatus) {
        this.itemstatus = itemstatus;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc == null ? null : itemdesc.trim();
    }

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", location=" + location + ", losttime=" + losttime
				+ ", createtime=" + createtime + ", num=" + num + ", image=" + image + ", itemstatus=" + itemstatus
				+ ", uid=" + uid + ", itemdesc=" + itemdesc + "]";
	}
}