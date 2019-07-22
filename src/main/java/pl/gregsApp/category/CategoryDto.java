package pl.gregsApp.category;

public class CategoryDto {

    private String name;
    private String type;

    public CategoryDto(){

    }
    public CategoryDto(Category category){
        this.name = category.getName();
        this.type = category.getType();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
