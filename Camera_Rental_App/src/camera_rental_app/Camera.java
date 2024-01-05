package camera_rental_app;

//Defining the Camera class to store the details of each camera
class Camera {
 private int id;
 private String brand;
 private String model;
 private double price;
 private boolean status;

 // Defining the constructor
 public Camera(int id, String brand, String model, double price) {
     this.id = id;
     this.brand = brand;
     this.model = model;
     this.price = price;
     this.status = true; // true means available, false means rented
 }

 public int getId() {
     return id;
 }

 public String getBrand() {
     return brand;
 }

 public String getModel() {
     return model;
 }

 public double getPrice() {
     return price;
 }

 public boolean getStatus() {
     return status;
 }

 public void setStatus(boolean status) {
     this.status = status;
 }

 public String toString() {
     return id + "    " + brand + "    " + model + "  " + price + "       " + (status ? "Available" : "Rented");
 }
}


