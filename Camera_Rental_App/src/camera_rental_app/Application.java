package camera_rental_app;

import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
public class Application {
 // Declaring the static variables
 private static Scanner sc = new Scanner(System.in); 
 private static ArrayList<Camera> cameras = new ArrayList<>(); // To store the list of cameras
 private static ArrayList<User> users = new ArrayList<>(); // To store the list of users
 private static User currentUser = null;

 public static void main(String[] args) {
     // Adding some default data for testing purpose
     cameras.add(new Camera(101   , " Sony    ", "    A7C                ", 2000));
     cameras.add(new Camera(201   , " Nikon    ", "   DSLR-D3200         ", 4000));
     cameras.add(new Camera(102   , " Sony    ", "    DSLR-SLT32         ", 8000));
     cameras.add(new Camera(441   , " Canon    ", "   EOS-R8             ", 5000));
     cameras.add(new Camera(202   , " Nikon    ", "   DSLR-D7100         ", 7500));
     cameras.add(new Camera(103   , " Sony    ", "    A7IV               ", 2795));
     cameras.add(new Camera(701   , " GoPro    ", "   HERO12             ", 5000));
     cameras.add(new Camera(475   , " Panasonic  ", " LUMIC DC-ZS80D    ", 10000));
     cameras.add(new Camera(203   , " Nikon    ", "   D850               ", 800));
     cameras.add(new Camera(90     , "  FujiFilm  ", "  GFX               ", 2999));
     cameras.add(new Camera(1117, "The Rico   ", "  THETA SC2         ", 400));
     cameras.add(new Camera(187   , " INSTA X   ", "  MINI 12            ", 2500));
     cameras.add(new Camera(72     , "  Olympus    ", " Tough TG-6          ", 699));
     cameras.add(new Camera(345    , " Kodak    ", "   Z5010               ", 499));
     cameras.add(new Camera(674    , " Kodak    ", "   PIXPRO              ", 350));
     users.add(new User("admin", "admin123", 10000));
     users.add(new User("user", "user123", 10000));

     // Displaying the welcome screen
     System.out.println("+---------------------------------+");
     System.out.println("|  WELCOME TO CAMERA RENTAL APP   |");
     System.out.println("+---------------------------------+\n");
     System.out.println("PLEASE LOGIN TO CONTINUE:");

     
     login();

     mainMenu();
 }

public static void login() {
     // Taking the username and password from the user
     System.out.print("ENTER USERNAME - ");
     String username = sc.nextLine();
     System.out.print("ENTER PASSWORD - ");
     String password = sc.nextLine();

     for (User user : users) {
         currentUser = user;
     }
 }

 
 public static void mainMenu() {
     
     System.out.println("\n1. MY CAMERA");
     System.out.println("2. RENT A CAMERA");
     System.out.println("3. VIEW ALL CAMERAS");
     System.out.println("4. MY WALLET");
     System.out.println("5. EXIT");

     
     System.out.print("ENTER YOUR CHOICE - ");
     int choice = sc.nextInt();
     sc.nextLine(); 
     
     switch (choice) {
         case 1:
             myCamera();
             break;
         case 2:
             rentCamera();
             break;
         case 3:
             viewAllCameras();
             mainMenu();
         case 4:
             myWallet();
             break;
         case 5:
             exit();
             break;
         default:
             // Displaying an error message and repeating the main menu
             System.out.println("\nINVALID CHOICE. PLEASE TRY AGAIN.");
             mainMenu();
     }
 }

 
 public static void myCamera() {
     
     System.out.println("\n1. ADD");
     System.out.println("2. REMOVE");
     System.out.println("3. VIEW MY CAMERAS");
     System.out.println("4. GO TO PREVIOUS MENU");

     
     System.out.print("ENTER YOUR CHOICE - ");
     int choice = sc.nextInt();

    
     switch (choice) {
         case 1:
             addCamera();
             break;
         case 2:
             removeCamera();
             break;
         case 3:
             viewMyCameras();
             break;
         case 4:
             mainMenu();
             break;
         default:
             // Displaying an error message and repeating the myCamera method
             System.out.println("INVALID CHOICE. PLEASE TRY AGAIN.");
             myCamera();
     }
 }

 public static void addCamera() {
	   
	    System.out.println("\nENTER THE CAMERA BRAND - ");
	    sc.nextLine();
	    String brand = sc.nextLine();
	    brand = "  " + brand + "    ";
	    System.out.println("ENTER THE MODEL - ");
	    String model = sc.nextLine();
	    model = "  " + model + "           ";
	    System.out.println("ENTER PER DAY RENTAL PRICE (INR) - ");
	    double price = sc.nextDouble();
	    sc.nextLine(); 

	    // Generating a random id for the camera
	    int id = (int) (Math.random() * 1000);

	    // Creating a new camera object with the given details
	    Camera camera = new Camera(id, brand, model, price);

	    cameras.add(camera);

	    System.out.println("\nYOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
	  viewAllCameras();
	  myCamera(); 
	}


	public static void removeCamera() {
		
	    System.out.println("CAMERA LISTING:-");
	    System.out.println("----------------------------------------------------------------------------------");
	    System.out.println(" ID     BRAND          MODEL              PRICE(PER DAY)      STATUS  ");
	    System.out.println("----------------------------------------------------------------------------------");
	    for (Camera camera : cameras) {
	        System.out.println(camera);
	    }

	    System.out.println("\nENTER THE ID OF THE CAMERA TO BE REMOVED - ");
	    int id = sc.nextInt();
	    sc.nextLine(); 
	    
	    boolean removed = false;
	    for (int i = 0; i < cameras.size(); i++) {
	       
	        if (cameras.get(i).getId() == id) {
	            cameras.remove(i);
	            removed = true;
	            System.out.println("THE CAMERA HAS BEEN REMOVED FROM THE LIST.");
	            break;
	        }
	    }

	    if (!removed) {
	        System.out.println("INVALID ID! CAMERA NOT FOUND.");
	    }

	    viewAllCameras();
	    myCamera();
	}

	public static void viewMyCameras() {
	    ArrayList<Integer> defaultCameraIds = new ArrayList<>(Arrays.asList(102, 202, 701, 90, 187, 72));
	    ArrayList<Camera> myCameras = new ArrayList<>();

	    for (Camera camera : cameras) {
	        if (defaultCameraIds.contains(camera.getId())) {
	            myCameras.add(camera);
	        }
	    }

	    for (Camera camera : cameras) {
	        if (!defaultCameraIds.contains(camera.getId()) && !camera.getStatus()) {
	            myCameras.add(camera);
	        }
	    }

	    if (myCameras.isEmpty()) {
	        System.out.println("NO CAMERAS AVAILABLE.");
	    } else {
	        System.out.println("MY CAMERAS LISTING:-\n");
	        System.out.println("----------------------------------------------------------------------------------");
		    System.out.println(" ID     BRAND          MODEL              PRICE(PER DAY)      STATUS  ");
		    System.out.println("----------------------------------------------------------------------------------");
	        for (Camera camera : myCameras) {
	            String status = camera.getStatus() ? "Available" : "Rented";
	            System.out.println(camera.getId() + "   " + camera.getBrand() + "   " + camera.getModel() + "   " + camera.getPrice() + "         " + status);
	        }
	    }
	    
	    myCamera();
	}
   		 
	public static void rentCamera() {    			 
		viewAllCameras();
        			    
		System.out.print("\nENTER THE ID OF THE CAMERA TO RENT - ");
		int id = sc.nextInt();
		sc.nextLine();
		Camera selectedCamera = null;
		for (Camera camera : cameras) {
			if (camera.getId() == id) {
				selectedCamera = camera;
				break;
			}
		}

		if (selectedCamera != null) {
        			        
			if (selectedCamera.getStatus()) {
        			            
				if (currentUser.getWallet() >= selectedCamera.getPrice()) {

					double remainingBalance = currentUser.getWallet() - selectedCamera.getPrice();
					currentUser.setWallet(remainingBalance);
					selectedCamera.setStatus(false); 
					System.out.println("\nCAMERA RENTED SUCCESSFULLY!");
				} else {
					System.out.println("\nTRANSACTION FAILED!\nINSUFFICIENT AMOUNT IN THE WALLET...\nSO,TO RENT THE CAMERA KINDLY DEPOSIT THE AMOUNT TO WALLET.\n");
					myWallet();
				}
			} else {
				System.out.println("\nCAMERA IS CURRENTLY UNAVAILABLE.");
			}
		} else {
			System.out.println("\nINVALID CAMERA ID.");
		}

		mainMenu();
	}
	public static void viewAllCameras() {
		if (cameras.isEmpty()) {
			System.out.println("\nNO CAMERAS AVAILABLE.");
		} else {
			System.out.println("\nALL CAMERAS LISTING:-\n");
			System.out.println("----------------------------------------------------------------------------------");
		    System.out.println(" ID     BRAND          MODEL              PRICE(PER DAY)      STATUS  ");
		    System.out.println("----------------------------------------------------------------------------------");
			for (Camera camera : cameras) {
				String status = camera.getStatus() ? "Available" : "Rented";
				System.out.println(camera.getId() + "   " + camera.getBrand() + "   " + camera.getModel() + "   " + camera.getPrice() + "         " + status);
			}
		}
	}

	public static void myWallet() {
//Default wallet balance is set to INR.10000.0 initially
		System.out.println("\nYOUR WALLET BALANCE: " + currentUser.getWallet());
		System.out.println("1. DEPOSIT MONEY");
		System.out.println("2. BACK TO MENU");
		System.out.print("ENTER YOUR CHOICE - ");
		int choice = sc.nextInt();
		sc.nextLine(); 
		switch (choice) {
		case 1:
			System.out.println("\nENTER THE AMOUNT TO DEPOSIT - ");
			double amount = sc.nextDouble();
			sc.nextLine(); 
			currentUser.setWallet(currentUser.getWallet() + amount);
			System.out.println("DEPOSIT SUCCESSFUL!");
			break;
		case 2:
			mainMenu();
			break;
		default:
			System.out.println("INVALID CHOICE. PLEASE TRY AGAIN.\n");
			myWallet();
		}
		myWallet();
	}
	public static void exit() {
		System.out.println("\nTHANK YOU FOR USING CAMERA RENTAL APP. GOODBYE!");
		System.exit(0);
	}
}
      	