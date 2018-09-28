package com.xst.model;

public class ZtreeNode {

	//id
	private Object id;
	
	//上级id
    private Object pId;
    
    //名称
    private String name;
    
    //是否开启
    private boolean open;

    //是否选中
    private boolean checked;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{id:\"");
        sb.append(id);
        sb.append("\",pId:\"");
        sb.append(pId);
        sb.append("\",name:\"");
        sb.append(name);
        sb.append("\",checked:\"");
        sb.append(checked);
        sb.append("\",open:\"");
        sb.append(open);
        sb.append("\"}");
        return sb.toString();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Object getpId() {
		return pId;
	}

	public void setpId(Object pId) {
		this.pId = pId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
