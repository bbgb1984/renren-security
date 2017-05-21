package io.renren.enums;

public enum StatusEnum {
	ING("进行中", 1), STOP("已停用", 0);
	
	private String name ;
    private int index ;
     
    private StatusEnum( String name , int index ){
        this.name = name ;
        this.index = index ;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public static void main(String[] args) {
    	System.out.println(StatusEnum.ING.getName());
	}
}

