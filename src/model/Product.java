
package model;

import java.util.List;


public class Product {
    private final String name;
    private final String description;
    private final List<Image>images;

    public Product(String name, String description, List<Image> images) {
        this.name = name;
        this.description = description;
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public List<Image> getImages() {
        return images;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", description=" + description + ", images=" + images + '}';
    }
    
    
    
}
